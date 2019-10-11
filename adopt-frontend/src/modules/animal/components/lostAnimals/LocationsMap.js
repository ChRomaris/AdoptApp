import React,{ Component } from "react";
import GoogleMapReact from 'google-map-react';
import LocationMarker from './LocationMarker';
import {connect} from 'react-redux';
import LostAnimalInfoModal from './LostAnimalInfoModal';
import {setSelectedLocation} from './actions/actions';

class LocationsMap extends Component{
  constructor (){
    super()
    this.state = {
      showModal : false,
      selectedMarker : ''
    }

    this.showModal = this.showModal.bind(this);
    this.closeModal = this.closeModal.bind(this);
  }

    static defaultProps = {
        center: {
          lat: 42.09989087544122,
          lng: -77.03967669057192
        },
        zoom:11
      };

      

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

    render(){
        return(
            <div className="markersMap" >
           <LostAnimalInfoModal show = {this.state.showModal} marker = {this.state.selectedMarker} close={this.closeModal}></LostAnimalInfoModal>
            <GoogleMapReact 
              bootstrapURLKeys={{ key: 'AIzaSyAREV4WoFuo_aAjetmOHXmr9ulKepuYKRo'}}
              defaultCenter={this.props.center}
              defaultZoom={this.props.zoom}
            >
            
            {this.props.locations.map(marker => (
              console.log(marker.LocationId),
            <LocationMarker toggleModal={()=>this.showModal(marker)}
              key={marker.LocationId}
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

const mapStateToProps = state =>(console.log(state.lostAnimals.locations),{
    locations : state.lostAnimals.locations
})

export default connect (mapStateToProps,{setSelectedLocation})(LocationsMap)