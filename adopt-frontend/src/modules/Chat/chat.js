import React, { Component } from "react";
import SockJsClient from "react-stomp";
import { TalkBox } from "react-talk";
import { startChat, getCurrentUserInfo } from './actions'

import './styles/styles.css'

class Chat extends Component {
  constructor(props) {
    super(props);
    this.state = {
      chatId: '',
      messages: [],
      currentUser:'',
      toUser:''
    };

    this.getCurrentUserInfo = this.getCurrentUserInfo.bind(this);
    this.returnSocket = this.returnSocket.bind(this);
    this.initializeChat = this.initializeChat.bind(this);
    this.renderElements = this.renderElements.bind(this);
  }

  getCurrentUserInfo(){
    const ProfileDTO = {
      token: sessionStorage.getItem('serviceToken')
    }
    getCurrentUserInfo(ProfileDTO).then(response=>{
      this.setState({
        currentUser : response.username
      }
      )
    })
  }



  onMessageReceive = (message) => {
    console.log(message)
    const text = { authorId: message.authorId, author: message.username, message: message.text}
    this.setState(prevState => ({
      messages: [...prevState.messages, text]
    }))
  }

  sendMessage = (text, self) => {
    console.log("send")
    const messageDTO = {
      userToken: sessionStorage.getItem('serviceToken'),
      chatId: this.state.chatId,
      text: self.message,
      username: self.author,
      authorId: 1
    }
    console.log(messageDTO)
    try {
      this.clientRef.sendMessage("/app/all", JSON.stringify(messageDTO)).then(response => {

      });
      return true;
    } catch (e) {
      return false;
    }
  }

  componentDidMount() {
   this.getCurrentUserInfo();
   this.initializeChat();
  }


  componentWillReceiveProps(newProps){
    if(newProps.username){
      console.log("Se ha recibido el username:" + newProps.username)
      this.initializeChat()
    }
  }

  initializeChat(){
    
    if(this.props.username!==""){
      console.log("entra")
      const chatDTO = {
        userToken: sessionStorage.getItem('serviceToken'),
        username: this.props.username
      }
      startChat(chatDTO).then(response => {
        
        if(response.messages !==null){
    
        const texts = response.messages.map((message) => {
          
          return { authorId: message.messageSender.id, author: message.messageSender.username, message: message.text }
        })
      this.setState({
        messages: texts
      })
      }

        this.setState({

          chatId: response.id,
        })
      })

    }
  }

  returnSocket(){
    if(this.props.username!=="" && this.state.currentUser !== '' && this.state.chatId !== ''){
      const wsSourceUrl = window.location.protocol + "//localhost:8080/handler?username="+ this.state.chatId
     
      return(
        <SockJsClient url={wsSourceUrl} topics={["/user/topic/all"]}
        onMessage={this.onMessageReceive} ref={(client) => { this.clientRef = client }}
        onConnect={() => { this.setState({ clientConnected: true }) }}
        onDisconnect={() => { this.setState({ clientConnected: false }) }}
        debug={false} />)
    }
  }

  returnBox(){
    if(this.props.username!=="" && this.state.currentUser !== '' ){
      return(
          <TalkBox  topic={this.props.username} currentUserId={1}
          currentUser={this.state.currentUser} messages={this.state.messages}
          onSendMessage={this.sendMessage} connected={this.state.clientConnected} />
      )
    }
  }
  
  renderElements(){
    if(this.props.username != 'undefined'){
      return (
        <div className="chatSection">
          
          {this.returnBox()}
          {this.returnSocket()}
        </div>)
    }else{
      return <h1>Usuario Inválido</h1>
    }
  }


  render() {

    return (
      <div className="chatSection">
        {this.renderElements()}
      </div>
    );
  }
}
export default Chat;