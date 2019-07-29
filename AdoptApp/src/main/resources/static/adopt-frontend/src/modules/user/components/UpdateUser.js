import {registerUpdateUser} from '../actions'
import React, {Component} from 'react';
import {ToastsContainer, ToastsStore} from 'react-toasts';
import {SideMenu} from '../../app/'

class UpdateUser extends Component {

    constructor() {
        super();

        this.state = {
            id : sessionStorage.getItem('userId'),
            userName: '',
            email: '',
            password: '',
            name: '',
            hasAgreed: false
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(e){

    
       
      let target = e.target;
      let value = target.type === 'checkbox' ? target.checked : target.value;
      let name = target.name;
      let genre = target.genre;
      let description = target.description;
      let birthDate = target.birthDate;
      let healthComment = target.healthComment;
      let color = target.color;
      let size = target.size;
      let trained = target.trained;
      let state = target.state;
      let image = target.image;
      let imageDescription = target.imageDescription

      this.setState({
        [name]: value,
        [genre]: value,
        [description] : value,
        [birthDate] : value,
        [healthComment] : value,
        [color] : value,
        [size] : value,
        [trained] : value,
        [state] : value,
        [image] : value,
        [imageDescription]: value
      });
  }

    handleSubmit(event) {
        event.preventDefault();
        const updateUserParams = {
          id : this.state.id,
          name : this.state.name, 
          userName: this.state.userName,
          email: this.state.email,
          password: this.state.password,
          hasAgreed : this.state.hasAgreed
        };
        
        registerUpdateUser(updateUserParams)
          .then(response => { 
            ToastsStore.success("Registrado Correctamente");
        }).catch(error => {
          ToastsStore.error("Algo ha salido mal");
        });
    };

    render(){
        return (
          <div>
         < SideMenu></SideMenu>
          <div className="Simple_Form">
        <div className="FormCenter">
        <ToastsContainer store={ToastsStore}/>
        <div className="FormTitle">
                 INFORMACIÓN PERSONAL
          </div>
            <form ref={node => this.form = node} onSubmit={(e) => this.handleSubmit(e)} className="FormFields">
              <div className="FormField">
                <label className="FormField__Label" htmlFor="name">Nombre</label>
                <input type="text" id="name" className="FormField__Input" placeholder="Introducir nombre completo" name="name" defaultValue={this.state.name} onChange={this.handleChange} required />
              </div>
              <div className="FormField">
                <label className="FormField__Label" htmlFor="userName">Usuario</label>
                <input type="text" id="userName" className="FormField__Input" placeholder="Introducir usuario" name="userName" value={this.state.userName} onChange={this.handleChange} required />
              </div>
              <div className="FormField">
                <label className="FormField__Label" htmlFor="password">Contraseña</label>
                <input type="password" id="password" className="FormField__Input" placeholder="Introducir Contraseña" name="password" value={this.state.password} onChange={this.handleChange} required />
              </div>
              <div className="FormField">
                <label className="FormField__Label" htmlFor="email">Correo Electrónico</label>
                <input type="email" id="email" className="FormField__Input" placeholder="Introducir correo electónico" name="email" value={this.state.email} onChange={this.handleChange} required />
              </div>
              <div className="FormField">
                  <button type ="submit" className="FormField__Button mr-20">Actualizar Información</button>
              </div>
            </form>
          </div>
          </div>
          </div>
        )
    }
}

export default UpdateUser;