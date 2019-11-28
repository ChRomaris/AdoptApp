import React,{ Component } from "react";
import TopMenu from '../../app/components/TopMenu';
import AdoptionAnimalDetail from './AdoptionAnimalDetail';
import {getAnimalInfo} from '../actions';
import ImagesCarousel from '../../common/ImagesCarousel';
import SingleMarkerMap from '../../common/SingleMarkerMap';
import {Button} from 'reactstrap'
class AdoptionAnimalInfoPage extends Component{
    constructor(){
        super()
        this.state = {
            animal:{
                images:[]
            }
        }
        
         this.contactOnClick = this.contactOnClick.bind(this);
         this.renderContact = this.renderContact.bind(this);
    }

    componentDidMount (){
        const params = {
            id : this.props.match.params.animalId
        }

        getAnimalInfo(params).then(response => {

            this.setState({
                animal : response
            },()=>console.log(response))
        })
    }

    contactOnClick(){
        console.log(this.state.animal)
        console.log(this.state.animal)
        this.props.history.replace("/chat/"+this.state.animal.shelterName)
    }
    renderContact(){
        if (sessionStorage.getItem('serviceToken') !== null){
            return <Button onClick={()=>this.contactOnClick()}>Contactar</Button>
        }
    }
    render(){
        return(
        <div>
            <TopMenu></TopMenu>
            <ImagesCarousel images = {this.state.animal.images}></ImagesCarousel>
            
            <SingleMarkerMap latitude = {this.state.animal.latitude} longitude = {this.state.animal.longitude}></SingleMarkerMap>
            
            <div className = "button">
            {this.renderContact()}
                </div>
            <AdoptionAnimalDetail animal = {this.state.animal}></AdoptionAnimalDetail>

        </div>
        )
    }
}

export default AdoptionAnimalInfoPage;