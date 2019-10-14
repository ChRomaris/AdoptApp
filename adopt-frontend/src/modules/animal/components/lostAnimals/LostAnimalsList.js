import React,{ Component } from "react";
import { ToastsContainer, ToastsStore } from 'react-toasts';
import { Container, Button } from 'reactstrap';
import LostAnimalCard from './LostAnimalCard';
import {getAnimals, nextPage, previousPage, getUserAnimals} from './actions/actions';
import {connect} from 'react-redux';

import '../animalStyles.css'

class LostAnimalsList extends Component{
    constructor(props){
        super()

        this.renderButtons = this.renderButtons.bind(this)
        this.getAnimals = this.getAnimals.bind(this)
        this.nextPage = this.nextPage.bind(this)
        this.previousPage = this.previousPage.bind(this)
    }


    componentWillReceiveProps (newProps){
        
        //SI SE CAMBIA DE PAGINA SE REALIZA LA BUSQUEDA DE NUEVO
        if(newProps.actualPage !== this.props.actualPage){
            const params = {
                userToken : sessionStorage.getItem('serviceToken'),
                page : newProps.actualPage
            }
        if (this.props.isUserList){
            this.props.getUserAnimals(params)
        }else{
            this.props.getAnimals(params);
        }
        
        }
    }

    getAnimals(){
        const params = {
            userToken : sessionStorage.getItem('serviceToken'),
            page : this.props.actualPage
        }

        this.props.getAnimals(params);
    }

    nextPage(){
        this.props.nextPage() 
    }

    previousPage(){
        this.props.previousPage()

    }

    renderButtons(){
        if(this.props.maxPage === 0){

        }
        else if(this.props.maxPage === this.props.actualPage)
        {
            return(
                <div className ="previousButton">
                 <Button onClick={this.previousPage} >
                    Anterior
                </Button>
                </div>
            )
        }else if (this.props.actualPage === 0){
            return(
                <div className ="previousButton">
               <Button onClick={this.nextPage} >
                    Siguiente
                </Button>
                </div> 
            )
        }
        else{
        return(
                <div className = "previousNextButtons">
                     <div className ="previousButton">
                     <Button onClick={this.previousPage} >
                            Anterior
                        </Button>
                    </div>
                    <div className ="nextButton">
                    <Button onClick={this.nextPage} >
                            Siguiente
                        </Button>
                    </div> 
                </div>
            )
        }
    }

    render(){
        return(
            <div>
            <Container>
                <ToastsContainer store={ToastsStore} />
                <div>
                {this.props.lostAnimals.map(animal => (
                    console.log(animal.id),
                        <LostAnimalCard key={animal.id} animal={animal} redirectLocations = {this.props.redirectLocations} showForm = {this.props.showForm}></LostAnimalCard>
                    ))}
                </div>
                {this.renderButtons()}
            </Container>
            
        </div> 
        )
    }
}

const mapStateToProps = state => ({
    lostAnimals : state.lostAnimals.animals,
    actualPage : state.lostAnimals.actualPage,
    maxPage : state.lostAnimals.maxPage,
    isUserList : state.lostAnimals.isUserList

})

export default connect (mapStateToProps, {getAnimals, nextPage, previousPage, getUserAnimals})(LostAnimalsList) 