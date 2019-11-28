import React,{ Component } from "react";
import LostAnimalsList from './LostAnimalsList';
import {TopMenu} from '../../../app';
import {connect} from 'react-redux';
import {getUserAnimals} from './actions/actions'
import LostAnimalUpdateForm from "./LostAnimalCreationForm";

class MyLostAnimalsPage extends Component{
    constructor(){
        super()

        this.state = {
            isFormShowing : false,
            selectedAnimalId: ''
        }
        this.hideForm = this.hideForm.bind(this)
        this.renderListForm = this.renderListForm.bind(this)
        this.locationsClick = this.locationsClick.bind(this)
        this.renderListForm = this.renderListForm.bind(this)
        this.getAnimals = this.getAnimals.bind(this)
        this.editAnimal = this.editAnimal.bind(this)
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

    editAnimal(animalId){
        this.props.history.replace("/user/animals/"+animalId)
    }

    hideForm(){
        
        this.setState({
            selectedAnimalId : ''
        },this.getAnimals())
    }

    locationsClick(){
        this.props.history.replace("/animal/locations")
    }

    renderListForm(){
        if(this.state.selectedAnimalId !== ''){
            return <LostAnimalUpdateForm></LostAnimalUpdateForm>
        }
        else{
            return <LostAnimalsList redirectLocations={this.locationsClick} editAnimal = {this.editAnimal} myAnimal={true} ></LostAnimalsList>
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

const mapStateToProps = state => ({
    lostAnimals : state.lostAnimals.animals,
    selectedAnimal : state.lostAnimals.selectedAnimal

})

export default connect (mapStateToProps, {getUserAnimals}) (MyLostAnimalsPage)