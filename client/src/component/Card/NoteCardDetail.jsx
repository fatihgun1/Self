import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom'
import axios from 'axios'
export default function NoteCardDetail({ code, title, description }) {
    const navigate = useNavigate();

    const onChange = e => {

    }

    const handleSave = e => {

    }

    const onDeleteButtonClick = async e => {
        e.preventDefault();
        try {
          const response = await axios.delete(`http://localhost:8080/card/delete/${code}`);
          navigate("/area", { state: { redirect: true } })
        } catch (err) {
          console.log(err)
        }
      }

    useEffect(() => {

    }, []);


    return (
        <div>
            <h4 className='mb-3'>Create Note Card</h4>
            <form>
                <input className="form-control form-control-sm mb-3" type="text" name='title' onChange={onChange} placeholder="Title" value={title} />
                <input className="form-control form-control-sm mb-3" type="text" name='description' onChange={onChange} placeholder="Description" value={description} />
            </form>
            <div className="row">
                <div className="col d-grid gap-2">
                    <button type="button" className="btn btn-success" onClick={handleSave}>Save</button>
                </div>
                <div className="col d-grid gap-2">
                    <button type='button' onClick={onDeleteButtonClick} className="btn btn-danger" to="/area" >Delete</button>
                </div>
                <div className="col d-grid gap-2">
                    <Link className="btn btn-primary" to="/area" >Cancel</Link>
                </div>
            </div>
        </div>
    )
}