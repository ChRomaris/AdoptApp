import React from 'react';
import { HashRouter as Router, Route, Switch } from 'react-router-dom';
import SignInForm from '../../user/components/SignInForm';
import SignUpForm from '../../user/components/SignUpForm';
import Welcome from './Welcome';
import AnimalCreationForm from '../../animal/components/AnimalCreationForm';
import UpdateAnimalForm from '../../animal/components/UpdateAnimalForm';
import main from '../../mainList';
import AdoptionAnimalList from '../../animal/components/AdoptionAnimalsList'
import shelterMain from '../../shelter/components/shelterMain';
import UpdateUser from '../../user/components/UpdateUser';
import ShelterAnimalList from '../../shelter/components/ShelterAnimalList'
import Buttons from '../../mainList/components/Buttons'
import '../App.css';
import Header from './Header';
import SideMenu from './SideMenu';


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
                <Route exact path="/shelter/add" component={shelterMain}></Route>
                <Route exact path="/animal/add" component={AnimalCreationForm}></Route>
                <Route exact path="/animal/edit" component={UpdateAnimalForm}></Route>
                <Route exact path="/header" component={Header}></Route>
                <Route exact path="/"  component={SignInForm}></Route>
                <Route exact path="/mainPage" component={main}></Route>
                <Route exact path="/List" component = {AdoptionAnimalList}></Route>
                <Route exact path="/user/update" component = {UpdateUser}></Route>
                <Route exact path="/SideMenu" component = {SideMenu}></Route>
                <Route exact path="/shelter" component = {ShelterAnimalList}></Route>
                <Route exact path="/botones" component = {Buttons}></Route>

              </Switch>
      </Router>
    );
  }
}

export default App;