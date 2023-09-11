import React from 'react'
import axios from 'axios'
import { useNavigate} from 'react-router-dom'
export default function ProjectEntity({ code, name }) {
    
    const navigate = useNavigate();

    const onClickDeleteButton = async e =>{
        e.preventDefault();
        try{
            const response = await axios.delete(`http://localhost:8080/project/delete/${code}`);
            navigate({state: {redirect: true}})
        }catch(err){
            console.log(err)
        }
    }

    return (
        <div className="container p-1 mb-1 border-bottom" key={code} >
            {code &&
                <div className="row w-100">
                    <div className="col">
                        {name}
                    </div>
                    <div className="col-2">
                        <button type='button' onClick={onClickDeleteButton} className="btn-close btn-sm btn-outline-danger"  aria-label="Close"></button>
                    </div>
                </div>
            }
        </div>

    )
}
