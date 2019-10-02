import React,{ Component } from "react";
import LostAnimalsList from './LostAnimalsList';

import {getLostAnimals} from '../../actions';
import {TopMenu} from '../../../app'

class LostAnimalsPage extends Component{
    constructor(props){
        super()
        this.state = {
            animalList : [],
            actualPage : 0,
            maxPage : 0
        }

        this.getLostAnimalList = this.getLostAnimalList.bind(this);
        this.nextPage = this.nextPage.bind(this);
        this.previousPage = this.previousPage.bind(this);
    }

    componentDidMount(){
        this.getLostAnimalList()
    }

    getLostAnimalList(){
        const params = {
            userToken : sessionStorage.getItem('serviceToken'),
            page : this.state.actualPage
        }
        getLostAnimals(params).then(response =>{
            this.setState({
                animalList : response.lostAnimals,
                maxPage : Math.ceil(response.totalPages)-1
            },()=>console.log(this.state.actualPage))
        }).catch(error =>{
            console.log(error)
        })
    }

    nextPage(){
        console.log("pagina siguiente")
        var previousPage = this.state.actualPage
        this.setState({
            actualPage : previousPage + 1
        },()=>this.getLostAnimalList())
    }

    previousPage(){
        var previousPage = this.state.actualPage
        console.log("pagina anterior")
        this.setState({
            actualPage : previousPage -1
        },()=>this.getLostAnimalList())
    }

    render(){
        return(
        <div>
            <TopMenu></TopMenu>
            <LostAnimalsList animalList={this.state.animalList} nextPage= {this.nextPage} previousPage = {this.previousPage} maxPage = {this.state.maxPage} actualPage = {this.state.actualPage}></LostAnimalsList>
        </div>
        )
    }
}

export default LostAnimalsPage