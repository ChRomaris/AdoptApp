import React,{ Component } from "react";
import ShelterList from './ShelterList';
import TopMenu from '../../app/components/TopMenu';

class ShelterListPage extends Component{
    constructor(props){
        super(props)
        this.showShelterAnimals = this.showShelterAnimals.bind(this);
    }

    showShelterAnimals(shelterId){
        this.props.history.replace("/list/"+shelterId)
    }

    render(){
        return(
        <div>
            <TopMenu/>
            <ShelterList showAnimals = {this.showShelterAnimals}/>
        </div>)
    }
}

export default ShelterListPage;