import * as React from 'react'
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav'
import { LinkContainer } from 'react-router-bootstrap'

import '../App.css'
import stravaLogo from '../api_logo_pwrdBy_strava_horiz_gray.svg'

export function Header() {
    return (
        <Navbar bg="dark" variant="dark">
            <Nav className="mr-auto">
                <LinkContainer to="/dashboard/punchcard">
                    <Nav.Link>Punchcard</Nav.Link>
                </LinkContainer>
                <LinkContainer to="/dashboard/distances">
                    <Nav.Link href="#distances">Distances</Nav.Link>
                </LinkContainer>
            </Nav>
            <Navbar.Brand>
                <img
                src={stravaLogo}
                height="42"
                width="225"
                alt="Powered by Strava"
                className="d-inline-block"
                />
            </Navbar.Brand>
        </Navbar>
    )
}
