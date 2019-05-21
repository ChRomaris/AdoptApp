import React from 'react';
import { HashRouter as Router, Route, Switch } from 'react-router-dom';
import SignUpForm from '../../../pages/SignUpForm';
import SignInForm from '../../../pages/SignInForm';
import AnimalCreationForm from '../../animal/components/AnimalCreationForm'
import Welcome from '../../../pages/Welcome';
import shelterMain from '../../shelter';
import Header from './Header';



import '../../../App.css';


class App extends React.Component {

  render() {
    return (
      <Router>     
              <Switch>
              <Route exact path="/signUp" component={SignUpForm}></Route>
              <Route exact path="/welcome" component={Welcome}></Route>
              <Route exact path="/shelter/add" component={shelterMain}></Route>
              <Route exact path="/animal/add" component={AnimalCreationForm}></Route>
              <Route exact path="/header" component={Header}></Route>
              <Route exact path="/"  component={SignInForm}></Route>
              <Route exact path="/welcome" component={Welcome}></Route>
              </Switch>
      </Router>
    );
  }
}

export default App;