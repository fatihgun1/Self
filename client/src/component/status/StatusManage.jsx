import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link, useNavigate } from 'react-router-dom';
import StatusListEntity from './StatusListEntity';
export default function StatusManage() {
    const navigate = useNavigate();
    const [status, setStatus] = useState([{
        code: null,
        name: null
    }]);

    const getStatusList = async () => {
        try {
            const response = await axios.get("http://localhost:8080/status/all");
            setStatus(response.data)
        } catch (err) {
            console.log(err)
        }
    }

    useEffect(() => {
        getStatusList();
    }, [navigate.status]);

    return (
        <div>
            <div className='row' >
                <div className="col">
                    {status && status.map(stat => (
                        <StatusListEntity code={stat.code} name={stat.name} />
                    ))}
                </div>
            </div>

            <div className="row">
                <div className="col d-grid gap-2">
                </div>
                <div className="col d-grid gap-2">
                    <Link className="btn btn-danger" to="/area" >Go Back</Link>
                </div>
            </div>
        </div>
    )
}
