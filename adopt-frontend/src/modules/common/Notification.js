import React,{ Component } from "react";
import {getNotifications, deleteNotification} from './actions';
import {FormattedMessage} from 'react-intl';
import {Button} from 'reactstrap';
import Moment from 'moment';

import './styles/common.css'

class Notification extends Component{
constructor(props){
    super(props)

    this.state = {
        notifications : []
    }

    this.getNotificationsFromUser = this.getNotificationsFromUser.bind(this);
    this.renderNotification = this.renderNotification.bind(this);
    this.onClickAdoptionInfo = this.onClickAdoptionInfo.bind(this);
    this.onClickLostInfo = this.onClickLostInfo.bind(this);
    this.delete = this.delete.bind(this);
    this.renderText = this.renderText.bind(this);
}

componentDidMount(){
    this.getNotificationsFromUser();
}

onClickLostInfo (animalId){
    this.props.lostAnimalInfo(animalId)
}

onClickAdoptionInfo (animalId){
    this.props.adoptionAnimalInfo(animalId)
}

getNotificationsFromUser(){

    getNotifications(sessionStorage.getItem('serviceToken')).then(response =>{
        this.setState ({
            notifications : response
        },()=> console.log(this.state))
    })
}

delete(notificationId){
    console.log("borrado")
    const params = {
        userToken: sessionStorage.getItem('serviceToken'),
        notificationId : notificationId
    }

    deleteNotification(params).then(response =>{
        this.setState(
            {
                notifications : response
            }
        )
    })
}

renderNotification(notification){
    if (notification.type === "LOST_ADDED"){
        return <tr key = {notification.id}><td className ="notificationCell"><FormattedMessage id="notification.text.lost"/></td><td className ="notificationCell">{Moment(notification.date).format("DD-MM-YY")}</td><td className ="notificationCell"><Button color="primary" onClick={()=>this.onClickLostInfo(notification.animal.id_animal)}><FormattedMessage id="form.button.animal"/></Button></td><td className ="notificationCell"><Button  onClick = {()=>this.delete(notification.id) } color="danger"><FormattedMessage id="form.button.notificationDelete"/></Button></td></tr>
    }else{
        return <tr key = {notification.id}><td className ="notificationCell"><FormattedMessage id="notification.text.adoption"/>:</td><td className ="notificationCell">{Moment(notification.date).format("DD-MM-YY")}</td><td className ="notificationCell"><Button color="primary" onClick ={()=>this.onClickAdoptionInfo(notification.animal.id_animal)}><FormattedMessage id="form.button.animal"/></Button></td><td className ="notificationCell"><Button  onClick = {()=>this.delete(notification.id) } color="danger"><FormattedMessage id="form.button.notificationDelete"/></Button></td></tr>
    }
}

renderText(notifications){
    console.log(notifications)
    if(notifications.length === 0){
        return <h3>Sin Notificaciones</h3>
    }
}


    render(){
        return(
           <div className = "notificationSection">
               
               {this.renderText(this.state.notifications)}
               <table>
                   <tbody>
                        
                       {this.state.notifications.map (notification=>(
                           this.renderNotification(notification)
                       ))}
                   </tbody>
                </table>
           </div>
        )
    }
}

export default Notification;