import React from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom';
export default function StatusListEntity({ code, name }) {
    const navigate = useNavigate();
    
    const onClickDeleteButton = async e => {
        e.preventDefault();
        try {
            const response = await axios.delete(`http://localhost:8080/status/delete/${code}`);
            navigate("/status/manage", { state: { redirect: true } })
        } catch (err) {
            console.log(err)
        }
    }
    return (
        <div>
            <div className="card mb-2" key={code}>
                <div className="card-body">
                    <div className="row w-100">
                        <div className="col">
                            {name}
                        </div>
                        <div className="col-1">
                            <button type='button' onClick={onClickDeleteButton} className="btn-close btn-sm btn-outline-danger" aria-label="Close"></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}
