import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import {registerUpdateUser}  from '../actions';
import {ToastsContainer, ToastsStore} from 'react-toasts';
import {NavLink} from 'react-router-dom';
import logo from '../../../images/cat2.gif';


class SignUpForm extends Component {
    constructor() {
        super();

        this.state = {
            userName: '',
            email: '',
            password: '',
            name: '',
            lastname1: '',
            lastname2: '',
            hasAgreed: false
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        

    }

    handleChange(e) {
        let target = e.target;
        let value = target.type === 'checkbox' ? target.checked : target.value;
        let name = target.name;
        let userName = target.userName;
        let email = target.email;
        let password = target.password;
        let lastname1 = target.lastname1;
        let lastname2 = target.lastname2;

        this.setState({
          [name]: value,
          [userName] : target.userName,
          [email] : target.email,
          [password] : target.password,
          [lastname1] :target.lastname1,
          [lastname2] : target.lastname2
        });
    }

    handleSubmit(event) {
        event.preventDefault();
        const signupRequest = {
          name : this.state.name, 
          lastname1 : this.state.lastname1,
          lastname2 : this.state.lastname2,
          userName: this.state.userName,
          email: this.state.email,
          password: this.state.password,
          hasAgreed : this.state.hasAgreed
        };
        
        registerUpdateUser(signupRequest)
          .then(response => { 
            sessionStorage.setItem('serviceToken', response.serviceToken);
            sessionStorage.setItem('userId', response.id);
            ToastsStore.success("Registrado Correctamente");
            this.props.history.replace("/addLocation")

        }).catch(error => {
          ToastsStore.error("Algo ha salido mal");
        });
    };



    render() {
      
        return (
          
          <div className="App">
            
            <div className="App__Aside"> <img src={logo} alt="loading..." />
            <p className="MainText">AdoptApp</p>
           </div>
          <div className="App__Form">
        <div className="FormCenter">
        <ToastsContainer store={ToastsStore}/>
              <div className="PageSwitcher">
                <NavLink to="/"  className="PageSwitcher__Item">Acceder</NavLink>
                <NavLink exact to="/signUp" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item">Registrarse</NavLink>
              </div>
        <div className="FormTitle">
                  <NavLink to="/"  className="FormTitle__Link">Acceder</NavLink> o <NavLink exact to="/signUp" activeClassName="FormTitle__Link--Active" className="FormTitle__Link">Registrarse</NavLink>
              </div>              <div className="FormField">
                <label className="FormField__Label" htmlFor="userName">Usuario</label>
                <input type="text" id="userName" className="FormField__Input" placeholder="Introducir usuario" name="userName" value={this.state.userName} onChange={this.handleChange} required />
              </div>
              
              <div className="FormField">
                <label className="FormField__Label" htmlFor="password">Contraseña</label>
                <input type="password" id="password" className="FormField__Input" placeholder="Introducir Contraseña" name="password" value={this.state.password} onChange={this.handleChange} required />
              </div>

            <form ref={node => this.form = node} onSubmit={(e) => this.handleSubmit(e)} className="FormFields">
              <div className="FormField">
                <label className="FormField__Label" htmlFor="name">Nombre</label>
                <input type="text" id="name" className="FormField__Input" placeholder="Introducir nombre completo" name="name" defaultValue={this.state.name} onChange={this.handleChange} required />
              </div>

              <div className="FormField">
                <label className="FormField__Label" htmlFor="name">Apellido 1</label>
                <input type="text" id="apellido1" className="FormField__Input" placeholder="Introducir nombre completo" name="apellido1" defaultValue={this.state.lastname1} onChange={this.handleChange} required />
              </div>

              <div className="FormField">
                <label className="FormField__Label" htmlFor="name">Apellido 2</label>
                <input type="text" id="apellido2" className="FormField__Input" placeholder="Introducir nombre completo" name="apellido2" defaultValue={this.state.lastname2} onChange={this.handleChange} required />
              </div>

              <div className="FormField">
                <label className="FormField__Label" htmlFor="email">Correo Electrónico</label>
                <input type="email" id="email" className="FormField__Input" placeholder="Introducir correo electónico" name="email" value={this.state.email} onChange={this.handleChange} required />
              </div>
              <div className="FormField">
                  <button type ="submit" className="FormField__Button mr-20">Registrarse</button> <Link to="/" className="FormField__Link">Ya tengo cuenta</Link>
              </div>
            </form>
          </div>
          </div>
          </div> );
    }
}
export default SignUpForm;