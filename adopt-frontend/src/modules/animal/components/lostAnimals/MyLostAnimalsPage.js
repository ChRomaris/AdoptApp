import React,{ Component } from "react";
import LostAnimalsList from './LostAnimalsList';
import {TopMenu} from '../../../app';
import {connect} from 'react-redux';
import {getUserAnimals} from './actions/actions'
import AnimalCreationForm from "../AnimalCreationForm";
import LostAnimalCreationForm from "./LostAnimalCreationForm";

class MyLostAnimalsPage extends Component{
    constructor(){
        super()

        this.state = {
            isFormShowing : false
        }
        this.showForm = this.showForm.bind(this)
        this.hideForm = this.hideForm.bind(this)
        this.renderListForm = this.renderListForm.bind(this)
        this.locationsClick = this.locationsClick.bind(this)
        this.renderListForm = this.renderListForm.bind(this)
        this.getAnimals = this.getAnimals.bind(this)
    }

    componentDidMount(){ 
        this.getAnimals()
    }

    getAnimals (){
        console.log("montado")
        const params = {
            token: sessionStorage.getItem('serviceToken')
        }

        this.props.getUserAnimals(params)
    }

    showForm () {
        this.setState({
            isFormShowing : true
        })
    }

    hideForm(){
        
        this.setState({
            isFormShowing : false
        },this.getAnimals())
    }

    locationsClick(){
        this.props.history.replace("/animal/locations")
    }

    renderListForm(){
        if(this.state.isFormShowing){
            console.log(this.props.selectedAnimal)
            return <LostAnimalCreationForm hideForm = {this.hideForm} ></LostAnimalCreationForm>
        }
        else{
            return <LostAnimalsList redirectLocations={this.locationsClick} showForm = {this.showForm}></LostAnimalsList>
        }
    }

    render(){
        return(
        <div>
        <TopMenu></TopMenu>
        {this.renderListForm()}
    </div>)
    }

    
}

const mapStateToProps = state => (console.log(state),{
    lostAnimals : state.lostAnimals.animals,
    selectedAnimal : state.lostAnimals.selectedAnimal

})

export default connect (mapStateToProps, {getUserAnimals}) (MyLostAnimalsPage)