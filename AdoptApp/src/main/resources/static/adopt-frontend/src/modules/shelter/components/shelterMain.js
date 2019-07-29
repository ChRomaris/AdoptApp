import React, {Component} from 'react';
import ShelterAnimalList from './ShelterAnimalList';
import {findShelterByUser} from '../actions';
import shelterCreationForm from './ShelterCreationForm';

function ShelterExists(props){
    const name = props.shelterName;

    if(name !=null){
        return <ShelterAnimalList/>;
    }else{
        return <shelterCreationForm/>;
    }
}

class shelterMain extends Component{

    constructor(){
        super();
        this.state = {
            shelterName : null
        }
    }


    componentDidMount(){

        const user = {
            userToken : sessionStorage.getItem('serviceToken')
        };

        findShelterByUser(user).then(response => {
            this.setState ({
                shelterName : response.name
            })
        }).catch(error => {
            this.props.history.replace("/shelterAdd")
        })
        
    }




render(){
    return (
        <div >
            <ShelterExists shelterName={this.state.shelterName}/> 
        </div>
    );
}

}

export default shelterMain;