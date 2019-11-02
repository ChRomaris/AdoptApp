import React,{ Component } from "react";
import {getShelterList} from '../actions';
import {Button} from 'reactstrap';

class ShelterList extends Component{
constructor(props){
    super(props)

    this.state = {
        shelters : []
    }

    this.getShelters = this.getShelters.bind(this);
    this.renderShelter = this.renderShelter.bind(this);
}

componentDidMount(){
    this.getShelters();
}

getShelters(){
    getShelterList().then(response=>{
        console.log(response)
        this.setState ({
            shelters: response.shelters
        },()=>console.log(this.state))
    })
}

renderShelter(shelter){
    return <tr><td><p>{shelter.name}</p></td><td><p>{shelter.address}</p></td><td><Button onClick={()=>this.props.showAnimals(shelter.id)}>Ver Animales</Button></td></tr>
}

    render(){
        return(
            <div className = "shelterListSection">
                <table className = "shelterTable">
                        <tbody>
                            <tr className="namesRow"><td><p>Nombre</p></td><td><p>Dirección</p></td><td></td></tr>
                            {this.state.shelters.map(shelter => (
                                this.renderShelter(shelter)
                            ))}
                    </tbody>
                </table>

            </div>
        )
    }
}

export default ShelterList;