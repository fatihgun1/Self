import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import DefaultCardDetail from '../component/Card/DefaultCardDetail';
import axios from 'axios'
import NoteCardDetail from '../component/Card/NoteCardDetail';
import VideoCardDetail from '../component/Card/VideoCardDetail';
export default function CardDetailPage() {
    const { code } = useParams();

    const [card, setCard] = useState({
        code: null,
        title: null,
        description: null,
        video: null,
        status: {
            code: null,
            name: null
        },
        owner: null,
        noteType: null
    })

    const getCart = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/card/get/${code}`);
            setCard(response.data)
            console.log(response.data)
        } catch (err) {
            console.log(err)
        }
    }

    useEffect(() => {
        getCart()
    }, []);
    return (
        <div className='container'>
            {card.noteType === 'DEFAULT' &&
                <DefaultCardDetail
                    code={card.code}
                    title={card.title}
                    description={card.description}
                    status_code={card.status.code}
                    status_name={card.status.name}
                    owner={card.owner}
                    note_type={card.noteType}
                />
            }
            {card.noteType === 'NOTE' &&
                <NoteCardDetail
                    code={card.code}
                    title={card.title}
                    description={card.description} />
            }
            {card.noteType === 'VIDEO' &&
                <VideoCardDetail
                    code={card.code}
                    title={card.title}
                    description={card.description}
                    video={card.video}/>
            }
        </div>
    )
}
