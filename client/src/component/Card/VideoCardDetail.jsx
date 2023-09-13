import React, { useState, useEffect } from 'react'
import { Link, useNavigate } from 'react-router-dom';
import YouTube from 'react-youtube';
import axios from 'axios'
import VideoNoteEntity from './VideoNoteEntity';
export default function VideoCardDetail({ code, title, description, video }) {
    const navigate = useNavigate();

    const [note, setNote] = useState({
        time: null,
        description: null
    });

    const [notes, setNotes] = useState([{
        time: null,
        description: null
    }]);

    const onPlayerReady = (event) => {
        event.target.pauseVideo();
    }
    const onPlayerPlat = (event) => {
        event.target.startVideo();
    }

    const opts = {
        height: '390',
        width: '100%',
        playerVars: {
            autoplay: 0,
            start: 0
        },
    };


    const onChange = e => {

    }

    const onNoteChange = e => {
        const { name, value } = e.target;
        if (name === 'time') {
            setNote(prev => (
                {
                    ...prev,
                    time: value,
                }))
        } else {
            setNote(prev => (
                {
                    ...prev,
                    description: value,
                }))
        }
    }

    const handleSave = e => {

    }

    const saveNote = async (e) => {
        e.preventDefault();
    }

    const onSaveNote = () => {
        console.log(notes)
        setNotes(prev => [
            ...prev,
            note])
    }

    const resolveTime = (time) => {
        var rawTime = time.split(':');
        return (+rawTime[0]) * 60 + (+rawTime[1]);
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
            <h4>{title}</h4>

            <div className="row">
                <div className="col">
                    <YouTube videoId={video} opts={opts} onReady={onPlayerReady} onPlay={onPlayerPlat} />
                </div>
            </div>

            <div className="row">
                <hr class="border border-primary border-1 opacity-75"></hr>
                <div className="col-2">
                    <input className="form-control mb-3" name="time" type="text" onChange={onNoteChange} placeholder="Time" />
                </div>
                <div className="col">
                    <input className="form-control mb-3" name='noteDescription' type="text" onChange={onNoteChange} placeholder="Add your note" />
                </div>
                <div className="col-2">
                    <button type='button' onClick={onSaveNote} className='btn btn-primary'>Save</button>
                </div>
                <hr class="border border-primary border-1 opacity-75"></hr>
            </div>

            <div className="row mb-4">
                {Object.values(notes).map((n, index) => {
                    return <VideoNoteEntity time={n.time} description={n.description} key={index} />
                })}
            </div>


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
