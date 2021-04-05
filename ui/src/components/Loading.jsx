import React, { Component } from 'react';
import { Spinner } from 'react-bootstrap';

class Loading extends Component {
    render() {
        return (
            <div>
                <Spinner animation="border" />
            </div>
        );
    }
}

export default Loading;