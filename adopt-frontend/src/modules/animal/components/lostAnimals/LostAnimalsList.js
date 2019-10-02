import React,{ Component } from "react";
import { ToastsContainer, ToastsStore } from 'react-toasts';
import { Container, Button } from 'reactstrap';
import LostAnimalCard from './LostAnimalCard';

import '../animalStyles.css'

class LostAnimalsList extends Component{
    constructor(props){
        super()
        this.state = {
            animalList : []
        }

        this.renderButtons = this.renderButtons.bind(this)
    }

    renderButtons(){
        console.log("maxima" + this.props.maxPage)
        console.log("actual" + this.props.actualPage)
        if(this.props.maxPage === this.props.actualPage)
        {
            return(
                <div className ="previousButton">
                <Button onClick={this.props.previousPage} >
                    Anterior
                </Button>
                </div>
            )
        }else if (this.props.actualPage === 0){
            return(
                <div className ="previousButton">
                <Button onClick={this.props.nextPage} >
                    Siguiente
                </Button>
                </div> 
            )
        }else{
            return(
                <div className = "previousNextButtons">
                     <div className ="previousButton">
                        <Button onClick={this.props.previousPage} >
                            Anterior
                        </Button>
                    </div>
                    <div className ="nextButton">
                        <Button onClick={this.props.nextPage} >
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
                    {this.props.animalList.map(animal => (
                        <LostAnimalCard key={animal.name} animal={animal}></LostAnimalCard>
                    ))}
                </div>
                {this.renderButtons()}
            </Container>
            
        </div> 
        )
    }
}

export default LostAnimalsList