import React,{ Component } from "react";
import MarkerMapMain from "../../common/MarkerMapMain";
import {getNearbyAdoptionAnimals} from "../actions";
import { TopMenu } from '../../app';
import Modal from '../../common/Modal';
import Moment from 'moment';


import '../../common/styles/common.css'


class AdoptionMapPage extends Component{
    constructor(props){
        super(props);
        this.state={
            markers:[],
            modalIsShowing:false,
            animalInfo : {
                name:"",
                breed:"",
                distance:"",
                image:"",
                birthDate:""
            }
        }

        this.toggleModal = this.toggleModal.bind(this)
        this.closeModal = this.closeModal.bind(this)
        

    }

    toggleModal (id,name,birthdate,distance,image,breed){
            
        
            this.setState({
                modalIsShowing: true,
                animalInfo : {
                    name:name,
                    breed:breed,
                    birthDate:Moment(birthdate).fromNow(true),
                    distance: distance,
                    image: image
                }
                
            });
    }

    
    closeModal (){
        
        this.setState({
            modalIsShowing: false
        });
}


    componentDidMount(){
        this.getAnimals();
       
    }

    getAnimals(){
        const params = {
            token : sessionStorage.getItem('serviceToken')
        }
        getNearbyAdoptionAnimals(params).then(response=>{
            this.setState({
                markers: response
            })
        })

    }

    render(){
        return(
        <div>
        <TopMenu/>
        <div>
        <Modal
            className="modal"
            show={this.state.modalIsShowing}
             close={this.closeModal}
             name={this.state.animalInfo.name}
             age={this.state.animalInfo.birthDate}
             distance={this.state.animalInfo.distance}
             image = {this.state.animalInfo.image}
             breed = {this.state.animalInfo.breed}>
        </Modal>
            </div>
        <div className="Overlay">
        <MarkerMapMain toggleModal = {this.toggleModal} markers={this.state.markers}></MarkerMapMain>
        </div>
        </div>
        ) 
    }
}

export default AdoptionMapPage;