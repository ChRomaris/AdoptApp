import React, {Component} from 'react';
import {Button} from 'reactstrap';
import {deleteShelterAnimal} from '../../shelter/actions'
import '../../../styles/shelter.css'
class Buttons extends Component{
    constructor(props){
        super(props)

    this.showEditingForm = this.showEditingForm.bind(this)
    }
    

    deleteAnimal(){
        const deleteAnimalDTO ={
            userToken : sessionStorage.getItem('serviceToken'),
            animalId: this.props.animalId
        }
    
        
        deleteShelterAnimal(deleteAnimalDTO);
        console.log("Se borra el animal");
        this.props.reloadList();

    
    }

    showEditingForm (){
        this.props.showEditingForm()
    }


    render(){
        return(
            <div  className= "buttons">
        <Button onClick={this.showEditingForm}>Editar</Button>
        <br></br>
        <Button className = "botonesEditarBorrar" onClick={()=>this.deleteAnimal()}>Borrar</Button>
        </div>
            )
    }
}

export default Buttons;