import React from 'react'

export default function VideoNoteEntity({ time, description }) {
    return (
        <>
            {time &&
                <div className='card mb-2'>
                    <div className="card-body">
                        <div className="row">
                            <div className="col-2">
                                {time}
                            </div>
                            <div className="col">
                                {description}
                            </div>
                        </div>
                    </div>
                </div>
            }
        </>
    )
}
