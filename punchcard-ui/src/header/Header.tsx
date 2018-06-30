import * as React from 'react'

import '../App.css'
import logo from '../logo.svg'

export function Header() {
    return (
        <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <h1 className="App-title">Your Running Punchcard</h1>
        </header>
    )
}
