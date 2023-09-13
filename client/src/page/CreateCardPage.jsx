import React, { useEffect, useState } from 'react'
import DefaultCreateCard from '../component/Card/DefaultCreateCard';
import NoteCreateCard from '../component/Card/NoteCreateCard';
import VideoCreateCard from '../component/Card/VideoCreateCard';

export default function CreateCardPage() {

    const [cardType, setCardType] = useState("DEFAULT");


    let types = ["DEFAULT", "NOTE", "VIDEO"];

    const onChange = e => {
        setCardType(e.target.value);
    }
    useEffect(() => {

    }, [cardType]);
    return (
        <div className='container'>
            <div className="row mb-4">
                <div className="col-3">
                    <p className='fw-bold'>Choose Card Type</p>
                </div>
                <div className="col">
                    <select className='form-select' onChange={onChange}>
                        {types.map(type => (<option value={type}>{type}</option>))}
                    </select>
                </div>
            </div>

            {cardType === 'DEFAULT' &&
                <DefaultCreateCard />
            }
            {cardType === 'NOTE' &&
                <NoteCreateCard />
            }
            {cardType === 'VIDEO' &&
                <VideoCreateCard />
            }
        </div>
    )
}
