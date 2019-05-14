import React from 'react';
import { HashRouter as Router, Route, Switch } from 'react-router-dom';
import SignUpForm from '../../../pages/SignUpForm';
import SignInForm from '../../../pages/SignInForm';
import Welcome from '../../../pages/Welcome';



import '../../../App.css';


class App extends React.Component {

  render() {
    return (
      <Router >     
              <Switch>
              <Route exact path="/signUp" component={SignUpForm}></Route>
              <Route exact path="/"  component={SignInForm}></Route>
              <Route exact path="/welcome" component={Welcome}></Route>
              </Switch>
      </Router>
    );
  }
}

export default App;