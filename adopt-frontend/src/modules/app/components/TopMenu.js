import React, { Component } from "react";
import UserTopMenu from '../../user/components/UserTopMenu';
import ShelterTopMenu from '../../shelter/components/ShelterTopMenu';
import AnonimousTopMenu from '../../user/components/AnonimousTopMenu';
import {getUserInfo} from '../../../backend/userService';


class TopMenu extends Component {
  constructor(){
    super();

    this.state = {
      isShelter:false ,
      isAnonimous : false

    }

    this.showMenu = this.showMenu.bind(this)
  }

componentDidMount(){
  const getInfoParams = {
    token : sessionStorage.getItem('serviceToken')
  }

  if(getInfoParams.token !== null){
    getUserInfo(getInfoParams).then( response => {
      if (response.shelterDTO != null){
        this.setState ({
          isShelter : true
        })
      }
    })
  }else{
    this.setState({
      isAnonimous : true
    })
  }
  
}



showMenu () {
  if(this.state.isAnonimous){
    return <AnonimousTopMenu></AnonimousTopMenu>
  }
  else if(this.state.isShelter){
    return <ShelterTopMenu></ShelterTopMenu>
  }else{
    return <UserTopMenu></UserTopMenu>
  }
}

render() {
  return (
      this.showMenu()  
    );
  }
}

export default TopMenu;