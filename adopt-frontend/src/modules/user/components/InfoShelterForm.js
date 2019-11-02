import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import {FormattedMessage} from 'react-intl';
import {connect} from 'react-redux';


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
     

    }


    handleChange(e) {
     
      this.props.handleChange(e);
    }






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
              <select id="type" className="FormField__Input" name="type" defaultValue={this.state.type} onChange={this.handleChange} required  >
              {this.props.enumValues.types.map(type => {
                            return <option key = {type}>{type}</option>
                        })}  
              </select>
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
          </div>
           );
    }
}

const mapStateToProps = state =>({
  enumValues : state.user.userSelectorValues
})
export default connect(mapStateToProps,{}) (InfoShelterForm);