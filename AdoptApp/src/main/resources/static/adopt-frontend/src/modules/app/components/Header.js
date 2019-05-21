import React, {Component} from 'react';

import { Link } from 'react-router-dom';
import { MDBNavbar, MDBNavbarBrand, NavbarNav, MDBNavItem, MDBNavbarToggler, MDBCollapse, MDBContainer } from 'mdbreact';

import "@fortawesome/fontawesome-free/css/all.min.css";
import "bootstrap-css-only/css/bootstrap.min.css";
import "mdbreact/dist/css/mdb.css";

class Header extends Component{
    state = {
        collapseID: ''
      }
      
      toggleCollapse = collapseID => () => {
        this.setState(prevState => ({ collapseID: (prevState.collapseID !== collapseID ? collapseID : '') }));
      }

    render(){
        return(
            
            <MDBContainer>
            <MDBNavbar color="light-blue lighten-4" style={{ marginTop: '20px' }} light>
              <MDBContainer>
                <MDBNavbarBrand>
                  AdoptApp
                </MDBNavbarBrand>
                <MDBNavbarToggler onClick={this.toggleCollapse('navbarCollapse1')} />
                <MDBCollapse id="navbarCollapse1" isOpen={this.state.collapseID} navbar>
                  <NavbarNav left>
                    <MDBNavItem active>
                      <Link to="/shelter/add" className="FormField__Link">Crear Asociación</Link>
                    </MDBNavItem>
                    <MDBNavItem active>
                      <Link to="/animal/add" className="FormField__Link">Añadir animal</Link>
                    </MDBNavItem>
                    <MDBNavItem>
                        <Link to="/" className="FormField__Link">Iniciar Sesión</Link>
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