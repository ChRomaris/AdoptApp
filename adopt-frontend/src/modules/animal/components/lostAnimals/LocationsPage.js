import React,{ Component } from "react";
import { TopMenu } from '../../../app';
import { connect } from 'react-redux';
import LocationsMap from './LocationsMap';
import LostAnimalInfoModal from './LostAnimalInfoModal';

class LocationsPage extends Component{

    constructor(){
        super();

       this.contact = this.contact.bind(this)
    }
    contact(username){
        this.props.history.replace("/chat/"+username)
    }



    render(){

        console.log("locations")
        console.log(this.props.locations)
        return(
            <div>
                <TopMenu></TopMenu>
                <LostAnimalInfoModal show = {this.props.showModal} contact = {this.contact}></LostAnimalInfoModal>
                <LocationsMap contact = {this.contact}></LocationsMap>
            </div>
        )
    }
}

const mapStateToProps = state =>({
    locations : state.lostAnimals.locations,
    animal : state.lostAnimals.selectedAnimal,
    showModal : state.lostAnimals.showLocationModal,
    locationsLoaded : state.lostAnimals.locationsLoaded
})

export default connect(mapStateToProps,{})(LocationsPage)