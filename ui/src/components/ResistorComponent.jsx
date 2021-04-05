import React, { Component } from 'react';
import { Tabs, Tab, Jumbotron } from 'react-bootstrap';
import ResistorServices from '../services/ResistorServices';
import FiveBandComponent from './FiveBandComponent';
import FourBandComponent from './FourBandComponent';
import Loading from './Loading';

class ResistorComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            colorBandValues: [], mulitiplierValue: [],
            toleranceValue: []
        }
    }

    componentDidMount() {
        ResistorServices.retrieveColorBandValues()
            .then((response) => {
                this.setState({
                    colorBandValues: response.data
                });
            });

        ResistorServices.retrieveMultiplierValues()
            .then((response) => {
                this.setState({
                    mulitiplierValue: response.data
                });
            });

        ResistorServices.retrieveToleranceValues()
            .then((response) => {
                this.setState({
                    toleranceValue: response.data
                });
            });
    }

    render() {
        const { colorBandValues, mulitiplierValue, toleranceValue } = this.state;
        if (colorBandValues.length > 0
            && mulitiplierValue.length > 0
            && toleranceValue.length > 0) {
            return (
                <Jumbotron>
                    <h5>Number Of Bands</h5>
                    <Tabs defaultActiveKey="4Band" id="number-of-bands">
                        <Tab eventKey="4Band" title="4 Band">
                            <FourBandComponent
                                colorBandValues={colorBandValues}
                                mulitiplierValue={mulitiplierValue}
                                toleranceValue={toleranceValue}
                            />
                        </Tab>
                        <Tab eventKey="5Band" title="5 Bands">
                            <FiveBandComponent
                                colorBandValues={colorBandValues}
                                mulitiplierValue={mulitiplierValue}
                                toleranceValue={toleranceValue}
                            />
                        </Tab>
                    </Tabs>
                </Jumbotron>
            );
        } else {
            return (
                <Loading />
            );
        }
    }
}

export default ResistorComponent;