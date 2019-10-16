import React,{ Component } from "react";
import MarkerMapMain from "../../common/MarkerMapMain";
import {getSheltersInArea} from "../actions";
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
            shelter : {}
        }

        this.toggleModal = this.toggleModal.bind(this)
        this.closeModal = this.closeModal.bind(this)
        

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
             shelter = {this.state.shelter}>
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