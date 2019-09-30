import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import {FormattedMessage} from 'react-intl'


class InfoShelterForm extends Component {
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
        this.props.handleSubmitShelter(this.state.name, this.state.type, this.state.address, this.state.email, this.state.phoneNumber, this.state.description);
    
    };



    render() {
      
        return (
          
        <div className="FormCenter">
              <div className="UserInfoSectionTittle">
                <h4><FormattedMessage id='form.tittle.shelterInfo'/></h4>
             </div>
             <div className="FormField">
                <label className="FormField__Label" htmlFor="name"><FormattedMessage id='form.label.name'/></label>
                <input type="text" id="name" className="FormField__Input" placeholder="Introducir nombre Asociación" name="name" defaultValue={this.state.name} onChange={this.handleChange} required />
              </div>

              <div className="FormField">
                <label className="FormField__Label" htmlFor="type"><FormattedMessage id='form.label.type'/></label>
                <input type="text" id="type" className="FormField__Input" placeholder="Introducir tipo" name="type" defaultValue={this.state.type} onChange={this.handleChange} required />
              </div>
              
              <div className="FormField">
                <label className="FormField__Label" htmlFor="address"><FormattedMessage id='form.label.address'/></label>
                <input type="text" id="address" className="FormField__Input" placeholder="Introducir Dirección" name="address" defaultValue={this.state.address} onChange={this.handleChange} required />
              </div>
              <div className="FormField">
                <label className="FormField__Label" htmlFor="email"><FormattedMessage id='form.label.email'/></label>
                <input type="email" id="email" className="FormField__Input" placeholder="Introducir Correo Electónico" name="email" defaultValue={this.state.email} onChange={this.handleChange} required />
              </div>
              <div className="FormField">
                <label className="FormField__Label" htmlFor="phoneNumber"><FormattedMessage id='form.label.phoneNumber'/></label>
                <input type="number" id="phoneNumber" className="FormField__Input" placeholder="Introducir numero de teléfono" name="phoneNumber" defaultValue={this.state.phoneNumber} onChange={this.handleChange} required />
              </div>
              <div className="FormField">
                <label className="FormField__Label" htmlFor="description"><FormattedMessage id='form.label.description'/></label>
                <input type="text" id="description" className="FormField__Input" placeholder="Introducir descripción" name="description" defaultValue={this.state.description} onChange={this.handleChange} required />
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
export default InfoShelterForm;