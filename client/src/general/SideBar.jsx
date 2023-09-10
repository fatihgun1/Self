import React, { useEffect, useState } from 'react'
import ProjectEntity from '../component/page/ProjectEntity'
import axios from 'axios';
export default function () {
    const [project,setProject] = useState([
        {
            code : null,
            name : null
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
      }, []);
    

    return (
        <div className='container text-bg-light min-vh-100'>
            <div class="offcanvas-header ">
                <h5 class="offcanvas-title">Projects</h5>
            </div>
            <div class="offcanvas-body">
                {project && project.map(prj => (
                    <ProjectEntity code={prj.code} name={prj.name} />
                ))}
            </div>
        </div>
    )
}
