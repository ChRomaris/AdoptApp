import React, { Component } from "react";
import { getShelterAnimals } from '../actions';
import List from '../../mainList/components/List';
import UpdateAnimalForm from "../../animal/components/UpdateAnimalForm";
import { Button } from 'reactstrap';
import {deleteShelterAnimal} from '../actions';
import Filter from '../../common/Filter';
import { isThisSecond } from "date-fns";



function RenderEditingForm(props) {
    return <UpdateAnimalForm animalId = {props.animalId} showEditingForm={props.showEditingForm} showList={props.showList}></UpdateAnimalForm>;
  }


  function RenderList(props) {
    console.log(props)
    return <List animales={props.animals} deleteAnimal = {props.deleteAnimal}  showEditingForm={props.showEditingForm} showButtons={true}></List>;
  }

  function RenderListForm(props) {  
    console.log("Props del renderList")
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
            editingAnimalId : '',
            page : 0,
            totalPages : 0,
            actualPage : 0,
            filter:{
                breed:null,
                genre:null,
                color:null,
                size:null
            }
 

        }
        this.ShowEditingForm = this.ShowEditingForm.bind(this);
        this.ShowList = this.ShowList.bind(this);
        this.DeleteAnimal = this.DeleteAnimal.bind(this);
        this.previousPage = this.previousPage.bind(this);
        this.nextPage = this.nextPage.bind(this);
        this.handleFilter = this.handleFilter.bind(this);
        this.handleFilter = this.handleFilter.bind(this);
        this.showInfo = this.showInfo.bind(this);
        
        

    }

    showInfo(animalId){
        this.props.history.replace("/adoption/"+animalId);
    }

    previousPage(actual){
        console.log("previous")
        console.log(actual)
        this.setState({
            actualPage : actual - 1
        },()=>this.getAnimalList()
            
        )
        
    }

    nextPage(actual){
        console.log("next")
        console.log(actual)
        this.setState({
        
            actualPage : actual + 1
        },()=>this.getAnimalList()
            
        )
        
    }


    renderButtons(){
        if(!this.state.isEditing){

        
        if(this.state.actualPage > 0 && this.state.actualPage < this.state.totalPages)
        {
            return(
                [<div className ="previousButton">
                 <Button onClick={()=>this.previousPage(this.state.actualPage)} >
                    Anterior
                </Button>
                </div>,
                <div className ="nextButton">
                    <Button onClick={()=>this.nextPage(this.state.actualPage)} >
                            Siguiente
                    </Button>
                </div>]
            )
        }else if(this.state.actualPage > 0){
            return(
                <div className ="previousButton">
                 <Button onClick={()=>this.previousPage(this.state.actualPage)} >
                    Anterior
                </Button>
                </div>
            )}else if (this.state.actualPage< this.state.totalPages){
                return(
                    <div className ="nextButton">
                    <Button onClick={()=>this.nextPage(this.state.actualPage)} >
                            Siguiente
                    </Button>
                </div>
                )
            }
        }
        }

    getAnimalList() {

        const searchShelterAnimalsDTO = {
            token: sessionStorage.getItem('serviceToken'),
            page: this.state.actualPage,
            filter : this.state.filter
        }
            getShelterAnimals(searchShelterAnimalsDTO).then(response => {
                if (response.adoptionAnimals != null) {
                    this.setState({
                        animals: response.adoptionAnimals,
                        totalPages : response.totalPages
                    })
                }
                console.log(this.state);
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

    handleFilter(filter){
        this.setState({
            filter: filter
        },()=>this.getAnimalList())

        


    }

    


    render() {
      return   (
        <div>
        <Filter handleFilter = {this.handleFilter}></Filter>
        <RenderListForm isEdition={this.state.isEditing} animals={this.state.animals} showEditingForm={this.ShowEditingForm} animalId={this.state.editingAnimalId} deleteAnimal = {this.DeleteAnimal} showList={this.ShowList} showInfo = {this.showInfo}/>
        {this.renderButtons()}
      </div>
      )
    }  
}

export default ShelterAnimalList;   