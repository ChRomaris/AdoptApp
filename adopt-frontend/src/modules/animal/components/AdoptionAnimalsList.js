import React, { Component } from "react";
import {getAllAdoptionAnimals} from '../actions';
import List from '../../mainList/components/List';

class AdoptionAnimalList extends Component{

    constructor(props){
        super()
        this.state = {
            animales : []
        }

        this.showInfo = this.showInfo.bind(this);
    }
    
    componentDidMount(){
        getAllAdoptionAnimals().then(response => {
            this.setState( {
                animales : response.animales
                
            },()=>console.log(this.state.animales))
            
        }).catch(error => {
            console.log("Error al recuperar el listado completo de animales")
        })
    }

    showInfo(animalId){
        this.props.history.replace("/adoption/"+animalId);
    }
    


    
    render(){
        return(
      <List animales={this.state.animales} edit = {this.editAnimal} showButtons = {false} showInfo = {this.showInfo}></List>
           
        )
    }
}

export default AdoptionAnimalList