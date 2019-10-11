import React,{ Component } from "react";
import LostAnimalsList from './LostAnimalsList';
import {TopMenu} from '../../../app';
import {connect} from 'react-redux';
import {getUserAnimals} from './actions/actions'

class MyLostAnimalsPage extends Component{
    constructor(){
        super()
        this.locationsClick = this.locationsClick.bind(this)
    }

    componentDidMount(){
        const params = {
            token: sessionStorage.getItem('serviceToken')
        }

        this.props.getUserAnimals(params)
    }


    locationsClick(){
        this.props.history.replace("/animal/locations")
    }

    render(){
        return(
        <div>
        <TopMenu></TopMenu>
        <LostAnimalsList redirectLocations={this.locationsClick}></LostAnimalsList>
    </div>)
    }

    
}

const mapStateToProps = state => (console.log(state),{
    lostAnimals : state.lostAnimals.animals,

})

export default connect (mapStateToProps, {getUserAnimals}) (MyLostAnimalsPage)