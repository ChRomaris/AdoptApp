import React,{ Component } from "react";
import Moment from 'moment';
import { FormattedMessage } from "react-intl";

import './styles/styles.css'

class AdoptionAnimalDetail extends Component{
    constructor(){
        super()
        this.state = {
            breed : ''
        }

        this.renderTrained = this.renderTrained.bind(this);

       
    }

    componentWillReceiveProps(newProps){
        console.log(newProps)
        if (newProps.animal){
            this.setState ({
                breed : newProps.animal.breed.name
            })
        }
    }

    renderTrained(trained){
        if (trained){
            return "Si"
        }else{
            return "No"
        }
    }
    render(){
        return(
            <div className = "adoptionAnimalDetailContainer">
            <table>
                <tbody>
                    <tr><td className = "label"><FormattedMessage id = "form.label.name"></FormattedMessage> : </td><td className = "value">{this.props.animal.name}</td><td className = "label"><FormattedMessage id = "form.label.size"></FormattedMessage> : </td><td className = "value">{this.props.animal.size}</td></tr>
                    <tr><td className = "label"><FormattedMessage id = "form.label.breed"></FormattedMessage> : </td><td className = "value">{this.state.breed}</td><td className = "label"><FormattedMessage id = "form.label.description"></FormattedMessage> : </td><td className = "value">{this.props.animal.description}</td></tr>
                    <tr><td className = "label"><FormattedMessage id = "form.label.genre"></FormattedMessage> : </td><td className = "value">{this.props.animal.genre}</td><td className = "label"><FormattedMessage id = "form.label.date"></FormattedMessage> : </td><td className = "value">{Moment(this.props.animal.date).format("DD-MM-YY")}</td></tr>
                    <tr><td className = "label"><FormattedMessage id = "form.label.color"></FormattedMessage> : </td><td className = "value">{this.props.animal.color}</td><td className = "label"><FormattedMessage id = "form.label.comment"></FormattedMessage> : </td><td className = "value">{this.props.animal.description}</td></tr>
                    <tr><td className = "label"><FormattedMessage id = "form.label.birthDate"></FormattedMessage> : </td><td className = "value">{Moment(this.props.animal.birthDate).format("DD-MM-YY")}</td><td className = "label"><FormattedMessage id = "form.label.healthComment"></FormattedMessage> : </td><td className = "value">{this.props.animal.health_comment}</td></tr>
                    <tr><td className = "label"><FormattedMessage id = "form.label.trained"></FormattedMessage> : </td><td className = "value">{this.renderTrained(this.props.animal.trained)}</td><td className = "label"><FormattedMessage id = "form.label.adoptionTime"></FormattedMessage> : </td><td className = "value">{Moment(this.props.animal.adoption_time).fromNow(true)}</td></tr>
                </tbody>
            </table>
        </div>
        )
    }
}

export default AdoptionAnimalDetail;