import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import {login}  from '../actions';
import {ToastsContainer, ToastsStore} from 'react-toasts';
import {NavLink} from 'react-router-dom';
import logo from '../../../images/cat2.gif';
import {findShelterByUser} from '../../shelter/actions'


import '../../app/App.css';

class SignInForm extends Component {
    constructor() {
        super();

        this.state = {
            userName: '',
            password: '',
            redirect: false
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
       
    }

    handleChange(e) {
        let target = e.target;
        let value = target.type === 'checkbox' ? target.checked : target.value;
        let name = target.name;

        this.setState({
          [name]: value
        });
    }

    handleSubmit(e) {

      console.log('The form was submitted with the following data:');
        e.preventDefault();
        
        const loginData = {
          userName: this.state.userName,
          password: this.state.password
        };
              login(loginData)
              .then(response => {
                
                  sessionStorage.setItem('serviceToken', response.serviceToken);
                  sessionStorage.setItem('userId', response.id);
                  findShelterByUser (response.serviceToken).then(response => {
                    if(response.name != null){
                      sessionStorage.setItem('isAdmin', true );
                      sessionStorage.setItem('shelterName', response.name)
                    }else{
                      sessionStorage.setItem('isAdmin', false ); 
                      sessionStorage.setItem('shelterName', null)
                    }
                    
                  }).catch(error => {
                    ToastsStore.success("Error Recuperando asociación");
                  })
                  ToastsStore.success("Logueado Correctamente");
                  this.props.history.replace("/List")
                 
                
              }).catch(error => {
                  
                     ToastsStore.error("Error de login");
              });

              



          
    
        console.log(this.state);
    }   



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
                <NavLink to="/" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item">Acceder</NavLink>
                <NavLink exact to="/signUp" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item">Registrarse</NavLink>
              </div>
          <div className="FormTitle">
                  <NavLink to="/" activeClassName="FormTitle__Link--Active" className="FormTitle__Link">Acceder</NavLink> o <NavLink exact to="/signUp" activeClassName="FormTitle__Link--Active" className="FormTitle__Link">Registrarse</NavLink>
              </div>
            <form onSubmit={this.handleSubmit} className="FormFields">
            <div className="FormField">
            <label className="FormField__Label" htmlFor="userName">Usuario</label>
                <input type="text" id="userName" className="FormField__Input" placeholder="Introducir usuario" name="userName" value={this.state.userName} onChange={this.handleChange} required />
              </div>

              <div className="FormField">
                <label className="FormField__Label" htmlFor="password">Contraseña</label>
                <input type="password" id="password" className="FormField__Input" placeholder="Introducir Contraseña" name="password" value={this.state.password} onChange={this.handleChange} />
              </div>

              <div className="FormField">
                  <button type="submit" className="FormField__Button mr-20">Acceder</button> <Link to="/signUp" className="FormField__Link">Crear una cuenta</Link>
              </div>
            </form>
            </div>
            </div>
            </div>
        );}}

    


export default SignInForm;