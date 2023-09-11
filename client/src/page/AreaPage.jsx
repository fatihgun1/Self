import React, { useEffect, useState } from 'react'
import StatusEntity from '../component/status/StatusEntity'
import axios from 'axios'
import { Link } from 'react-router-dom';
export default function AreaPage() {
  
  const style = {
    "flex-wrap": "nowrap",
    "overflow-x": "scroll"
  }

  const [status, setStatus] = useState([{
    code: null,
    name: null
  }]);

  const getAreaList = async () => {
    try {
      const response = await axios.get("http://localhost:8080/status/all");
      setStatus(response.data)
    } catch (err) {
      console.log(err)
    }
  }

  useEffect(() => {
    getAreaList();
  }, []);

  return (
    <div className="container">
      <div className="row">
        <div className="col mb-4">
          <Link to="/status/create" className='btn btn-outline-dark'>Status Create</Link>
          <Link to="/status/manage" className='btn btn-outline-dark'>Manage Status</Link>
        </div>
      </div>
      <div className="row">
        <div className="col">
          <div className='row' style={style} >
            {status && status.map(stat => (
              <StatusEntity code={stat.code} name={stat.name} />
            ))}
          </div>
        </div>
      </div>
    </div>
  )
}
