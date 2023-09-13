import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link, useNavigate } from 'react-router-dom';
export default function DefaultCreateCard() {
    const navigate = useNavigate();

    const [status, setStatus] = useState([{
        code: null,
        name: null
    }]);

    const [createCard, setCreateCard] = useState({
        title: null,
        description: null,
        status: {
            code : null,
            name: null
        },
        owner: "admin",
        noteType: "DEFAULT"
    })

    const onChange = e => {
        const { name, value } = e.target;
        setCreateCard(prev => ({ ...prev, [name]: value }))
    }

    const onStatusChange = e => {
        const { value } = e.target;

        let lba = status.find(item => item.code === value)
        setCreateCard(prev => (
            {
                ...prev,
                status: {
                    code: lba.code,
                    name: lba.name
                }
            }));
    }


    const handleSave = async e => {
        e.preventDefault();
        try {
            const response = await axios.post("http://localhost:8080/card/create", createCard);
            if (response.status === 200) {
                navigate('/area', { state: { redirect: true } })
            }

        } catch (err) {
            console.log(err)
        }
    }


    const getStatusList = async () => {
        try {
            const response = await axios.get("http://localhost:8080/status/all");
            setStatus(response.data);
            setDefaultStatus(response.data[0])
        } catch (err) {
            console.log(err)
        }
    }


    useEffect(() => {
        getStatusList();
    }, [navigate.state]);

    const setDefaultStatus = (status) => {
        setCreateCard(prev => (
            {
                ...prev,
                status: {
                    code: status.code,
                    name: status.name
                }
            }));
    }

    return (
        <div>
            <h4 className='mb-3'>Create Card</h4>
            <form>
                <input className="form-control form-control-sm mb-3" type="text" name='title' onChange={onChange} placeholder="Title" />
                <input className="form-control form-control-sm mb-3" type="text" name='description' onChange={onChange} placeholder="Description" />
                <select className='form-select mb-3' onChange={onStatusChange}>
                    {status.map(stat => (<option value={stat.code}>{stat.name}</option>))}
                </select>
            </form>
            <div className="row">
                <div className="col d-grid gap-2">
                    <button className="btn btn-success" onClick={handleSave}>Create</button>
                </div>
                <div className="col d-grid gap-2">
                    <Link className="btn btn-danger" to="/area" >Cancel</Link>
                </div>
            </div>
        </div>
    )
}
