import React,{ Component } from "react";
import TopMenu from '../../app/components/TopMenu';
import AdoptionAnimalDetail from './AdoptionAnimalDetail';
import {getAnimalInfo} from '../actions';
import ImagesCarousel from '../../common/ImagesCarousel';
import SingleMarkerMap from '../../common/SingleMarkerMap';

class AdoptionAnimalInfoPage extends Component{
    constructor(){
        super()
        this.state = {
            animal:{
                images:[]
            }
        }
    }

    componentDidMount (){
        const params = {
            id : this.props.match.params.animalId
        }

        getAnimalInfo(params).then(response => {
            this.setState({
                animal : response
            },()=>console.log(this.state))
        })
    }

    render(){
        return(
        <div>
            <TopMenu></TopMenu>
            <ImagesCarousel images = {this.state.animal.images}></ImagesCarousel>
            <SingleMarkerMap latitude = {this.state.animal.latitude} longitude = {this.state.animal.longitude}></SingleMarkerMap>
            <AdoptionAnimalDetail animal = {this.state.animal}></AdoptionAnimalDetail>
        </div>
        )
    }
}

export default AdoptionAnimalInfoPage;