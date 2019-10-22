import React, { Component } from "react";
import GoogleMapReact from 'google-map-react';
import Marker from './Marker';
import './styles/common.css'

class SingleMarkerMap extends Component{
    constructor(props){
        super(props);
        this.state={
            key : 0 ,
            center: {
              lat: 42.09989087544122,
              lng: -77.03967669057192
            },

            latitude:'',
            longitude:'',
        }
        
    }

    static defaultProps = {
        center: {
          lat: 42.09989087544122,
          lng: -77.03967669057192
        },
        zoom:11,
        latitude:'',
        longitude:'',
      };

      

render(){
    return(
    <div className="singleMarkerMapContainer" >
        <div className="markersMap" >
            
            <GoogleMapReact 
              bootstrapURLKeys={{ key: 'AIzaSyAREV4WoFuo_aAjetmOHXmr9ulKepuYKRo'}}
              defaultCenter={this.state.center}
              defaultZoom={this.props.zoom}
            >
            <Marker
                key={this.props.latitude}
                lat={this.props.latitude}
                lng={this.props.longitude}
                name="My Marker"
            />
            </GoogleMapReact>
        </div>
    </div>)
}

}

export default SingleMarkerMap;