import React,{ Component } from "react";
import Moment from 'moment';
import { FormattedMessage } from "react-intl";

import './styles/styles.css'


class LostAnimalDetail extends Component{
    render(){
        return(
            <div className = "lostAnimalDetailContainer">
                <table>
                    <tbody>
                        <tr><td className = "label"><FormattedMessage id = "form.label.name"></FormattedMessage> : </td><td className = "value">{this.props.animal.name}</td><td className = "label"><FormattedMessage id = "form.label.size"></FormattedMessage> : </td><td className = "value">{this.props.animal.size}</td></tr>
                        <tr><td className = "label"><FormattedMessage id = "form.label.breed"></FormattedMessage> : </td><td className = "value">{this.props.animal.breed}</td><td className = "label"><FormattedMessage id = "form.label.description"></FormattedMessage> : </td><td className = "value">{this.props.animal.description}</td></tr>
                        <tr><td className = "label"><FormattedMessage id = "form.label.genre"></FormattedMessage> : </td><td className = "value">{this.props.animal.genre}</td><td className = "label"><FormattedMessage id = "form.label.date"></FormattedMessage> : </td><td className = "value">{Moment(this.props.animal.date).format("DD-MM-YY")}</td></tr>
                        <tr><td className = "label"><FormattedMessage id = "form.label.color"></FormattedMessage> : </td><td className = "value">{this.props.animal.color}</td><td className = "label"><FormattedMessage id = "form.label.comment"></FormattedMessage> : </td><td className = "value">{this.props.animal.comment}</td></tr>
                    </tbody>
                </table>
            </div>
        )
    }
}

export default LostAnimalDetail;