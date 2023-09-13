import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import axios from 'axios'
export default function DefaultCardDetail({ code, title, description, status_code, status_name, owner, note_type }) {
  const navigate = useNavigate();
  const [status, setStatus] = useState([{
    code: null,
    name: null
  }]);

  const getStatusList = async () => {
    try {
      const response = await axios.get("http://localhost:8080/status/all");
      setStatus(response.data);
    } catch (err) {
      console.log(err)
    }
  }

  const onStatusChange = e => {
    const { value } = e.target;

    let lba = status.find(item => item.code === value)
    setStatus(prev => (
      {
        ...prev,
        code: lba.code,
        name: lba.name
      }));
  }

  const onDeleteButtonClick = async e => {
    e.preventDefault();
    try {
      const response = await axios.delete(`http://localhost:8080/card/delete/${code}`);
      navigate("/area", { state: { redirect: true } })
    } catch (err) {
      console.log(err)
    }
  }

  useEffect(() => {
    getStatusList();
  }, []);

  return (
    <div className='container'>
      <h4 className='mb-3'>Edit</h4>
      <form>
        <input className="form-control form-control-sm mb-3" type="text" name='title' placeholder="Title" value={title} />
        <input className="form-control form-control-sm mb-3" type="text" name='description' placeholder="Description" value={description} />
        <input readonly className="form-control-plaintext mb-3" type="text" name='owner' placeholder="Description" value={owner} />
        <input readonly className="form-control-plaintext mb-3" type="text" name='note_type' value={note_type} />
        <select className='form-select mb-3' onChange={onStatusChange}  >
          {status.map(stat => {
            return status_code === stat.code ?
              <option selected value={stat.code}>{stat.name}</option>
              :
              <option value={stat.code}>{stat.name}</option>
          })}
        </select>
      </form>

      <div className="row">
        <div className="col d-grid gap-2">
          <button className="btn btn-success">Save</button>
        </div>
        <div className="col d-grid gap-2">
          <button type='button' onClick={onDeleteButtonClick} className="btn btn-danger" to="/area" >Delete</button>
        </div>
        <div className="col d-grid gap-2">
          <Link className="btn btn-primary" to="/area" >Cancel</Link>
        </div>
      </div>
    </div>
  )
}
