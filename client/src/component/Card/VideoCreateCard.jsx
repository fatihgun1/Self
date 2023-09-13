import React, { useState,useEffect } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom';
import YouTube from 'react-youtube';
import axios from 'axios'
export default function VideoCreateCard() {
    const navigate = useNavigate();
    const { code } = useParams();
    const [videoUrl, setVideUrl] = useState()
    const [createCard, setCreateCard] = useState({
        title: null,
        description: null,
        video: null,
        status: {
            code: null,
            name: null
        },
        owner: "admin",
        noteType: "VIDEO"
    })
    const onChange = e => {
        const { name, value } = e.target;
        if (name === 'video') {
            var url = value;
            if (url.includes("watch?v=")) {
                let urlPaths = url.split("watch?v=")
                var yCode = urlPaths[urlPaths.length - 1];
                if (yCode) {
                    setVideUrl(yCode)
                    setCreateCard(prev => ({ ...prev, video: yCode }))
                }
            }
        } else {
            setCreateCard(prev => ({ ...prev, [name]: value }))
        }
    }

    const onPlayerReady = (event) => {
        event.target.pauseVideo();
    }

    const opts = {
        height: '390',
        width: '100%',
        playerVars: {
            autoplay: 0,
            start: 0
        },
    };

    const saveNote = async (e) => {
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
            <h4>Create Video Card</h4>
            <form className="row g-3">
                <div className="col-auto">
                    <input className="form-control mb-3" type="text" name='title' onChange={onChange} placeholder="Title" />
                </div>
                <div className="col">
                    <input type="text" className="form-control" name='video' onChange={onChange} placeholder='Youtube URL' />
                </div>
                <div className="col-auto">
                    <button type="submit" onClick={saveNote} className="btn btn-primary mb-3">Save Video</button>
                </div>
                <div className="col-auto">
                    <Link className="btn btn-danger" to="/area" >Cancel</Link>
                </div>

            </form>
            <div className="row">
                <div className="col">
                    {videoUrl &&
                        <YouTube videoId={videoUrl} opts={opts} onReady={onPlayerReady} />
                    }
                </div>
            </div>

        </div>
    )
}
