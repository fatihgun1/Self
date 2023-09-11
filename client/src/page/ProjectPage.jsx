import React, { useEffect, useState } from 'react'
import AreaEntity from '../component/project/AreaEntity'
import axios from 'axios';
import { Link, useLocation } from 'react-router-dom';

export default function ProjectPage() {
  const location = useLocation();
  const [areas, setAreas] = useState([
    {
      code: null,
      name: null
    }
  ]);

  const getAreaList = async () => {
    try {
      const response = await axios.get("http://localhost:8080/area/all");
      setAreas(response.data);
    } catch (err) {
      console.log(err)
    }
  }

  useEffect(() => {
    getAreaList();
  }, [location.state]);

  return (
    <div className='container'>
      <div className="row">
        <div className="col">
          <div className="row mb-4 border">
            <div className="col w-100 d-grid"></div>
            <div className="col-3  d-grid m-2">
              <Link to="/area/create" type="button" className="btn btn-sm btn-outline-success">Create Area</Link>
            </div>
          </div>
        </div>
      </div>
      <div className="container">
        <div className="row mb-4">
          {areas.map(area => (
            <div className="col-xs-6 col-sm-4 col-md-4 mb-4">
              <AreaEntity code={area.code} name={area.name} />
            </div>
          ))}
        </div>
      </div>
    </div>
  )
}
