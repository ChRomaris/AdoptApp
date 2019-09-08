import React,{ Component } from "react";
import {
    MDBNavbar, MDBNavbarBrand, MDBNavbarNav, MDBNavItem, MDBNavLink, MDBNavbarToggler, MDBCollapse, MDBFormInline,
    MDBDropdown, MDBDropdownToggle, MDBDropdownMenu, MDBDropdownItem
    } from "mdbreact";
    
import { userService } from '../../../backend/userService'

class UserTopMenu extends Component{
    state = {
        isOpen: false,
        isAdmin : ''
      };
      
      componentDidMount(){
        this.setState={
          isOpen :false,
        }
      }
      
      toggleCollapse = () => {
        this.setState({ isOpen: !this.state.isOpen });
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
                  <MDBDropdown>
                      <MDBDropdownToggle nav caret>
                        <span className="mr-2">Animales en adopción</span>
                      </MDBDropdownToggle>
                      <MDBDropdownMenu>
                      <MDBDropdownItem href="#/List">Lista animales</MDBDropdownItem> 
                      <MDBDropdownItem href="#/adoptionMap">Mapa animales</MDBDropdownItem> 
                      </MDBDropdownMenu>
                    </MDBDropdown>
                  <MDBNavItem>
                    <MDBDropdown>
                      <MDBDropdownToggle nav caret>
                        <span className="mr-2">Perfil</span>
                      </MDBDropdownToggle>
                      <MDBDropdownMenu>
                        <MDBDropdownItem href="#/user/update">Información personal</MDBDropdownItem>
                        <MDBDropdownItem  href="/" onClick={this.logout} >Cerrar Sesión</MDBDropdownItem>
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

export default UserTopMenu