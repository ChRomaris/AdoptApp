import React,{ Component } from "react";
import MarkerMapMain from "../../common/MarkerMapMain";
import {getSheltersInArea} from "../actions";
import { TopMenu } from '../../app';
import Modal from '../../common/Modal';


import '../../common/styles/common.css'


class AdoptionMapPage extends Component{
    constructor(props){
        super(props);
        this.state={
            markers:[],
            modalIsShowing:false,
            shelter : {}
        }

        this.toggleModal = this.toggleModal.bind(this)
        this.closeModal = this.closeModal.bind(this)
        this.showAnimals = this.showAnimals.bind(this)
        

    }

    showAnimals(shelterId){
        console.log("Lanza función de showAnimals")
        this.props.history.replace("/list/"+ shelterId)
    }

    toggleModal (shelter){
            
        console.log("ToggleModal")
        console.log(shelter)
            this.setState({
                modalIsShowing: true,
                shelter : shelter
                
            });
    }

    
    closeModal (){
        
        this.setState({
            modalIsShowing: false
        });
}


    componentDidMount(){
        this.getShelters();
       
    }

    getShelters(){
        getSheltersInArea(sessionStorage.getItem('serviceToken')).then(response =>{
            this.setState({
                markers : response.shelters
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
             shelter = {this.state.shelter}
             showAnimals = {this.showAnimals}>
        </Modal>
            </div>
        <div className="Overlay">
        <div className="shelterMapContainer">
        <MarkerMapMain toggleModal = {this.toggleModal} markers={this.state.markers}></MarkerMapMain>
        </div>
        </div>
        </div>
        ) 
    }
}

export default AdoptionMapPage;