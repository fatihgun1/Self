import React from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom';
export default function AreaEntity({ code, name }) {
    const styles = {
        "max-width": "12rem",
        "height": '6rem',
    };

    const navigate = useNavigate();

    const onClickDeleteButton = async e =>{
        e.preventDefault();
        try{
            const response = await axios.delete(`http://localhost:8080/area/delete/${code}`);
            navigate("/",{state: {redirect: true}})
        }catch(err){
            console.log(err)
        }
    }
    return (
        <div className='card text-center text-bg-dark ms-2' style={styles} >
            <div class="row justify-content-end">
                <div class="col-4">
                    <button type="button btn" onClick={onClickDeleteButton} class="btn-close" aria-label="Close"></button>
                </div>
            </div>
            <div className="card-body">
                {name}
            </div>
        </div>
    )
}
