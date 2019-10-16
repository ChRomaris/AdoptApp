import React,{ Component } from "react";
import {
  MDBNavbar, MDBNavbarBrand, MDBNavbarNav, MDBNavItem, MDBNavbarToggler, MDBCollapse, MDBFormInline,
  MDBDropdown, MDBDropdownToggle, MDBDropdownMenu, MDBDropdownItem
  } from "mdbreact";

  import '@fortawesome/fontawesome-free/css/all.min.css';
import "bootstrap-css-only/css/bootstrap.min.css";
import "mdbreact/dist/css/mdb.css";
  
  import { userService } from '../../../backend/userService';
  import {FormattedMessage} from 'react-intl';

class ShelterTopMenu extends Component {
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

      logout(){
 
        userService.logout();
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
                <MDBDropdownItem ><a href="#/adoptionMap"><FormattedMessage id="menu.label.animalMap"/></a></MDBDropdownItem> 
                </MDBDropdownMenu>
              </MDBDropdown>
            <MDBNavItem>
            <MDBDropdown>
            <MDBDropdownToggle nav caret>
                  <span className="mr-2"><FormattedMessage id="menu.label.shelterAdmin"/></span>
                </MDBDropdownToggle>
                <MDBDropdownMenu >
                <MDBDropdownItem ><a href="#/animal/add"><FormattedMessage id="menu.label.addAnimal"/></a></MDBDropdownItem> 
                <MDBDropdownItem ><a href="#/shelter"><FormattedMessage id="menu.label.shelterAnimalList"/></a></MDBDropdownItem> 
                </MDBDropdownMenu>
              </MDBDropdown>
            </MDBNavItem>
            <MDBNavItem>
              <MDBDropdown>
                <MDBDropdownToggle nav caret>
                  <span className="mr-2"><FormattedMessage id="menu.label.profile"/></span>
                </MDBDropdownToggle>
                <MDBDropdownMenu>
                <MDBDropdownItem ><a href="#/shelter/preferences"><FormattedMessage id="menu.label.preferences"/></a></MDBDropdownItem>
                  <MDBDropdownItem ><a href="#/shelter/update"><FormattedMessage id="menu.label.shelterInfo"/></a></MDBDropdownItem>
                  <MDBDropdownItem   onClick={this.logout} ><a href="/"><FormattedMessage id="menu.label.logout"/></a></MDBDropdownItem>
                </MDBDropdownMenu>
              </MDBDropdown>
            </MDBNavItem>
          </MDBNavbarNav>
        </MDBCollapse>
      </MDBNavbar>
          );
        }
}

export default ShelterTopMenu;