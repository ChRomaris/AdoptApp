import React, {Component} from 'react';
import ShelterAnimalList from './ShelterAnimalList';
import {findShelterByUser} from '../actions';
import ShelterCreationForm from './ShelterCreationForm';

function ShelterExists(props){
    const name = props.shelterName;
    const isEdit = props.isEdit;

    if(name !=null && isEdit === false){
        return <ShelterAnimalList/>;
    }else{
        
        return <ShelterCreationForm shelterId={props.shelterId} isEdit={props.isEdit}/>;
    }
}

class shelterCreation extends Component{

    constructor(){
        super();
        this.state = {
            shelterName : null,
            shelterId: '',
            isEdit: false
        }

        this.getShelterInfo = this.getShelterInfo.bind(this);
    }

    componentWillReceiveProps(nextProps){
        this.setState ({    
            isEdit:nextProps.isEdit
        },()=>this.getShelterInfo())
    }


    componentDidMount(){
        console.log("Editando en shelterCreation: " +this.props.isEdit)
        this.getShelterInfo();
        
    }

    getShelterInfo(){
        const user = {
            userToken : sessionStorage.getItem('serviceToken')
        };

        findShelterByUser(user).then(response => {
            this.setState ({    
                shelterName : response.name,
                shelterId : response.shelterId,
                isEdit:this.props.isEdit
            },()=>console.log("Se actualiza el estado con el id: "+ this.state.shelterId))
        }).catch(error => {
            console.log("Falla al recuperar el nombre de la asociación")
           
        })
    }




render(){
    return (
        <div >
            <ShelterExists shelterName={this.state.shelterName} shelterId={this.state.shelterId} isEdit={this.props.isEdit} /> 
        </div>
    );
}

}

export default shelterCreation;