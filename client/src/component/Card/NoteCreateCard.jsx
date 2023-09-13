import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom'
import axios from 'axios'
export default function NoteCreateCard() {
    const navigate = useNavigate();
    const { code } = useParams();
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

    const [createCard, setCreateCard] = useState({
        title: null,
        description: null,
        status: {
            code: null,
            name: null
        },
        owner: "admin",
        noteType: "NOTE"
    })

    const onChange = e => {
        const { name, value } = e.target;
        setCreateCard(prev => ({ ...prev, [name]: value }))
        console.log(createCard)
    }

    const findStatus = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/status/get/${code}`);
            setDefaultStatus(response.data)
        } catch (err) {
            console.log(err)
        }
    }

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

    useEffect(() => {
        findStatus();
    }, [navigate.state]);


    return (
        <div>
            <h4 className='mb-3'>Create Note Card</h4>
            <form>
                <input className="form-control form-control-sm mb-3" type="text" name='title' onChange={onChange} placeholder="Title" />
                <input className="form-control form-control-sm mb-3" type="text" name='description' onChange={onChange} placeholder="Description" />
            </form>
            <div className="row">
                <div className="col d-grid gap-2">
                    <button type="button" className="btn btn-success" onClick={handleSave}>Create</button>
                </div>
                <div className="col d-grid gap-2">
                    <Link className="btn btn-danger" to="/area" >Cancel</Link>
                </div>
            </div>
        </div>
    )
}