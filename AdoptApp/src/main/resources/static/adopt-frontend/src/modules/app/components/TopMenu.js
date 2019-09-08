import React, { Component } from "react";
import UserTopMenu from '../../user/components/UserTopMenu';
import ShelterTopMenu from '../../shelter/components/ShelterTopMenu';
import {getUserInfo} from '../../user/actions';


class TopMenu extends Component {
  constructor(){
    super();

    this.state = {
      isShelter: false

    }

    this.showMenu = this.showMenu.bind(this)
  }

componentDidMount(){
  const getInfoParams = {
    token : sessionStorage.getItem('serviceToken')
  }

  getUserInfo(getInfoParams).then( response => {
    if (response.shelterDTO != null){
      this.setState ({
        isShelter : true
      })
    }
  })
}



showMenu () {
  if(this.state.isShelter){
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