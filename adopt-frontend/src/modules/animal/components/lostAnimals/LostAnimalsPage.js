import React,{ Component } from "react";
import LostAnimalsList from './LostAnimalsList';
import {TopMenu} from '../../../app'
import AddLocationModal from './AddLocationModal';

class LostAnimalsPage extends Component{


    render(){
        return(
        <div>
            <TopMenu></TopMenu>
            <AddLocationModal></AddLocationModal>
            <LostAnimalsList></LostAnimalsList>
        </div>
        )
    }
}

export default LostAnimalsPage