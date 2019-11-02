import React,{ Component } from "react";
import { TopMenu } from '../../../app';
import { connect } from 'react-redux';
import LocationsMap from './LocationsMap';
import LostAnimalInfoModal from './LostAnimalInfoModal';

class LocationsPage extends Component{

    render(){

        console.log("locations")
        console.log(this.props.locations)
        return(
            <div>
                <TopMenu></TopMenu>
                <LostAnimalInfoModal show = {this.props.showModal}></LostAnimalInfoModal>
                <LocationsMap></LocationsMap>
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