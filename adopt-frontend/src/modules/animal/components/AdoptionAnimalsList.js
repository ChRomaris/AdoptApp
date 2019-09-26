import React, { Component } from "react";
import {getAllAdoptionAnimals} from '../actions';
import {getFilteredAnimals} from '../actions';
import List from '../../mainList/components/List';


class AdoptionAnimalList extends Component{

    constructor(props){
        super()
        this.state = {
            animales : []
        }

        this.FilterAnimals = this.FilterAnimals.bind(this);
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

    FilterAnimals(filters){
        const filterDTO = {
            breed : filters.breed,
            color : filters.color,
            genre : filters.genre,
            size  : filters.size
        }

        getFilteredAnimals(filterDTO).then(response=>{
            console.log("Filtros:")
            console.log(filterDTO);
            this.setState({
                animales : response
            })
        })
    }
    


    
    render(){
        return(
      <div>
      
      <List animales={this.state.animales} edit = {this.editAnimal} showButtons = {false} filter = {this.FilterAnimals}></List>
      </div>     
        )
    }
}

export default AdoptionAnimalList