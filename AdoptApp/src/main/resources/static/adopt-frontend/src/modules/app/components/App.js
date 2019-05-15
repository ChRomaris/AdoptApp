import React from 'react';
import { HashRouter as Router, Route, Switch } from 'react-router-dom';
import SignUpForm from '../../../pages/SignUpForm';
import SignInForm from '../../../pages/SignInForm';
import Welcome from '../../../pages/Welcome';
import shelterCreationForm from '../../shelter';
import Header from './Header';



import '../../../App.css';



class App extends React.Component {

constructor(props){
  super(props);
  this.state = {
    currentUser: null,
    isAuthenticated: false,
    isLoading: false
  }

 
}
  render() {
    return (
      <Router>     
              <Switch>
              <Route exact path="/signUp" component={SignUpForm}></Route>
              <Route exact path="/welcome" component={Welcome}></Route>
              <Route exact path="/shelter/add" component={shelterCreationForm}></Route>
              <Route exact path="/header" component={Header}></Route>
              <Route exact path="/"  component={SignInForm}></Route>
              </Switch>
      </Router>
    );
  }
}

export default App;