import React,{ Component } from "react";
import GoogleMapReact from 'google-map-react';
import LocationMarker from './LocationMarker';
import {connect} from 'react-redux';
import LostAnimalInfoModal from './LostAnimalInfoModal';
import {setSelectedLocation, disableMarkerInfo} from './actions/actions';

class LocationsMap extends Component{
  constructor (){
    super()
    this.state = {
      showModal : false,
      selectedMarker : ''
    }

    this.showModal = this.showModal.bind(this);
    this.closeModal = this.closeModal.bind(this);
    this.contact = this.contact.bind(this);
  }

    static defaultProps = {
      center: {
        lat: 43.3351,
        lng: -8.38233
      },
        zoom:11
      };
      

      componentDidMount(){
        this.closeModal()
        this.props.disableMarkerInfo()
      }

      

    showModal (location){
      this.props.setSelectedLocation(location)
      this.setState ({
        showModal : true
      })
    }

    closeModal(){
      this.setState({
        showModal : false,
      })
    }

    contact(username){
      this.props.contact(username)
  }

    render(){
        return(
            <div className="locationsMarkersMap" >
           <LostAnimalInfoModal show = {this.state.showModal} marker = {this.state.selectedMarker} close={this.closeModal} contact = {this.contact}></LostAnimalInfoModal>
            <GoogleMapReact 
              bootstrapURLKeys={{ key: 'AIzaSyAREV4WoFuo_aAjetmOHXmr9ulKepuYKRo'}}
              defaultCenter={this.props.center}
              defaultZoom={this.props.zoom}
            >

            {this.props.locations.map(marker => (
            <LocationMarker toggleModal={()=>this.showModal(marker)}
              key={marker.locationId}
              lat={marker.latitude}
             lng={marker.longitude}
             name="My Marker"
                />  
            ))}
            </GoogleMapReact>
            
          </div>
        )
    }

}

const mapStateToProps = state =>({
    locations : state.lostAnimals.locations
})

export default connect (mapStateToProps,{setSelectedLocation, disableMarkerInfo})(LocationsMap)