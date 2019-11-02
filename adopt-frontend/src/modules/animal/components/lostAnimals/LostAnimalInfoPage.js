import React,{ Component } from "react";
import TopMenu from '../../../app/components/TopMenu';
import LostAnimalDetail from './LostAnimalDetail';
import ImagesCarousel from '../../../common/ImagesCarousel';
import SingleMarkerMap from '../../../common/SingleMarkerMap';
import {getLostAnimalInfo} from '../../actions';
import {Button} from 'reactstrap'
import Chat from '../../../Chat/chat';
import './styles/styles.css'

class LostAnimalInfoPage extends Component{
    constructor(){
        super();
        this.state = {
            animal : {
                name: 'Perdido 1',
                breed:'Mastín',
                genre:'Macho',
                color:'Marrón',
                size:'Pequeño',
                description:'Es majo',
                date:'10/07/2019',
                comment:'Se encontró al lado del colegio',
                images: [],
                latitude :'',
                longitude: '',
                ownerUsername: ''
            }
        }
        this.contactOnClick = this.contactOnClick.bind(this);
    }
    componentDidMount(){
        getLostAnimalInfo(this.props.match.params.animalId).then(response =>{
            console.log(response)
            this.setState({
                animal : {
                    name : response.name,
                    breed : response.lostAnimalInfoDTO.breed,
                    genre: response.genre,
                    color: response.color,
                    size: response.size,
                    description: response.description,
                    date: response.lostAnimalInfoDTO.dateTime,
                    comment: response.lostAnimalInfoDTO.comment,
                    images : response.images,
                    latitude: response.lostAnimalInfoDTO.latitude,
                    longitude: response.lostAnimalInfoDTO.longitude,
                    ownerUsername : response.lostAnimalInfoDTO.userName
                }
            },()=>console.log(this.state))
        })
        
    }

    contactOnClick(){
        console.log("Valores en onClick")
        console.log()
        this.props.history.replace("/chat/"+this.state.animal.ownerUsername)
    }

    render(){
        return(
            <div>
                {console.log("renderMain")}
                {console.log(this.state)}
                <TopMenu></TopMenu>
                <ImagesCarousel images={this.state.animal.images}></ImagesCarousel>
                <SingleMarkerMap latitude ={this.state.animal.latitude} longitude={this.state.animal.longitude}></SingleMarkerMap>
                <div className = "button">
                    <Button onClick={()=>this.contactOnClick()}>Contactar</Button>
                </div>
                <LostAnimalDetail animal = {this.state.animal} ></LostAnimalDetail>

            </div>
        )
    }
}

export default LostAnimalInfoPage;