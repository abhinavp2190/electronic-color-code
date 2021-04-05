import React, { Component } from 'react';
import { Form, Container, Row, Col, Card } from 'react-bootstrap';
import ResistorServices from '../services/ResistorServices';

class FiveBandComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            colorBandValues: props.colorBandValues,
            mulitiplierValue: props.mulitiplierValue,
            toleranceValue: props.toleranceValue,
            firstColor: '', secondColor: '', thirdColor: '',
            multiplier: '', tolerance: '',
            resultValue: null
        }
        this.conditionalResultRender = this.conditionalResultRender.bind(this);
    }

    handleChange(event) {
        if (event.target.value !== "EMPTY") {
            switch (event.target.name) {
                case 'firstColor':
                    this.setState({
                        firstColor: event.target.value
                    }, function () {
                        this.fetchResult();
                    });
                    break;
                case 'secondColor':
                    this.setState({
                        secondColor: event.target.value
                    }, function () {
                        this.fetchResult();
                    });
                    break;
                case 'thirdColor':
                    this.setState({
                        thirdColor: event.target.value
                    }, function () {
                        this.fetchResult();
                    });
                    break;
                case 'multiplier':
                    this.setState({
                        multiplier: event.target.value
                    }, function () {
                        this.fetchResult();
                    });
                    break;
                case 'tolerance':
                    this.setState({
                        tolerance: event.target.value
                    }, function () {
                        this.fetchResult();
                    });
                    break;
                default:
            }
        }
    }

    fetchResult = () => {
        const { firstColor, secondColor, thirdColor, multiplier, tolerance } = this.state;
        if (firstColor && secondColor && thirdColor && multiplier && tolerance) {
            ResistorServices.retrieve5Band(firstColor, secondColor, thirdColor, multiplier, tolerance)
                .then((response) => {
                    this.setState({
                        resultValue: response.data
                    });
                });
        }
    }

    conditionalResultRender = (resultValue) => {
        if (resultValue) {
            return (<span> {resultValue.ohm}&#8486; &plusmn; {resultValue.tolerance} %</span>);
        } else {
            return (<span></span>);
        }
    }

    render() {
        const { colorBandValues, mulitiplierValue, toleranceValue, resultValue } = this.state;
        return (
            <Container>
                <Row>
                    <Col>
                        <br />
                        <h5>Resistor Parameters</h5>
                        <br />

                        <Form.Group>
                            <Form.Label>1st Band of Colors</Form.Label>
                            <Form.Control
                                as="select"
                                name="firstColor"
                                defaultValue="EMPTY"
                                onChange={this.handleChange.bind(this)}
                            >
                                <option value="EMPTY" selected disabled hidden>Select a Color</option>
                                {
                                    colorBandValues.map(colorBand => {
                                        return (
                                            <option key={colorBand.value} className={colorBand.color} value={colorBand.color}>{colorBand.color} ({colorBand.value})</option>
                                        )
                                    })
                                }
                            </Form.Control>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>2nd Band of Colors</Form.Label>
                            <Form.Control
                                as="select"
                                name="secondColor"
                                defaultValue="EMPTY"
                                onChange={this.handleChange.bind(this)}
                            >
                                <option value="EMPTY" selected disabled hidden>Select a Color</option>
                                {
                                    colorBandValues.map(colorBand => {
                                        return (
                                            <option key={colorBand.value} className={colorBand.color} value={colorBand.color}>{colorBand.color} ({colorBand.value})</option>
                                        )
                                    })
                                }
                            </Form.Control>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>3rd Band of Colors</Form.Label>
                            <Form.Control
                                as="select"
                                name="thirdColor"
                                defaultValue="EMPTY"
                                onChange={this.handleChange.bind(this)}
                            >
                                <option value="EMPTY" selected disabled hidden>Select a Color</option>
                                {
                                    colorBandValues.map(colorBand => {
                                        return (
                                            <option key={colorBand.value} className={colorBand.color} value={colorBand.color}>{colorBand.color} ({colorBand.value})</option>
                                        )
                                    })
                                }
                            </Form.Control>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Multiplier</Form.Label>
                            <Form.Control
                                as="select"
                                name="multiplier"
                                defaultValue="EMPTY"
                                onChange={this.handleChange.bind(this)}
                            >
                                <option value="EMPTY" selected disabled hidden>Select a Color</option>
                                {
                                    mulitiplierValue.map(mulitiplier => {
                                        return (
                                            <option key={mulitiplier.value} className={mulitiplier.color} value={mulitiplier.color}>{mulitiplier.color} ({mulitiplier.value} &#8486;)</option>
                                        )
                                    })
                                }
                            </Form.Control>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Tolerance</Form.Label>
                            <Form.Control
                                as="select"
                                name="tolerance"
                                defaultValue="EMPTY"
                                onChange={this.handleChange.bind(this)}
                            >
                                <option value="EMPTY" selected disabled hidden>Select a Color</option>
                                {
                                    toleranceValue.map(tolerance => {
                                        return (
                                            <option key={tolerance.value} className={tolerance.color} value={tolerance.color}>{tolerance.color} (&plusmn; {tolerance.value} %)</option>
                                        )
                                    })
                                }
                            </Form.Control>
                        </Form.Group>
                    </Col>
                    <Col>
                        <Card style={{ width: '18rem' }}>
                            <Card.Body>
                                <Card.Title>Resistor value:</Card.Title>
                                <Card.Text>
                                    <h4>{this.conditionalResultRender(resultValue)}</h4>
                                </Card.Text>
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
            </Container>
        );
    }
}

export default FiveBandComponent;