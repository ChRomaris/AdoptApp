import React, { Component } from "react";
import { getShelterAnimals } from '../actions';
import List from '../../mainList/components/List';
import UpdateAnimalForm from "../../animal/components/UpdateAnimalForm";

import {deleteShelterAnimal} from '../actions'


function RenderEditingForm(props) {
    return <UpdateAnimalForm animalId = {props.animalId} showEditingForm={props.showEditingForm} showList={props.showList}></UpdateAnimalForm>;
  }


  function RenderList(props) {
    console.log(props)
    return <List animales={props.animals} deleteAnimal = {props.deleteAnimal}  showEditingForm={props.showEditingForm}></List>;
  }

  function RenderListForm(props) {
    console.log( props);
    const isEdition = props.isEdition;
    if (isEdition) {
        return <RenderEditingForm animalId = {props.animalId} showEditingForm={props.showEditingForm} showList = {props.showList}/>;
      
    }else{
        return <RenderList animals = {props.animals} deleteAnimal = {props.deleteAnimal} showEditingForm={props.showEditingForm} />;
    }
    
  }
  
class ShelterAnimalList extends Component {
    constructor(props) {
        
        super(props);
        this.state = {
            animals: [],
            shelterName: '',
            isEditing:false,
            editingAnimalId : ''

        }
        this.ShowEditingForm = this.ShowEditingForm.bind(this);
        this.ShowList = this.ShowList.bind(this);
        this.DeleteAnimal = this.DeleteAnimal.bind(this);
       
        
        

    }

    getAnimalList() {

        const searchShelterAnimalsDTO = {
            token: sessionStorage.getItem('serviceToken')
        }
            getShelterAnimals(searchShelterAnimalsDTO).then(response => {
                if (response.animals != null) {
                    this.setState({
                        animals: response.animals
                    })
                }

                console.log("bien")

            }).catch(error => {
                console.log("error")
            })

    }

    componentDidMount() {

        this.getAnimalList();


    }

    DeleteAnimal(animalId){
      console.log("user:" + sessionStorage.getItem('serviceToken'))
      const deleteAnimalDTO = {
          userToken : sessionStorage.getItem('serviceToken'),
          animalId : animalId
      }
      deleteShelterAnimal (deleteAnimalDTO).then(response=>{
          this.getAnimalList();
      }).catch(error=>{
          console.log("Algo ha fallado")
      })
    }

   ShowEditingForm(id){
       console.log("id principal:"+id)
        console.log("Formulario de edicion")
        this.setState({
            editingAnimalId : id,
            isEditing :true
        })
    }

    ShowList(){
        this.setState({
            isEditing :false
        })

        this.getAnimalList();
    }


    render() {
      return   <RenderListForm isEdition={this.state.isEditing} animals={this.state.animals} showEditingForm={this.ShowEditingForm} animalId={this.state.editingAnimalId} deleteAnimal = {this.DeleteAnimal} showList={this.ShowList}  />
    }  
}

export default ShelterAnimalList;   