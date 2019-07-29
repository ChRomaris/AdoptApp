import React, { Component } from "react";
import {
MDBNavbar, MDBNavbarBrand, MDBNavbarNav, MDBNavItem, MDBNavLink, MDBNavbarToggler, MDBCollapse, MDBFormInline,
MDBDropdown, MDBDropdownToggle, MDBDropdownMenu, MDBDropdownItem
} from "mdbreact";

import { userService } from '../../../backend/userService';

class SideMenu extends Component {
state = {
  isOpen: false,
  isAdmin : ''
};

componentDidMount(){
  this.setState={
    isOpen :false,
    isAdmin: sessionStorage.getItem('isAdmin')
  }
}

toggleCollapse = () => {
  this.setState({ isOpen: !this.state.isOpen });
}


shelterMenuRender (){
  
  if(this.state.isAdmin){
    
    return ( 
      
      <MDBDropdownItem href="#/animal/add">Añadir animal</MDBDropdownItem>
    )
  }else{
    return (
      <MDBDropdownItem href="#/shelter/add">Nueva Asociación</MDBDropdownItem> 
    )
  }
}

logout(){
  userService.logout();
}

render() {
  return (
      <MDBNavbar className="bar" dark expand="md">
        <MDBNavbarBrand>
          <strong className="white-text">AdoptApp</strong>
        </MDBNavbarBrand>
        <MDBNavbarToggler onClick={this.toggleCollapse} />
        <MDBCollapse id="navbarCollapse3" isOpen={this.state.isOpen} navbar>
          <MDBNavbarNav left>
            <MDBNavItem active>
              <MDBNavLink to="/mainPage">Inicio</MDBNavLink>
            </MDBNavItem>
            <MDBNavItem>
              <MDBNavLink to="/List">Animales en adopción</MDBNavLink>
            </MDBNavItem>
            <MDBNavItem>
            <MDBDropdown>
                <MDBDropdownToggle nav caret>
                  <span className="mr-2">Espacio Asociación</span>
                </MDBDropdownToggle>
                <MDBDropdownMenu>
                  
                <MDBDropdownItem href="#/animal/add">Añadir animal</MDBDropdownItem>
                <MDBDropdownItem href="#/shelter/edit">Editar animal</MDBDropdownItem> 
                <MDBDropdownItem href="#/shelter/add">Nueva Asociación</MDBDropdownItem> 
                <MDBDropdownItem href="#/shelter">Listado animales</MDBDropdownItem> 
                </MDBDropdownMenu>
              </MDBDropdown>
            </MDBNavItem>
            <MDBNavItem>
              <MDBDropdown>
                <MDBDropdownToggle nav caret>
                  <span className="mr-2">Perfil</span>
                </MDBDropdownToggle>
                <MDBDropdownMenu>
                  <MDBDropdownItem href="#/user/update">Información personal</MDBDropdownItem>
                  <MDBDropdownItem  href="#" >Cerrar Sesión</MDBDropdownItem>
                </MDBDropdownMenu>
              </MDBDropdown>
            </MDBNavItem>
          </MDBNavbarNav>
          <MDBNavbarNav right>
            <MDBNavItem>
              <MDBFormInline waves>
                <div className="md-form my-0">
                  <input className="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" />
                </div>
              </MDBFormInline>
            </MDBNavItem>
          </MDBNavbarNav>
        </MDBCollapse>
      </MDBNavbar>
    );
  }
}

export default SideMenu;