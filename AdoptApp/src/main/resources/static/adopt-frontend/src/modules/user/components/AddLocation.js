import React, {Component} from 'react';
import { Link } from 'react-router-dom';
import AddLocationMap from './AddLocationMap'
import {setLocation} from '../actions'

import '../../../styles/userStyles.css'

class AddLocation extends Component {
    constructor(){
        super()
        this.state={
            latitude:'',
            longitude:''
        }

        this.setStateLocation = this.setStateLocation.bind(this);
        this.saveLocation = this.saveLocation.bind(this);
    }

    saveLocation(){
        console.log("Se guarda la localización: "+ this.state.latitude + this.state.longitude)
        const locationParams={
            latitude: this.state.latitude,
            longitude: this.state.longitude,
            userToken: sessionStorage.getItem('serviceToken')
        }
        setLocation(locationParams).then(response=>{
            console.log("Todo Correcto guardadando la localizacion")
            this.props.history.replace("/List")
            
        }).catch(error=>{
            console.log("Algo fue mal guardado la localizacion")
        })
    }

    setStateLocation (lat, long){
        this.setState({
            latitude: lat,
            longitude: long
        },() => {
            console.log("latitude: "+ this.state.latitude + "longitude: "+ this.state.longitude)
          })
    }

    handleSubmit(event){
        this.saveLocation();
        event.preventDefault();
    }

    render(){
        return(
            <div className="addLocationComplete">
            <p>
                Para una mejor experiencia recomendamos que añada su ubicación:
            </p>
             <div className="addLocationMainSection">
                 <AddLocationMap setParentLocationState = {this.setStateLocation}></AddLocationMap>
                 <form ref={node => this.form = node} onSubmit={(e) => this.handleSubmit(e)} className="FormFields">
                        <div className="FormField">
                            <div className="buttonSection">
                                <button type ="submit" className="FormField__Button mr-20">Añadir Localización</button>
                                <Link to="/List" className="FormField__Link">Continuar sin añadir</Link>
                           </div>
                     </div>
                    </form>
                </div>
            </div>

        )
    }
}

export default AddLocation;