import React,{ Component } from "react";
import {
    MDBNavbar, MDBNavbarBrand, MDBNavbarNav, MDBNavItem, MDBNavbarToggler, MDBCollapse,
    MDBDropdown, MDBDropdownToggle, MDBDropdownMenu, MDBDropdownItem
    } from "mdbreact";

    import '@fortawesome/fontawesome-free/css/all.min.css';
import "bootstrap-css-only/css/bootstrap.min.css";
import "mdbreact/dist/css/mdb.css";
import {FormattedMessage} from 'react-intl';
    
import { userService } from '../../../backend/userService'

class AnonimousTopMenu extends Component{
    state = {
        isOpen: false,
      };
      
      componentDidMount(){
        this.setState={
          isOpen :false,
        }
      }
      
      toggleCollapse = () => {
        this.setState({ isOpen: !this.state.isOpen });
      }
    
      
      render() {
        return (
            <MDBNavbar className="bar" dark expand="md">
              <MDBNavbarBrand>
                <strong className="white-text"><FormattedMessage id="app.name"/></strong>
              </MDBNavbarBrand>
              <MDBNavbarToggler onClick={this.toggleCollapse} />
              <MDBCollapse id="navbarCollapse3" isOpen={this.state.isOpen} navbar>
                <MDBNavbarNav left>
                  <MDBDropdown>
                      <MDBDropdownToggle nav caret>
                        <span className="mr-2"><FormattedMessage id="menu.label.adoptionAnimals"/></span>
                      </MDBDropdownToggle>
                      <MDBDropdownMenu>
                      <MDBDropdownItem ><a href="#/List"><FormattedMessage id="menu.label.animalList"/></a></MDBDropdownItem> 
                      <MDBDropdownItem ><a href="#/adoptionMap"><FormattedMessage id="menu.label.shelterMap"/></a></MDBDropdownItem> 
                      <MDBDropdownItem ><a href="#/shelterList"><FormattedMessage id="menu.label.shelterList"/></a></MDBDropdownItem>
                      </MDBDropdownMenu>
                    </MDBDropdown>
                    <MDBDropdown>
                      <MDBDropdownToggle nav caret>
                        <span className="mr-2"><FormattedMessage id="menu.label.lostAnimals"/></span>
                      </MDBDropdownToggle>
                      <MDBDropdownMenu>
                      
                      <MDBDropdownItem ><a href="#/lostList"><FormattedMessage id="menu.label.animalList"/></a></MDBDropdownItem> 
                      <MDBDropdownItem ><a href="#/lostMap"><FormattedMessage id="menu.label.animalMap"/></a></MDBDropdownItem> 
 
                      </MDBDropdownMenu>
   
                    </MDBDropdown>
                    <li className="nav-item">
                  <a className="nav-link" href="#/"> Acceder</a>
                     </li>
                </MDBNavbarNav>
              </MDBCollapse>
            </MDBNavbar>
          );
        }
}

export default AnonimousTopMenu