import React,{ Component } from "react";
import TopMenu from '../app/components/TopMenu';
import {getUserChats} from './actions';
import Moment from 'moment';
import {Button} from 'reactstrap';

class ActiveChatsPage extends Component{
    constructor(){
        super()
        this.state = {
            chats : []
        }
        this.renderChats = this.renderChats.bind(this)
    }

    componentDidMount()
    {
        getUserChats(sessionStorage.getItem('serviceToken')).then(response => {
            this.setState({
                chats : response
            })
        })
    }


    onButtonClick(username)
    {
        this.props.history.replace("/chat/"+username)
    }

    renderChats(){
        if(this.state.chats.length > 0){
            console.log(this.state)
            return(
            <table className="chatTable">
                <tbody>
                <tr className="chatTableRow" ><td className="chatTableCell"><h5>Usuario</h5></td><td className="chatTableCell"></td></tr>
                {this.state.chats.map((chat)=>{
                     return<tr className="chatTableRow" key = {chat.username}><td className="chatTableCell"><a>{chat.username}</a></td><td className="chatTableCell"><Button onClick={()=>this.onButtonClick(chat.username)}>Entrar</Button></td></tr>
                    })}
                </tbody>
            </table>)
        }else{
            return <h4>Sin chats activos</h4>
        }
    }

    render(){
        console.log(this.state.chats)
        return(
            <div className="activeChatsSection">
            <TopMenu/>
            <h3>Chats Activos</h3>
                {this.renderChats()}

            </div>
        )
    }
}

export default ActiveChatsPage;