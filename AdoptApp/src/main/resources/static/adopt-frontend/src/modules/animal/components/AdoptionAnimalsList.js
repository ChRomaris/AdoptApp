import React, { Component } from "react";
import {getAllAdoptionAnimals} from '../actions';
import List from '../../mainList/components/List';

class AdoptionAnimalList extends Component{

    constructor(props){
        super()
        this.state = {
            animales : []
        }
    }
    
    componentDidMount(){
        getAllAdoptionAnimals().then(response => {
            this.setState( {
                animales : response.animales
                
            })
            
        }).catch(error => {
            console.log("Error al recuperar el listado completo de animales")
        })
    }


    
    render(){
        return(
      <List animales={this.state.animales} edit = {this.editAnimal}></List>
           
        )
    }
}

export default AdoptionAnimalList