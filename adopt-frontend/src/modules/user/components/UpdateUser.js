import { getUserInfo, updateUser } from '../actions';
import React, { Component } from 'react';
import { ToastsContainer, ToastsStore } from 'react-toasts';
import { TopMenu } from '../../app/';
import AddLocationMap from '../components/AddLocationMap';
import { FormattedMessage } from 'react-intl';
import {connect} from 'react-redux';
import {getUserEnums} from '../actions/actions';


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
            genre : '',
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
                name: response.userDTO.name,
                userName: response.userName,
                lastname: response.userDTO.lastname,
                lastname2: response.userDTO.lastname2,
                genre : response.userDTO.genre,
                password: response.password,
                email: response.userDTO.email,
                address: response.userDTO.address,
                latitude: response.latitude,
                longitude: response.longitude
            }, this.setMapLocation)
            console.log(response)
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
        let lastname = target.lastname;
        let lastname2 = target.lastname2;
        let genre = target.genre;
        let password = target.password;
        let email = target.email;
        let phoneNumber = target.phoneNumber;
        let address = target.adress;

        this.setState({
            [name]: value,
            [lastname]: value,
            [lastname2]: value,
            [genre]: value,
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
            userDTO: {
                name: this.state.name,
                lastname: this.state.lastname,
                lastname2: this.state.lastname2,
                genre : this.state.genre,
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
                                <div className="FormField" >
                                    <label className="FormField__Label" htmlFor="lastname" > <FormattedMessage id="form.label.lastname" /> </label>
                                    <input type="text" id="lastname" className="FormField__Input" placeholder="Introducir primer apellido1" name="lastname" defaultValue={this.state.lastname || ''} onChange={this.handleChange} required />
                                </div>
                                <div className="FormField" >
                                    <label className="FormField__Label" htmlFor="lastname2" > <FormattedMessage id="form.label.lastname2" />  </label>
                                    <input type="text" id="lastname2" className="FormField__Input" placeholder="Introducir segundo apellido2" name="lastname2" defaultValue={this.state.lastname2 || ''} onChange={this.handleChange} />
                                </div>
                                <div className="FormField">
                                    <label className="FormField__Label" htmlFor="genre"><FormattedMessage id='form.label.genre' /></label>
                                    <select name = "genre" id="genre" className="FormField__Input" value = {this.state.genre || ''} onChange = {this.handleChange} required>
                                        {this.props.enumValues.genres.map(genre => {
                                            return <option key={genre}>{genre}</option>
                                        })}
                                    </select>
                                </div>
                                <div className="FormField" >
                                    <label className="FormField__Label" htmlFor="password" > <FormattedMessage id="form.label.password" />  </label>
                                    <input type="password" id="password" className="FormField__Input" placeholder="Introducir Contraseña" name="password" value={this.state.password || ''} onChange={this.handleChange} required />
                                </div>
                                <div className="FormField" >
                                    <label className="FormField__Label" htmlFor="email" > <FormattedMessage id="form.label.email" /> </label>
                                    <input type="email" id="email" className="FormField__Input" placeholder="Introducir correo electónico" name="email" value={this.state.email || ''} onChange={this.handleChange} required />
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
export default connect(mapStateToProps, {getUserEnums})(UpdateUser);