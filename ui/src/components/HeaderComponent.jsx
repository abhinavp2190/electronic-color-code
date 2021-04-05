import React, { Component } from 'react';
import { Navbar } from 'react-bootstrap';

class HeaderComponent extends Component {
    render() {
        return (
            <div>
                <header>
                    <Navbar bg="dark" variant="dark">
                        <Navbar.Brand href="#">Resistor Color Code Calculator</Navbar.Brand>
                    </Navbar>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;