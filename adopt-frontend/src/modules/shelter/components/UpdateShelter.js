import { updateShelter, getShelterInfo } from '../actions'
import React, { Component } from 'react';
import { ToastsContainer, ToastsStore } from 'react-toasts';
import { TopMenu } from '../../app/'
import AddLocationMap from '../../user/components/AddLocationMap';
import {connect} from 'react-redux';
import {getUserEnums} from '../../user/actions/actions'

import '../../../styles/userStyles.css'
import { FormattedMessage } from 'react-intl';

class UpdateShelter extends Component {

    constructor() {
        super();

        this.state = {
            id: '',
            userName: '',
            name: '',
            type: '',
            description: '',
            password: '',
            email: '',
            phoneNumber: '',
            address: '',
            latitude: '',
            longitude: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.setLocationState = this.setLocationState.bind(this);
        this.mapComponent = React.createRef();
    }

    componentDidMount() {
        const shelterInfo = {
            token: sessionStorage.getItem('serviceToken')
        }

        getShelterInfo(shelterInfo).then(response => {
            this.setState({
                id: response.id,
                name: response.shelterDTO.name,
                userName: response.userName,
                type: response.shelterDTO.type,
                description: response.shelterDTO.description,
                password: response.password,
                email: response.shelterDTO.email,
                phoneNumber: response.shelterDTO.phoneNumber,
                address: response.shelterDTO.address,
                latitude: response.latitude,
                longitude: response.longitude
            }, this.setMapLocation)
        }).catch(error => {
            console.log("Error al recuperar la información del usuario")
        });

        this.props.getUserEnums();
    }

    setMapLocation() {
        this.mapComponent.current.setMapPointer(this.state.latitude, this.state.longitude)
    }

    handleChange(e) {



        let target = e.target;
        let value = target.type === 'checkbox' ? target.checked : target.value;
        let name = target.name;
        let type = target.type;
        let description = target.description;
        let password = target.password;
        let email = target.email;
        let phoneNumber = target.phoneNumber;
        let address = target.adress;

        this.setState({
            [name]: value,
            [type]: value,
            [description]: value,
            [password]: value,
            [email]: value,
            [phoneNumber]: value,
            [address]: value
        });
    }

    handleSubmit(event) {
        event.preventDefault();
        const updateShelterParams = {
            id: this.state.id,
            username: this.state.userName,
            password: this.state.password,
            token: sessionStorage.getItem('serviceToken'),
            latitude: this.state.latitude,
            longitude: this.state.longitude,
            shelterDTO: {
                name: this.state.name,
                type: this.state.type,
                description: this.state.description,
                email: this.state.email,
                phoneNumber: this.state.phoneNumber,
                address: this.state.address,
            }
        };

        updateShelter(updateShelterParams)
            .then(response => {
                ToastsStore.success("Registrado Correctamente");
            }).catch(error => {
                ToastsStore.error("Algo ha salido mal");
            });
    };

    setLocationState(lat, long) {
        this.setState({
            latitude: lat,
            longitude: long
        }, () => { console.log("Latitud: " + this.state.longitude + " Longitud: " + this.state.longitude) })
    }


    render() {
        return (
            <div className="editingSectionComplete">
                <TopMenu ></TopMenu>
                <div className="userEditSection" >
                    <div className="LocationPartForm" >
                        <h3><FormattedMessage id="form.tittle.position" /></h3>
                        <AddLocationMap ref={this.mapComponent} setParentLocationState={this.setLocationState} ></AddLocationMap>
                    </div>
                    <div className="Simple_Form" >
                        <div className="FormCenter" >
                            <ToastsContainer store={ToastsStore} />
                            <h3><FormattedMessage id="form.tittle.personalInfo" /> </h3>
                            <form ref={node => this.form = node} onSubmit={(e) => this.handleSubmit(e)} className="FormFields" >
                                <div className="FormField" >
                                    <label className="FormField__Label" htmlFor="name"> <FormattedMessage id="form.label.name" />  </label>
                                    <input type="text" id="name" className="FormField__Input" placeholder="Introducir nombre completo" name="name" defaultValue={this.state.name || ''} onChange={this.handleChange} required />
                                </div>
                                <div className="FormField">
                                    <label className="FormField__Label" htmlFor="type"><FormattedMessage id='form.label.type' /></label>
                                    <select id="type" className="FormField__Input" name="type" defaultValue={this.state.type} onChange={this.handleChange} required >
                                        {this.props.enumValues.types.map(type => {
                                            return <option key={type}>{type}</option>
                                        })}
                                    </select>
                                </div>
                                <div className="FormField" >
                                    <label className="FormField__Label" htmlFor="lastname2" > <FormattedMessage id="form.label.description" />  </label>
                                    <input type="text" id="description" className="FormField__Input" placeholder="Introducir descripción" name="description" defaultValue={this.state.description || ''} onChange={this.handleChange} />
                                </div>
                                <div className="FormField" >
                                    <label className="FormField__Label" htmlFor="password" > <FormattedMessage id="form.label.password" />  </label>
                                    <input type="password" id="password" className="FormField__Input" placeholder="Introducir Contraseña" name="password" value={this.state.password || ''} onChange={this.handleChange} required />
                                </div>
                                <div className="FormField" >
                                    <label className="FormField__Label" htmlFor="email" > <FormattedMessage id="form.label.email" /> </label>
                                    <input type="email" id="email" className="FormField__Input" placeholder="Introducir correo electónico" name="email" value={this.state.email || ''} onChange={this.handleChange} required />
                                </div>
                                <div className="FormField" >
                                    <label className="FormField__Label" htmlFor="phoneNumber" > <FormattedMessage id="form.label.phoneNumber" /> </label>
                                    <input type="number" id="phoneNumber" className="FormField__Input" placeholder="Introducir numero de telefono" name="phoneNumber" value={this.state.phoneNumber || ''} onChange={this.handleChange} />
                                </div>
                                <div className="FormField" ><label className="FormField__Label" htmlFor="address" > <FormattedMessage id="form.label.address" /></label>
                                    <input type="address" id="address" className="FormField__Input" placeholder="Introducir dirección" name="address" value={this.state.address || ''} onChange={this.handleChange} />
                                </div >
                                <div className="FormField" >
                                    <button type="submit" className="FormField__Button mr-20" > <FormattedMessage id="form.button.updateInfo" /> </button> </div >
                            </form>
                        </div>
                    </div>

                </div>
            </div >
        )
    }
}

const mapStateToProps = state => ({
    enumValues : state.user.userSelectorValues
})
    


export default connect(mapStateToProps,{getUserEnums})(UpdateShelter);