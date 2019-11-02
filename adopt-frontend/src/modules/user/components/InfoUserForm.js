import React, { Component } from 'react';

import {FormattedMessage} from 'react-intl';
import {connect} from 'react-redux';


class InfoUserForm extends Component {
    constructor() {
        super();

        this.state = {
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


    handleChange(e) {
     
      this.props.handleChange(e)
    }


    handleSubmit(e) {
        e.preventDefault();
        this.props.handleSubmitUser();
    
    };



    render() {
      console.log("render")
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
              <select id="genre" className="FormField__Input" name="genre" defaultValue={this.state.genre} onChange={this.handleChange} required >
              {this.props.enumValues.genres.map(genre => {
                            return <option key = {genre}>{genre}</option>
                        })}  
              </select>
              </div> 
              <div className="FormField"></div>
              <div className="FormField">
                <label className="FormField__Label" htmlFor="address"><FormattedMessage id='form.label.address'/></label>
                <input type="text" id="address" className="FormField__Input" placeholder="Introducir dirección" name="address" defaultValue={this.state.address} onChange={this.handleChange} required />
              </div>
            

          </div>
           );
    }
}
const mapStateToProps = state => (console.log(state),{
  enumValues : state.user.userSelectorValues
})

export default connect(mapStateToProps,{})(InfoUserForm);