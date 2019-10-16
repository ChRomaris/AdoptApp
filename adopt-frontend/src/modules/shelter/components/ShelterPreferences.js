import React,{ Component } from "react";
import { FormattedMessage}  from 'react-intl';
import './styles/shelter.css';
import TopMenu from '../../app/components/TopMenu';
import {getShelterPreferences, setShelterPreferences} from '../actions';
import { Button, Form, FormGroup, Label, Input} from 'reactstrap';


class ShelterPreferences extends Component{
    constructor(){
        super()
        this.state = {
            maxAdoptionDistance: '',
            maxLostDistance: '',
            preferencesId: ''
        }

        this.handleChange = this.handleChange.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this)
    }

 componentDidMount(){
    getShelterPreferences(sessionStorage.getItem('serviceToken')).then(response => {
        console.log(response)
        this.setState({
            maxAdoptionDistance: response.maxAdoptionDistance,
            maxLostDistance: response.maxLostDistance,
            preferencesId : response.preferencesId
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
        maxAdoptionDistance: this.state.maxAdoptionDistance,
        maxLostDistance: this.state.maxLostDistance,
        userToken : sessionStorage.getItem('serviceToken')
    }
    setShelterPreferences(params);
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
                    <Button><FormattedMessage id='form.button.edit'/></Button>
            </Form>
             </div>
            )}
        
    
}



export default ShelterPreferences