import React, {Component} from 'react';
import {Button} from 'reactstrap';

import '../../../styles/shelter.css'
class Buttons extends Component{
    constructor(props){
        super(props)

    this.showEditingForm = this.showEditingForm.bind(this)
    this.removeAnimal = this.removeAnimal.bind(this)
   
    }
    

    removeAnimal(props){
        
        const deleteAnimalDTO ={
            userToken : sessionStorage.getItem('serviceToken'),
            animalId: props.animalId
        }
    
        
        this.props.deleteAnimal(this.props.animalId)
        console.log("Se borra el animal");

    
    }

    showEditingForm (props){
        this.props.showEditingForm()
    }
    
  


    render(){
        console.log(this.props)
        return(
            <div  className= "buttons">
        <Button onClick={this.showEditingForm}>Editar</Button>
        <br></br>
        <Button className = "botonesEditarBorrar" onClick={this.removeAnimal}>Borrar</Button>
        </div>
            )
    }
}

export default Buttons;