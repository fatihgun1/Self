import React from 'react'

export default function CardEntity({ name }) {
    return (
        <div>
            <div className="row border">
                <div className="col">
                    {name}
                </div>
            </div>
        </div>
    )
}
