import React, { useEffect, useState } from 'react'
import CardEntity from './CardEntity'
import axios from 'axios'
import { Link, Route, Router } from 'react-router-dom';
export default function CardArea({ code }) {
    const [cards, setCards] = useState([{
        code: null,
        title: null
    }]);

    const getCardList = async () => {
        try {
            const response = await axios.get("http://localhost:8080/card/all");
            setCards(response.data)
        } catch (err) {
            console.log(err)
        }
    }

    useEffect(() => {
        getCardList();
    }, []);

    return (
        <div className='row p-0 m-0'>
            <div className="row pb-2">
                {code &&
                    
                        <div className="col m-0 p-0">

                            {cards && cards.map(card => (
                                <Link to={`/card/get/${card.code}`}>
                                    <CardEntity name={card.title} />
                                </Link>
                            ))}

                        </div>
                }
            </div>
            <div className="row">
                <div className="col d-grid m-0 p-0">
                    <Link to={`/card/create/${code}`} className='btn btn-outline-primary' > Creare Card </Link>
                </div>
            </div>
        </div>
    )
}
