import React, { useState } from 'react'
import { Link, useNavigate} from 'react-router-dom'
import axios from "axios"
export default function CreateAreaPage() {

  const [projectName, setProjectName] = useState();
  const navigate = useNavigate();

  const handleChange = e => {
    setProjectName(e.target.value)
  }

  const handleSave = async e => {
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:8080/area/create", {
        name: projectName
      });
      if (response.status === 200) {
        navigate('/',{state: {redirect: true}})
      }

    } catch (err) {
      console.log(err)
    }

  }

  return (
    <div className='container'>
      <div className="row mb-5">
        <div className="col">
          <h2>Create Area</h2>
        </div>
      </div>
      <div className="row mb-5">
        <div className="col">
          <form className='g-3'>
            <div className="row">
              <div className="col-3">
                <label className="form-label">Area Name</label>
              </div>
              <div className="col">
                <input type="text" onChange={handleChange} className="form-control" />
              </div>
            </div>
          </form>
        </div>
      </div>
      <div className="row">
        <div className="col d-grid gap-2">
          <button type="button" className="btn btn-success" onClick={handleSave}>Create</button>
        </div>
        <div className="col d-grid gap-2">
          <Link className="btn btn-danger" to="/" >Cancel</Link>
        </div>
      </div>
    </div>
  )
}
