import React from 'react'

export default function ProjectEntity({ code, name }) {
    return (
        <div class="container p-1 mb-1 border-bottom" key={code} >
            {name}
        </div>
    )
}
