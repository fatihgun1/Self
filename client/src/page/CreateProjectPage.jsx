import React, { useState } from 'react'
import { Link ,useNavigate,redirect } from 'react-router-dom'
import axios from "axios"
export default function CreateProjectPage() {
  
  const [projectName,setProjectName] = useState();
  const navigate = useNavigate();
  
  const handleChange = e => {
    setProjectName(e.target.value)
  }

  const handleSave = async e => {
    e.preventDefault();
    try{
      const response = await axios.post("http://localhost:8080/project/create",{
        name : projectName
      });
      if(response.status === 200){
        navigate('/')
      }
      
    }catch(err){
      console.log(err)
    }

  }

  return (
    <div className='container'>
      <div className="row mb-5">
        <div className="col">
          <h2>Create Project</h2>
        </div>
      </div>
      <div className="row mb-5">
        <div className="col">
          <form g-3>
            <div className="row">
              <div className="col-3">
                <label className="form-label">Project Name</label>
              </div>
              <div className="col">
                <input type="text" onChange={handleChange} class="form-control" />
              </div>
            </div>
          </form>
        </div>
      </div>
      <div className="row">
        <div className="col d-grid gap-2">
          <button type="button" class="btn btn-success" onClick={handleSave}>Create</button>
        </div>
        <div className="col d-grid gap-2">
          <Link class="btn btn-danger" to="/" >Cancel</Link>
        </div>
      </div>
    </div>
  )
}
