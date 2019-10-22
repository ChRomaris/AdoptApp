import React, { Component } from "react";
import {getAllAdoptionAnimals} from '../actions';
import List from '../../mainList/components/List';
import { Button } from 'reactstrap';

class AdoptionAnimalList extends Component{

    constructor(props){
        super()
        this.state = {
            animales : [],
            actualPage : 0,
            totalPages : 0,
        }

        this.showInfo = this.showInfo.bind(this);
        this.renderButtons = this.renderButtons.bind(this);
        this.nextPage = this.nextPage.bind(this);
        this.previousPage = this.previousPage.bind(this);
        this.getAnimals = this.getAnimals.bind(this);
    }
    
    componentDidMount(){
        this.getAnimals();

    }

    getAnimals (){

        const params = {
            userToken : sessionStorage.getItem("serviceToken"),
            page: this.state.actualPage
        }
        console.log("GetAnimals con parametros : " )
        console.log(params)
        getAllAdoptionAnimals(params).then(response => {
            this.setState( {
                animales : response.adoptionAnimals,
                totalPages : response.totalPages
                
            },()=>console.log(this.state))
            
        }).catch(error => {
            console.log(error)
        })
    }

    previousPage(actual){
        console.log("previous")
        console.log(actual)
        this.setState({
            actualPage : actual - 1
        },()=>this.getAnimals()
            
        )
        
    }

    nextPage(actual){
        console.log("next")
        console.log(actual)
        this.setState({
        
            actualPage : actual + 1
        },()=>this.getAnimals()
            
        )
        
    }


    renderButtons(){
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
    

    showInfo(animalId){
        this.props.history.replace("/adoption/"+animalId);
    }

    
    render(){
        return(
    <div>
      <List animales={this.state.animales} edit = {this.editAnimal} showButtons = {false} showInfo = {this.showInfo}></List>
      {this.renderButtons()}  
      </div>
        )
    }
}

export default AdoptionAnimalList