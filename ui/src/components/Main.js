import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'

import FooterComponent from './FooterComponent';
import HeaderComponent from './HeaderComponent';
import ResistorComponent from './ResistorComponent';

class Main extends Component {
  render() {
    return (
      <div>
        <Router>
          <HeaderComponent />
          <div className="container">
            <Switch>
              <Route path="/" component={ResistorComponent}></Route>
              <ResistorComponent />
            </Switch>
          </div>
          <FooterComponent />
        </Router>
      </div>
    );
  }
}

export default Main;