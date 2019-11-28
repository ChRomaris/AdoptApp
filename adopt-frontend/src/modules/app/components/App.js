import React from 'react';
import { HashRouter as Router, Route, Switch } from 'react-router-dom';
import {Provider, connect} from 'react-redux';
import store from '../../../store/store';
import SignInForm from '../../user/components/SignInForm';
import SignUpForm from '../../user/components/SignUpForm';
import AnimalCreationForm from '../../animal/components/AnimalCreationForm';
import UpdateAnimalForm from '../../animal/components/UpdateAnimalForm';
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
import UserPreferences from '../../user/components/UserPreferences';
import ShelterPreferences from '../../shelter/components/ShelterPreferences';
import LostAnimalInfoPage from '../../animal/components/lostAnimals/LostAnimalInfoPage';
import AdoptionAnimalInfoPage from '../../animal/components/AdoptionAnimalInfoPage';
import ChatPage from '../../Chat/ChatPage';
import ActiveChatsPage from '../../Chat/ActiveChatsPage';
import NotificationsPage from '../../common/NotificationsPage';
import ShelterListPage from '../../shelter/components/ShelterListPage';
import {PrivateRoute} from './PrivateRoute';


import '../App.css';
import LostAnimalUpdateForm from '../../animal/components/lostAnimals/LostAnimalUpdateForm';


class App extends React.Component {

constructor(props){
  super(props);
  this.state = {
    currentUser: null,
    isAuthenticated: false,
    isLoading: false
  }


  

 }
componentDidMount(){
  console.log("aplicacion montada")
  document.body.style = 'background: #D8F6F6;';

}



  render() {
    
    return (

      <Provider store = {store}>
      <Router>     
              <Switch>
                <Route exact path="/signUp" component={SignUpForm}></Route>
                <PrivateRoute exact path="/shelter/update" component={UpdateShelter}></PrivateRoute>
                <PrivateRoute exact path="/shelter/preferences" component={ShelterPreferences}></PrivateRoute>
                <Route exact path="/shelter" component = {ShelterAnimalList}></Route>
                <PrivateRoute exact path="/animal/add" component={AnimalCreationForm}></PrivateRoute>
                <PrivateRoute exact path="/animal/edit" component={UpdateAnimalForm}></PrivateRoute>
                <Route exact path="/"  component={SignInForm}></Route>
                <Route exact path="/List" component = {AdoptionAnimalList}></Route>
                <Route exact path="/List/:shelterId" component = {AdoptionAnimalList}></Route>
                <PrivateRoute exact path="/user/update" component = {UpdateUser}></PrivateRoute>
                <PrivateRoute preferences = {this.props.profilePreferences} exact path="/user/preferences" component = {UserPreferences}></PrivateRoute>
                <PrivateRoute exact path="/addLostAnimal" component = {LostAnimalCreationForm}></PrivateRoute>
                <PrivateRoute exact path="/map" component = {AddLocationMap}></PrivateRoute>
                <PrivateRoute exact path="/addLocation" component = {AddLocation}></PrivateRoute>
                <Route exact path="/adoptionMap" component = {AdoptionMapPage}></Route>
                <Route exact path = "/lostList" component = {LostAnimalsPage}></Route>
                <PrivateRoute exact path = "/user/animals" component = {MyLostAnimalsPage}></PrivateRoute>
                <Route exact path = "/user/animals/:animalId" component = {LostAnimalUpdateForm}></Route>
                <PrivateRoute exact path = "/animal/locations" component = {LocationsPage}></PrivateRoute>
                <Route exact path = "/lostMap" component ={LostMapPage}></Route>
                <Route exact path = "/lost/:animalId" component ={LostAnimalInfoPage}></Route>
                <Route exact path = "/adoption/:animalId" component = {AdoptionAnimalInfoPage}></Route>
                <PrivateRoute exact path = "/chat/:username" component = {ChatPage}></PrivateRoute>
                <PrivateRoute exact path = "/notifications" component = {NotificationsPage}></PrivateRoute>
                <PrivateRoute exact path = "/chat" component = {ActiveChatsPage}></PrivateRoute>
                <Route exact path = "/shelterList" component = {ShelterListPage}></Route>
              </Switch>
      </Router>
      </Provider>

    );
  }
}


export default App;