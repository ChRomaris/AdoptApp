import { getUserInfo, updateUser } from '../actions'
import React, { Component } from 'react';
import { ToastsContainer, ToastsStore } from 'react-toasts';
import { TopMenu } from '../../app/'
import AddLocationMap from '../components/AddLocationMap'

import '../../../styles/userStyles.css'

class UpdateUser extends Component {

    constructor() {
        super();

        this.state = {
            id: '',
            userName: '',
            name: '',
            lastname: '',
            lastname2: '',
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
        const userInfo = {
            token: sessionStorage.getItem('serviceToken')
        }

        getUserInfo(userInfo).then(response => {
            this.setState({
                id: response.id,
                name: response.name,
                userName: response.userName,
                lastname: response.userDTO.lastname,
                lastname2: response.userDTO.lastname2,
                password: response.password,
                email: response.userDTO.email,
                phoneNumber: response.phoneNumber,
                address: response.userDTO.address,
                latitude: response.latitude,
                longitude: response.longitude
            },this.setMapLocation)
        }).catch(error => {
            console.log("Error al recuperar la información del usuario")
        });
    }

    setMapLocation(){
        this.mapComponent.current.setMapPointer(this.state.latitude, this.state.longitude)
    }

    handleChange(e) {



        let target = e.target;
        let value = target.type === 'checkbox' ? target.checked : target.value;
        let name = target.name;
        let lastname = target.lastname;
        let lastname2 = target.lastname2;
        let password = target.password;
        let email = target.email;
        let phoneNumber = target.phoneNumber;
        let address = target.adress;

        this.setState({
            [name]: value,
            [lastname]: value,
            [lastname2]: value,
            [password]: value,
            [email]: value,
            [phoneNumber]: value,
            [address]: value
        });
    }

    handleSubmit(event) {
        event.preventDefault();
        const updateUserParams = {
            id: this.state.id,
            username: this.state.userName,
            password: this.state.password,
            token: sessionStorage.getItem('serviceToken'),
            latitude: this.state.latitude,
            longitude: this.state.longitude,
            userDTO : {
                name: this.state.name,
                lastname: this.state.lastname,
                lastname2: this.state.lastname2,
                email: this.state.email,
                address: this.state.address,
            }
        };

        updateUser(updateUserParams)
            .then(response => {
                ToastsStore.success("Registrado Correctamente");
            }).catch(error => {
                ToastsStore.error("Algo ha salido mal");
            });
    };

    setLocationState(lat,long){
        this.setState({
            latitude:lat,
            longitude:long
        },() => {console.log("Latitud: " + this.state.longitude+ " Longitud: "+ this.state.longitude)})
    }


    render() {
        return (
            <div className= "editingSectionComplete">
                <TopMenu ></TopMenu>
                <div className="userEditSection" >
                    <div className="Simple_Form" >
                        <div className="FormCenter" >
                            <ToastsContainer store={ToastsStore} /> 
                            <h3>Información Personal </h3>
                            <form ref={node => this.form = node} onSubmit={(e) => this.handleSubmit(e)} className="FormFields" >
                                <div className="FormField" >
                                    <label className="FormField__Label" htmlFor="name"> Nombre:  </label>
                                    <input type="text" id="name" className="FormField__Input" placeholder="Introducir nombre completo" name="name" defaultValue={this.state.name || ''} onChange={this.handleChange} required />
                                </div>
                                <div className="FormField" >
                                    <label className="FormField__Label" htmlFor="lastname" > Apellido1: </label>
                                    <input type="text" id="lastname" className="FormField__Input" placeholder="Introducir primer apellido1" name="lastname" defaultValue={this.state.lastname || ''} onChange={this.handleChange} required />
                                </div>
                                <div className="FormField" >
                                    <label className="FormField__Label" htmlFor="lastname2" > Apellido2:  </label>
                                    <input type="text" id="lastname2" className="FormField__Input" placeholder="Introducir segundo apellido2" name="lastname2" defaultValue={this.state.lastname2 || ''} onChange={this.handleChange} />
                                </div>
                                <div className="FormField" >
                                    <label className="FormField__Label" htmlFor="password" > Contraseña:  </label>
                                    <input type="password" id="password" className="FormField__Input" placeholder="Introducir Contraseña" name="password" value={this.state.password || ''} onChange={this.handleChange} required />
                                </div>
                                <div className="FormField" >
                                    <label className="FormField__Label" htmlFor="email" > Correo Electrónico: </label>
                                    <input type="email" id="email" className="FormField__Input" placeholder="Introducir correo electónico" name="email" value={this.state.email || ''} onChange={this.handleChange} required />
                                </div>
                                <div className="FormField" >
                                    <label className="FormField__Label" htmlFor="phoneNumber" > Numero de Teléfono: </label>
                                    <input type="number" id="phoneNumber" className="FormField__Input" placeholder="Introducir numero de telefono" name="phoneNumber" value={this.state.phoneNumber || ''} onChange={this.handleChange} />
                                </div>
                                <div className="FormField" ><label className="FormField__Label" htmlFor="address" > Dirección:</label>
                                    <input type="address" id="address" className="FormField__Input" placeholder="Introducir dirección" name="address" value={this.state.address || ''} onChange={this.handleChange} />
                                </div >
                                <div className="FormField" >
                                    <button type="submit" className="FormField__Button mr-20" > Actualizar Información </button> </div >
                            </form>
                        </div>
                    </div>
                    <div className="LocationPartForm" >
                        <h3>Posición</h3>
                        <AddLocationMap ref={this.mapComponent} setParentLocationState = {this.setLocationState} ></AddLocationMap>
                    </div>
                </div>
            </div >
        )
    }
}

export default UpdateUser;