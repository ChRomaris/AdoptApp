import React,{ Component } from "react";
import TopMenu from '../app/components/TopMenu';
import Chat from './chat'

class ChatPage extends Component{
    render(){
        return(
            <div>
                <TopMenu/>
                <Chat username = {this.props.match.params.username}/>
            </div>
            
        )
    }
}

export default ChatPage;