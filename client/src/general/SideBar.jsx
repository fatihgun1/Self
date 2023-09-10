import React, { useEffect, useState } from 'react'
import ProjectEntity from '../component/project/ProjectEntity'
import axios from 'axios';
import { Link, useLocation } from 'react-router-dom';
export default function () {


    const location = useLocation();

    const [project, setProject] = useState([
        {
            code: null,
            name: null
        }
    ]);

    const getProjectList = async () => {
        try {
            const response = await axios.get("http://localhost:8080/project/all");
            setProject(response.data)
        } catch (err) {
            console.log(err)
        }
    }
    useEffect(() => {
        getProjectList();
     
    }, [location.state]);


    return (
        <div className='container text-bg-light min-vh-100'>
            <div className="offcanvas-header ">
                <div className="row w-100">
                    <div className="col">
                        <h5 className="offcanvas-title">Projects</h5>
                    </div>
                    <div className="col-2">
                        <Link to='/project/create' className="btn btn-sm btn-outline-danger">Add</Link>
                    </div>
                </div>

            </div>
            <div className="offcanvas-body">
                {project && project.map(prj => (
                    <ProjectEntity code={prj.code} name={prj.name} />
                ))}
            </div>
        </div>
    )
}
