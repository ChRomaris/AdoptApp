import React,{ Component } from "react";
import { FormattedMessage}  from 'react-intl';
import './styles/user.css';
import TopMenu from '../../app/components/TopMenu';
import {connect} from 'react-redux';
import {getPreferences, setPreferences} from '../actions/actions';
import {getTypes} from '../../animal/actions';
import {Button, Form, FormGroup, Label, Input} from 'reactstrap';
import Switch from 'react-switch';


class UserPreferences extends Component{
    constructor(){
        super()
        this.state = {
            breeds:[],
            genres:[],
            colors:[],
            sizes:[],
            breed : null,
            genre : null,
            color : null,
            size : null,
            maxAdoptionDistance: '',
            maxLostDistance: '',
            preferencesId: '',
            summary:true

        }

        this.fillTypes = this.fillTypes.bind(this)
        this.handleChange = this.handleChange.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this)
        this.handleCheck = this.handleCheck.bind(this)
     
    }

 componentDidMount(){
     console.log("montadas Preferencias con props: ")
     console.log(this.props);
     if(!this.props.maxLostDistance){
         console.log("No hay props")
         this.props.getPreferences(sessionStorage.getItem('serviceToken'))
     }

     this.setState({
        breed : this.props.breed,
        genre : this.props.genre,
        color : this.props.color,
        size : this.props.size,
        summary : this.props.summary,
        maxAdoptionDistance: this.props.maxAdoptionDistance,
        maxLostDistance: this.props.maxLostDistance,
        preferencesId : this.props.preferencesId
    })

     this.fillTypes();
 }
 
 componentWillReceiveProps(newProps){
    this.setState({
        breed : newProps.breed,
        genre : newProps.genre,
        color : newProps.color,
        size : newProps.size,
        summary: newProps.summary,
        maxAdoptionDistance: newProps.maxAdoptionDistance,
        maxLostDistance: newProps.maxLostDistance,
        preferencesId : newProps.preferencesId
    })
 }



 fillTypes(){
    getTypes().then(response=>{

        this.setState({
            breeds : response.breeds,
            genres : response.genres,
            colors : response.colors,
            sizes : response.sizes
        })
    })
}

handleChange (event){
    console.log()
    let target = event.target
    let value = target.value
    console.log(value);
    this.setState ({
        [target.name] : value,
    })
    
}



handleSubmit(event){
    event.preventDefault();
    const params = {
        preferencesId : this.state.preferencesId,
        breed : this.state.breed,
        size: this.state.size,
        genre: this.state.genre,
        color : this.state.color,
        summary:this.state.summary,
        maxAdoptionDistance: this.state.maxAdoptionDistance,
        maxLostDistance: this.state.maxLostDistance,
        userToken : sessionStorage.getItem('serviceToken')
    }
    console.log("set")
    console.log(params)
    this.props.setPreferences(params);

}
handleCheck(checked){
    console.log(checked)
    this.setState({
        summary:checked
    })
}




    render(){
        return(
            <div>
                <TopMenu></TopMenu>

                <Form onSubmit={this.handleSubmit} className = "PreferencesContainer">
                <div className ="distancePreferences">
                <p><FormattedMessage id='form.info.distancePreferences'/></p>
                <FormGroup>
                    <Label for="maxAdoptionDistance" className ="formLabel"><FormattedMessage id='form.label.adoptionDistance'/></Label>
                    <Input type="number" name="maxAdoptionDistance" id="maxAdoptionDistance"  value={this.state.maxAdoptionDistance || ''} onChange={this.handleChange}   ></Input>   
                    
                </FormGroup>
                <FormGroup>
                    <Label for="lostDistance" className ="formLabel"><FormattedMessage id='form.label.lostDistance'/></Label>
                    <Input type="number" name="maxLostDistance" id="lostDistance"  value={this.state.maxLostDistance || ''} onChange={this.handleChange}   ></Input>   
                    
                </FormGroup>
                </div>
                <div className = "animalPreferences">
                <p><FormattedMessage id='form.info.animalPreferences'/></p>
                <FormGroup>
                    <Label for="exampleBreed"><FormattedMessage id='form.label.breed'/></Label>
                    <Input type="select" name="breed" id="exampleBreed"  value={this.state.breed || '' } onChange={this.handleChange}>
                        <option key = "empty">Seleccionar raza</option>
                        {this.state.breeds.map(breed => {
                            return <option key = {breed}>{breed}</option>
                        })}
                    </Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleEmail"><FormattedMessage id='form.label.genre'/></Label>
                    <Input type="select" name="genre" id="exampleGenre"  value={this.state.genre || ''} onChange={this.handleChange}>
                    <option key = "empty">Seleccionar genero</option>
                    {this.state.genres.map(genre => {
                            return <option key = {genre}>{genre}</option>
                        })}   
                    </Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="size"><FormattedMessage id='form.label.size'/></Label>
                    <Input type="select" name="size" id="size"  value={this.state.size || '' } onChange={this.handleChange}>
                    <option key = "empty">Seleccionar tamaño</option>
                    {this.state.sizes.map(size => {
                            return <option key = {size}>{size}</option>
                        })}
                    </Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="color"><FormattedMessage id='form.label.color'/></Label>
                    <Input type="select" name="color" id="color"  value={this.state.color || ''} onChange={this.handleChange}>
                    <option >Seleccionar color</option>
                    {this.state.colors.map(color => {
                            return <option key = {color}>{color}</option>
                        })}
                    </Input>     
                </FormGroup>

                </div>
                <div className ="checkSection">

                <FormGroup>
                    <Label for="lostDistance" className ="formLabel"><FormattedMessage id='form.info.summary'/></Label>
                    <Switch name ="summary" onChange={this.handleCheck} checked={this.state.summary} className="react-switch"/>   
                </FormGroup>
 
                </div>

                    <Button><FormattedMessage id='form.button.edit'/></Button>
            </Form>
             </div>
            )}
        
    
}

const mapStateToProps = state => ({
    maxLostDistance: state.user.profilePreferences.maxLostDistance,
    maxAdoptionDistance : state.user.profilePreferences.maxAdoptionDistance,
    breed: state.user.profilePreferences.breed,
    color: state.user.profilePreferences.color,
    size: state.user.profilePreferences.size,
    genre: state.user.profilePreferences.genre,
    preferencesId :state.user.profilePreferences.preferencesId,
    summary :state.user.profilePreferences.summary

})


export default connect(mapStateToProps,{getPreferences, setPreferences})(UserPreferences)