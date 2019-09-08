import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import {register}  from '../actions';
import {ToastsContainer, ToastsStore} from 'react-toasts';
import {NavLink} from 'react-router-dom';
import logo from '../../../images/cat2.gif';


class SignUpForm extends Component {
    constructor() {
        super();

        this.state = {
            userName: '',
            password: '',
            type:null,
            name:null,
            phoneNumber: null,
            email: null,
            address:null,
            description:null,
            lastname: null,
            lastname2: null,
            genre: null,
            isShelter: false
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleCheck = this.handleCheck.bind(this);

    }

    componentDidMount(){
      if(sessionStorage.getItem('serviceToken')!=null){
        this.props.history.replace("/List")
      }
    }

    handleChange(e) {
     
        let target = e.target;
        this.setState({
          [target.name] : target.value,
        },()=>{console.log(this.state)});
    }

    handleCheck(e){

      
      if(this.state.isShelter){
        this.setState({
          isShelter: false
        },()=>{console.log(this.state)});
      }else{
        this.setState({
          isShelter:true
        },()=>{console.log(this.state)});
      }

      
    }

    handleSubmit(event) {
        event.preventDefault();
        const signUpShelter = {

          username: this.state.userName,
          password: this.state.password,
          shelterDTO : {
            type: this.state.type,
            name:this.state.name,
            phoneNumber: this.state.phoneNumber,
            email: this.state.email,
            address: this.state.address,
            description: this.state.description
          }

        }

        const signUpUser = {

          username: this.state.userName,
          password: this.state.password,
          userDTO : {
            name: this.state.name,
            lastname: this.state.lastname,
            lastname2: this.state.lastname2,
            email: this.state.email,
            address: this.state.address,
            genre: this.state.genre
          }

        }

        if(this.state.isShelter){
         
          register(signUpShelter)
          .then(response => { 
            sessionStorage.setItem('serviceToken', response.token);
            sessionStorage.setItem('userId', response.id);
            ToastsStore.success("Registrado Correctamente");
            this.props.history.replace("/addLocation")

        }).catch(error => {
          ToastsStore.error(error.globalError);
        });
        }else{
          register(signUpUser)
          .then(response => { 
            sessionStorage.setItem('serviceToken', response.token);
            sessionStorage.setItem('userId', response.id);
            ToastsStore.success("Registrado Correctamente");
            this.props.history.replace("/addLocation")

        }).catch(error => {
          ToastsStore.error(error.globalError);
        });
        }

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
                <input type="text" id="userName" className="FormField__Input" placeholder="Introducir usuario" name="userName" defaultValue={this.state.userName} onChange={this.handleChange} required />
              </div>
              
              <div className="FormField">
                <label className="FormField__Label" htmlFor="password">Contraseña</label>
                <input type="password" id="password" className="FormField__Input" placeholder="Introducir Contraseña" name="password" defaultValue={this.state.password} onChange={this.handleChange} required />
              </div>
              <div className="FormField">
                <label className="FormField__Label" htmlFor="password">Asociación</label>
                <input type="checkbox" id="isShelter" defaultChecked={this.state.isShelter}  name="isShelter"  onChange={this.handleCheck}/>
              </div>
            <form ref={node => this.form = node} onSubmit={(e) => this.handleSubmit(e)} className="FormFields">
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