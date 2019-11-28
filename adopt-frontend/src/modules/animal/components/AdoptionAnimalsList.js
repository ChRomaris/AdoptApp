import React, { Component } from "react";
import {getAllAdoptionAnimals} from '../actions';
import List from '../../mainList/components/List';
import { Button } from 'reactstrap';
import {getShelterAnimals} from '../../shelter/actions';
import Filter from '../../common/Filter';
import { Link } from 'react-router-dom';

class AdoptionAnimalList extends Component{

    constructor(props){
        super()
        this.state = {
            error : false,
            animales : [],
            actualPage : 0,
            totalPages : 0,
            filter : {
                breed: null,
                genre: null,
                size: null,
                color: null
            }
        }

        this.showInfo = this.showInfo.bind(this);
        this.renderButtons = this.renderButtons.bind(this);
        this.nextPage = this.nextPage.bind(this);
        this.previousPage = this.previousPage.bind(this);
        this.getAnimals = this.getAnimals.bind(this);
        this.handleFilter = this.handleFilter.bind(this);
    }
    
    componentDidMount(){
        if(this.props.match.params.shelterId){
            console.log("con id")
            this.getAnimalsWithId(this.props.match.params.shelterId)
        }else{
            console.log("sin id")
            this.getAnimals();
        }
        

    }

    getAnimals (){

        const params = {
            userToken : sessionStorage.getItem("serviceToken"),
            page: this.state.actualPage,
            filter: this.state.filter
        }
        console.log("GetAnimals con parametros : " )
        console.log(params)
        console.log("Los nuevos animales son:")
        getAllAdoptionAnimals(params).then(response => {
            this.setState( {
                animales : response.adoptionAnimals,
                totalPages : response.totalPages
                
            },()=>console.log(this.state))
            
        }).catch(error => {
            console.log(error)
        })
    }

    getAnimalsWithId (shelterId){

        const params = {
            page: this.state.actualPage,
            shelterId: shelterId,
            filter : this.state.filter
        }
        console.log("GetAnimals con parametros : " )
        console.log(params)
        getShelterAnimals(params).then(response => {
            this.setState( {
                animales : response.adoptionAnimals,
                totalPages : response.totalPages
                
            },()=>console.log(this.state))
            
        }).catch(error => {
            this.setState({
                error : true
            })
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

    handleFilter(filter){
        this.setState({
            filter: filter
        })
        const params = {
                userToken : sessionStorage.getItem("serviceToken"),
                page: this.state.actualPage,
                filter: filter
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

    
    render(){
        if(this.state.error === true ){
            return(
                <div>
                    <h2>Asociación Inválida</h2>
                    <Link to="/" className="FormField__Link">Volver al inicio</Link>
                </div>
            )
        }
        else{
            return(

                <div>
                    
                  <Filter handleFilter = {this.handleFilter}></Filter>
                  <List animales={this.state.animales} edit = {this.editAnimal} showButtons = {false} showInfo = {this.showInfo}></List>
                  {this.renderButtons()}  
                  </div>
                    )
        }

    }
}

export default AdoptionAnimalList