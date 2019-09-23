import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import {register}  from '../actions';
import {ToastsContainer, ToastsStore} from 'react-toasts';
import {NavLink} from 'react-router-dom';
import logo from '../../../images/cat2.gif';
import {FormattedMessage} from 'react-intl'


class InfoUserForm extends Component {
    constructor() {
        super();

        this.state = {
            userName: '',
            password: '',
            name:'',
            email: '',
            address:'',
            lastname1:'',
            lastname2: '',
            genre: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

    }

    componentDidMount(){

    }

    handleChange(e) {
     
        let target = e.target;
        this.setState({
          [target.name] : target.value,
        },()=>{console.log(this.state)});
    }


    handleSubmit(e) {
        e.preventDefault();
        this.props.handleSubmitUser(this.state.name, this.state.lastname, this.state.lastname2, this.state.email, this.state.genre, this.state.address);
    
    };



    render() {
      
        return (
          
        <div className="FormCenter">
            <div className="UserInfoSectionTittle">
             <h4><FormattedMessage id='form.tittle.personalInfo'/></h4>
             </div>
             <div className="FormField">
                <label className="FormField__Label" htmlFor="name"><FormattedMessage id='form.label.name'/></label>
                <input type="text" id="name" className="FormField__Input" placeholder="Introducir nombre Asociación" name="name" defaultValue={this.state.name} onChange={this.handleChange} required />
              </div>

              <div className="FormField">
                <label className="FormField__Label" htmlFor="lastname"><FormattedMessage id='form.label.lastname'/></label>
                <input type="text" id="lastname" className="FormField__Input" placeholder="Introducir apellido1" name="lastname" defaultValue={this.state.lastname} onChange={this.handleChange} required />
              </div>
              
              <div className="FormField">
                <label className="FormField__Label" htmlFor="lastname2"><FormattedMessage id='form.label.lastname2'/></label>
                <input type="text" id="lastname2" className="FormField__Input" placeholder="Introducir apellido2" name="lastname2" defaultValue={this.state.address} onChange={this.handleChange} required />
              </div>
              <div className="FormField">
                <label className="FormField__Label" htmlFor="email"><FormattedMessage id='form.label.email'/></label>
                <input type="email" id="email" className="FormField__Input" placeholder="Introducir Correo Electónico" name="email" defaultValue={this.state.email} onChange={this.handleChange} required />
              </div>
              <div className="FormField">
                <label className="FormField__Label" htmlFor="genre"><FormattedMessage id='form.label.genre'/></label>
                <input type="text" id="genre" className="FormField__Input" placeholder="Introducir el género" name="genre" defaultValue={this.state.genre} onChange={this.handleChange} required />
              </div>
              <div className="FormField">
                <label className="FormField__Label" htmlFor="address"><FormattedMessage id='form.label.address'/></label>
                <input type="text" id="address" className="FormField__Input" placeholder="Introducir dirección" name="address" defaultValue={this.state.address} onChange={this.handleChange} required />
              </div>
            <form ref={node => this.form = node} onSubmit={(e) => this.handleSubmit(e)} className="FormFields">
              <div className="FormField">
                  <button type ="submit" className="FormField__Button mr-20"><FormattedMessage id='form.button.register'/></button> <Link to="/" className="FormField__Link"><FormattedMessage id='form.link.haveAccount'/></Link>
              </div>
            </form>
          </div>
           );
    }
}
export default InfoUserForm;