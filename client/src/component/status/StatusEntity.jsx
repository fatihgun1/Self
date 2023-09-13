import React from 'react'
import CardArea from '../Card/CardArea'

export default function StatusEntity({ code, name }) {
    const style = {
        "width": "12rem"
    }
    return (
        <>
            {code &&
                <div className='me-2' style={style} key={code}>
                    <div className="row border">
                        <div className="col">
                            {name}
                        </div>
                    </div>
                    <div className="row border">
                        <div className="col m-0">
                            <CardArea code={code} />
                        </div>
                    </div>
                </div>
            }
        </>
    )
}
