import React from 'react'

export default function StatusEntity({ code, name }) {
    const style = {
        "height" : "100px",
        "width" : "12rem"
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
                        <div className="col">body</div>
                    </div>
                </div>
            }
        </>
    )
}
