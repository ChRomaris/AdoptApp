import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import {login}  from '../../../backend/userService';
import {ToastsContainer, ToastsStore} from 'react-toasts';
import {NavLink} from 'react-router-dom';
import logo from '../../../images/cat2.gif';
import {FormattedMessage} from 'react-intl';
import {connect} from 'react-redux';
import {getPreferences} from '../actions/actions';


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

    componentDidMount(){
      if(sessionStorage.getItem('serviceToken')!=null){
        this.props.history.replace("/List")
      }
    }

    handleChange(e) {
        let target = e.target;
        let value = target.type === 'checkbox' ? target.checked : target.value;
        let name = target.name;

        this.setState({
          [name]: value
        },()=>{console.log(this.state)});
    }



    handleSubmit(e) {

      console.log('The form was submitted with the following data:');
        e.preventDefault();
        
        const loginData = {
          username: this.state.userName,
          password: this.state.password
        };
              login(loginData)
              .then(response => {
                
                  sessionStorage.setItem('serviceToken', response.token);
                  sessionStorage.setItem('userId', response.id);
                  sessionStorage.setItem('username', response.username);
                  ToastsStore.success("Logueado Correctamente");
                  this.props.getPreferences(response.token);
                  this.props.history.replace("/List")   
              }).catch(error => {
                      console.log(error)
                     ToastsStore.error(error.globalError);
              });

              



          
    
        console.log(this.state);
    }   



    render() {

        return (
          <div className="App">
            
          <div className="App__Aside"> <img src={logo} alt="loading..." />
            <p className="MainText"> AdoptApp </p>
           </div>
          <div className="App__Form">
        <div className="FormCenter">
          <ToastsContainer store={ToastsStore}/>
          <div className="PageSwitcher">
                <NavLink to="/" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item"><FormattedMessage id='form.button.access'/></NavLink>
                <NavLink exact to="/signUp" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item"><FormattedMessage id='form.button.register'/></NavLink>
              </div>

            <form onSubmit={this.handleSubmit} className="FormFields">
            <div className="FormField">
            <label className="FormField__Label" htmlFor="userName"><FormattedMessage id='form.label.user'/></label>
                <input type="text" id="userName" className="FormField__Input"  name="userName" value={this.state.userName} onChange={this.handleChange} required />
              </div>

              <div className="FormField">
                <label className="FormField__Label" htmlFor="password"><FormattedMessage id='form.label.password'/></label>
                <input type="password" id="password" className="FormField__Input"  name="password" value={this.state.password} onChange={this.handleChange} required/>
              </div>

              <div className="FormField">
                  <button type="submit" className="FormField__Button mr-20"><FormattedMessage id='form.button.access'/></button> <Link to="/signUp" className="FormField__Link"><FormattedMessage id='form.link.createAccount'/></Link>
              </div>
              <Link to="/List" className="FormField__Link"><FormattedMessage id='form.button.anonimous'/></Link>
            </form>
            </div>
            </div>
            </div>
        );}}

    
const mapStateToProps = state =>({
  profilePreferences : state.user.profilePreferences
})

export default connect(mapStateToProps,{getPreferences})(SignInForm);