import React, { Component } from 'react';
import {register}  from '../actions';
import {ToastsContainer, ToastsStore} from 'react-toasts';
import {NavLink} from 'react-router-dom';
import logo from '../../../images/cat2.gif';
import InfoUserForm from '../components/InfoUserForm';
import InfoShelterForm from '../components/InfoShelterForm';
import {FormattedMessage} from 'react-intl'
import {getPreferences, getUserEnums} from '../actions/actions';
import {connect} from 'react-redux';
import { Link } from 'react-router-dom';


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
        this.handleSubmitUser = this.handleSubmitUser.bind(this);
        this.handleSubmitShelter = this.handleSubmitShelter.bind(this);
        this.handleCheck = this.handleCheck.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

    }

    componentDidMount(){
      if(sessionStorage.getItem('serviceToken')!=null){
       this.props.history.replace("/List")
     }
     this.props.getUserEnums()

    }



    componentDidUpdate(prevProps, prevState) {
      console.log("Nuevos prosp")
      console.log(this.props)
      if(prevProps.enumValues!==this.props.enumValues){
        this.setState({genre: this.props.enumValues.genres[0],
                      type:this.props.enumValues.types[0] });
        
      }

    }

    componentWillReceiveProps(newProps){
      console.log("props recibidas:")
      console.log(newProps)
    }

    handleChange(e) {
        
        let target = e.target;
        console.log(target.value)
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

    handleSubmit(e){
      if(this.state.isShelter){
        this.handleSubmitShelter(e)
      }else{
        this.handleSubmitUser(e)
      }
    }

    handleSubmitUser(e){
      e.preventDefault();
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

      register(signUpUser)
          .then(response => {
            
            this.props.history.replace("/addLocation")
            sessionStorage.setItem('serviceToken', response.token);
            sessionStorage.setItem('userId', response.id);
            ToastsStore.success("Registrado Correctamente");

        }).catch(error => {
          ToastsStore.error(error.globalError);
        });
    }

    handleSubmitShelter(e) {
      e.preventDefault();
        const signUpShelter = {

          username: this.state.userName,
          password: this.state.password,
          shelterDTO : {
            type: this.state.type,
            name: this.state.name,
            phoneNumber: this.state.phoneNumber,
            email: this.state.email,
            address: this.state.address,
            description: this.state.description
          }

        }
          register(signUpShelter)
          .then(response => { 
            sessionStorage.setItem('serviceToken', response.token);
            sessionStorage.setItem('userId', response.id);
            ToastsStore.success("Registrado Correctamente");
            this.props.getPreferences(response.token);
            this.props.history.replace("/addLocation")

        }).catch(error => {
          ToastsStore.error(error.globalError);
        }); 
    };
    
    renderInfoForm(){
      if(this.state.isShelter){
        return <InfoShelterForm userName = {this.state.userName} password = {this.state.password} handleChange = {this.handleChange} ></InfoShelterForm>
      }
      else{
        return <InfoUserForm userName = {this.state.userName} password = {this.state.password}  handleChange = {this.handleChange} ></InfoUserForm>
      }
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
                <NavLink to="/"  className="PageSwitcher__Item"><FormattedMessage id='form.button.access'/></NavLink>
                <NavLink exact to="/signUp" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item"><FormattedMessage id='form.button.register'/></NavLink>
              </div>
        <div className="FormTitle">
                  <NavLink to="/"  className="FormTitle__Link"><FormattedMessage id='form.button.access'/></NavLink> o <NavLink exact to="/signUp" activeClassName="FormTitle__Link--Active" className="FormTitle__Link"><FormattedMessage id='form.button.register'/></NavLink>
              </div>  
              <form ref={node => this.form = node} onSubmit={(e) => this.handleSubmit(e)} className="FormFields">        
               <div className="FormField">
                <label className="FormField__Label" htmlFor="userName"><FormattedMessage id='form.label.user'/></label>
                <input type="text" id="userName" className="FormField__Input" placeholder="Introducir usuario" name="userName" defaultValue={this.state.userName} onChange={this.handleChange} required />
              </div>
              <div className="FormField">
                <label className="FormField__Label" htmlFor="password"><FormattedMessage id='form.label.password'/></label>
                <input type="password" id="password" className="FormField__Input" placeholder="Introducir Contraseña" name="password" defaultValue={this.state.password} onChange={this.handleChange} required />
              </div>
              
              <div className="FormField">
                <label className="FormField__Label" htmlFor="password"><FormattedMessage id='form.label.shelter'/></label>
                <input type="checkbox" id="isShelter" defaultChecked={this.state.isShelter}  name="isShelter"  onChange={this.handleCheck}/>
              </div>
              <div className="infoSectionDecoration">
              <div className="UserInfoSection">
                
                {this.renderInfoForm()}
                </div>
              </div>
              <div className="FormField">
                  <button type ="submit" className="FormField__Button mr-20"><FormattedMessage id='form.button.register'/></button> <Link to="/" className="FormField__Link"><FormattedMessage id='form.link.haveAccount'/></Link>
              </div>
              </form>
          </div>
          </div>
          </div> );
    }
}

const mapStateToProps = state => (()=>console.log(state),{
  enumValues : state.user.userSelectorValues
})

export default connect(mapStateToProps, {getPreferences, getUserEnums})(SignUpForm);