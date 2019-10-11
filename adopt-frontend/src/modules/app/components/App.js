import React from 'react';
import { HashRouter as Router, Route, Switch } from 'react-router-dom';
import {Provider} from 'react-redux';
import store from '../../../store/store';
import SignInForm from '../../user/components/SignInForm';
import SignUpForm from '../../user/components/SignUpForm';
import Welcome from './Welcome';
import AnimalCreationForm from '../../animal/components/AnimalCreationForm';
import UpdateAnimalForm from '../../animal/components/UpdateAnimalForm';
import main from '../../mainList';
import AdoptionAnimalList from '../../animal/components/AdoptionAnimalsList';
import UpdateUser from '../../user/components/UpdateUser';
import UpdateShelter from '../../shelter/components/UpdateShelter';
import ShelterAnimalList from '../../shelter/components/ShelterAnimalList';
import AddLocationMap from '../../user/components/AddLocationMap';
import AddLocation from '../../user/components/AddLocation';
import AdoptionMapPage from '../../animal/components/AdoptionMapPage';
import LostAnimalCreationForm from '../../animal/components/lostAnimals/LostAnimalCreationForm';
import LostAnimalsPage from '../../animal/components/lostAnimals/LostAnimalsPage';
import MyLostAnimalsPage from '../../animal/components/lostAnimals/MyLostAnimalsPage';
import LocationsPage from '../../animal/components/lostAnimals/LocationsPage';
import LostMapPage from '../../animal/components/lostAnimals/LostMapPage';

import '../App.css';


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
      <Provider store = {store}>
      <Router>     
              <Switch>
                <Route exact path="/signUp" component={SignUpForm}></Route>
                <Route exact path="/shelter/update" component={UpdateShelter}></Route>
                <Route exact path="/shelter" component = {ShelterAnimalList}></Route>
                <Route exact path="/animal/add" component={AnimalCreationForm}></Route>
                <Route exact path="/animal/edit" component={UpdateAnimalForm}></Route>
                <Route exact path="/"  component={SignInForm}></Route>
                <Route exact path="/List" component = {AdoptionAnimalList}></Route>
                <Route exact path="/user/update" component = {UpdateUser}></Route>
                <Route exact path="/addLostAnimal" component = {LostAnimalCreationForm}></Route>
                <Route exact path="/map" component = {AddLocationMap}></Route>
                <Route exact path="/addLocation" component = {AddLocation}></Route>
                <Route exact path="/adoptionMap" component = {AdoptionMapPage}></Route>
                <Route exact path = "/lostList" component = {LostAnimalsPage}></Route>
                <Route exact path = "/user/animals" component = {MyLostAnimalsPage}></Route>
                <Route exact path = "/animal/locations" component = {LocationsPage}></Route>
                <Route exact path = "/lostMap" component ={LostMapPage}></Route>


              </Switch>
      </Router>
      </Provider>

    );
  }
}

export default App;