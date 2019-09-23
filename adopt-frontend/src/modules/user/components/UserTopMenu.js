import React,{ Component } from "react";
import {
    MDBNavbar, MDBNavbarBrand, MDBNavbarNav, MDBNavItem, MDBNavLink, MDBNavbarToggler, MDBCollapse, MDBFormInline,
    MDBDropdown, MDBDropdownToggle, MDBDropdownMenu, MDBDropdownItem
    } from "mdbreact";

    import '@fortawesome/fontawesome-free/css/all.min.css';
import "bootstrap-css-only/css/bootstrap.min.css";
import "mdbreact/dist/css/mdb.css";
import {FormattedMessage} from 'react-intl';
    
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
                        <span className="mr-2"><FormattedMessage id="menu.label.profile"/></span>
                      </MDBDropdownToggle>
                      <MDBDropdownMenu>
                        <MDBDropdownItem ><a href="#/user/update"><FormattedMessage id="menu.label.personalInfo"/></a></MDBDropdownItem>
                        <MDBDropdownItem   onClick={this.logout} ><a href="/"><FormattedMessage id="menu.label.logout"/></a></MDBDropdownItem>
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