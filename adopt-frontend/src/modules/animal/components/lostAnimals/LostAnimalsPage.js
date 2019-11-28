import React,{ Component } from "react";
import LostAnimalsList from './LostAnimalsList';
import {TopMenu} from '../../../app';
import AddLocationModal from './AddLocationModal';
import {connect} from 'react-redux';
import {closeModal, saveLocation, setLocation, getAnimals} from './actions/actions'


class LostAnimalsPage extends Component{
    constructor(){
        super()
        this.state = {
            date:'',
            comment:''
        }
        super()
        this.saveLocation = this.saveLocation.bind(this)
        this.setLocation = this.setLocation.bind(this)
        this.renderModal = this.renderModal.bind(this)
        this.showInfo = this.showInfo.bind(this)
        this.commentChange = this.commentChange.bind(this);
        this.dateChange = this.dateChange.bind(this);
    }

    saveLocation (){
        const params = {
            animalId: this.props.selectedAnimal,
            token : sessionStorage.getItem('serviceToken'),
            latitude : this.props.selectedLatitude,
            longitude : this.props.selectedLongitude,
            comment :this.state.comment,
            dateTime : this.state.date,
            username : sessionStorage.getItem('name'),
        }

        this.props.saveLocation(params)
    }

    componentDidMount(){
        this.getAnimals()
        this.props.closeModal()
    }

    getAnimals(){
        const params = {
            userToken : sessionStorage.getItem('serviceToken'),
            page : this.props.actualPage
        }

        this.props.getAnimals(params);
    }


    setLocation (lat,lng){
        
        const params = {
            latitude : lat,
            longitude : lng
        }
        this.props.setLocation (params)
    }

    showInfo(animalId){
        this.props.history.replace("/lost/"+animalId)
    }

    dateChange(e){
        let target = e.target;
        console.log(target.value);
        this.setState({
            date:target.value
        })

    }

    commentChange(e){
        console.log("commentChange")
        let target = e.target;
        console.log(target.value)
        this.setState({
            comment:target.value
        })
    }

    //Método para renderizar el modal, de esta forma no se guarda el estado al cerrarlo
    renderModal (){
        if(this.props.showModal){

            return <AddLocationModal show={window.scrollTo(0,500),true} close={this.props.closeModal} save = {this.saveLocation} set = {this.setLocation} dateChange = {this.dateChange} commentChange = {this.commentChange} ></AddLocationModal>
        }
    }


    render(){
        return(
        <div>
            <TopMenu></TopMenu>
            {this.renderModal()}
            <div className={this.props.showModal ? 'overlayActive' : 'overlayInactive'}></div>
            <LostAnimalsList showInfo = {this.showInfo}></LostAnimalsList>
            
        </div>
        )
    }
}


const mapStateToProps = state =>({
    selectedAnimal : state.lostAnimals.selectedAnimal,
    showModal : state.lostAnimals.showModal,
    selectedLatitude : state.lostAnimals.selectedLatitude,
    selectedLongitude : state.lostAnimals.selectedLongitude
})



export default connect(mapStateToProps,{closeModal, saveLocation, setLocation, getAnimals}) (LostAnimalsPage)
