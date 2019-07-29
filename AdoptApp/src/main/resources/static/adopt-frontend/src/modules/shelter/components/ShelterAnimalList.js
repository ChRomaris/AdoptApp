import React, { Component } from "react";
import { getShelterAnimals } from '../actions';
import List from '../../mainList/components/List';
import UpdateAnimalForm from "../../animal/components/UpdateAnimalForm";


function RenderEditingForm(props) {
    return <UpdateAnimalForm animalId = {props.animalId} showList={props.showList}></UpdateAnimalForm>;
  }



  function RenderList(props) {
    
    return <List animales={props.animals} ShowEditingForm={props.ShowEditingForm}></List>;
  }

  function RenderListForm(props) {
    const isEdition = props.isEdition;
    if (isEdition) {
        return <RenderEditingForm animalId = {props.animalId} showList={props.showList}/>;
      
    }else{
        return <RenderList animals = {props.animals} ShowEditingForm={props.ShowEditingForm} />;
    }
    
  }
  
class ShelterAnimalList extends Component {
    constructor(props) {
        super(props)
        this.state = {
            animals: [],
            shelterName: '',
            isEditing:false,
            editingAnimalId : ''

        }
        this.ShowEditingForm = this.ShowEditingForm.bind(this);
        this.ShowList = this.ShowList.bind(this);
        
        

    }

    getAnimalList() {

        const searchShelterAnimalsDTO = {
            userToken: sessionStorage.getItem('serviceToken'),
            shelterName: sessionStorage.getItem('shelterName')
        }

        if (sessionStorage.getItem('isAdmin')) {
            console.log(searchShelterAnimalsDTO.userToken);
            console.log(searchShelterAnimalsDTO.shelterName);

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
        } else {
            console.log("no es admin")
        }

    }

    componentDidMount() {

        this.getAnimalList();


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
      return   <RenderListForm isEdition={this.state.isEditing} animals={this.state.animals} ShowEditingForm={this.ShowEditingForm} animalId={this.state.editingAnimalId} showList={this.ShowList}  />

      
    }  
}

export default ShelterAnimalList;   