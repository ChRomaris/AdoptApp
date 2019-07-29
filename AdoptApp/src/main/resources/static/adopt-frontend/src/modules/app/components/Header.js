import React, {Component} from 'react';

import { Link } from 'react-router-dom';
import { MDBNavbar, MDBNavbarBrand, NavbarNav, MDBNavItem,  MDBNavbarToggler, MDBCollapse, MDBContainer } from 'mdbreact';

import "@fortawesome/fontawesome-free/css/all.min.css";
import "bootstrap-css-only/css/bootstrap.min.css";
import "mdbreact/dist/css/mdb.css";
import { userService } from '../../../backend/userService';
import { findShelterByUser } from "../../shelter/actions";

class Header extends Component{
    state = {
        collapseID: '',
        shelterName: ''
      }
      
      toggleCollapse = collapseID => () => {
        this.setState(prevState => ({ collapseID: (prevState.collapseID !== collapseID ? collapseID : '') }));
      }

      componentDidMount(){
        findShelterByUser(sessionStorage.getItem('serviceToken')).then(response=>
          {
            this.setState ={
              shelterName : response.name
            }
          }).catch(error=>{
            
          })
      }


      logout(){
        userService.logout();
      }

    render(){
        return(
            
            <MDBContainer>
            <MDBNavbar color="light-blue lighten-4" style={{ marginTop: '20px' , width: '100%' }} light>
              <MDBContainer>
                <MDBNavbarBrand>
                  Navbar
                </MDBNavbarBrand>
                <MDBNavbarToggler onClick={this.toggleCollapse('navbarCollapse1')} />
                <MDBCollapse id="navbarCollapse1" isOpen={this.state.collapseID} navbar>
                  <NavbarNav left>
                    <MDBNavItem active>
                      <Link to="/shelter/add">Crear Asociación</Link>
                    </MDBNavItem>
                    <MDBNavItem>
                      <Link to="/">  Iniciar Sesión</Link>
                    </MDBNavItem>
                    <MDBNavItem>
                      <Link to="/animal/add"> Añadir animal</Link>
                    </MDBNavItem>
                    <MDBNavItem>
                      <Link to="/List"> Animales en adopción</Link>
                    </MDBNavItem>
                    <MDBNavItem>
                      <Link to="/user/Update"> Perfil</Link>
                    </MDBNavItem>
                    <MDBNavItem>
                      <a href='/' onClick={this.logout}>  Cerrar Sesión</a>
                    </MDBNavItem>
                  </NavbarNav>
                </MDBCollapse>
              </MDBContainer>
            </MDBNavbar>
           
          </MDBContainer>
        )
    }
}

export default Header;