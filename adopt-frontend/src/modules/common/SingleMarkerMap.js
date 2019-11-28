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
          lat: 43.3351,
          lng: -8.38233
        },
        zoom:8,
        latitude:'',
        longitude:'',
      };

      
      componentWillReceiveProps(newProps){
        console.log("props")
        console.log(newProps)
        this.setState({
          center:{
            lat : newProps.latitude,
            lng : newProps.longitude
          }
        })
      }

render(){

    return(
    <div className="singleMarkerMapContainer" >
      
        <div className="markersMap" >
            
            <GoogleMapReact 
              bootstrapURLKeys={{ key: 'AIzaSyAREV4WoFuo_aAjetmOHXmr9ulKepuYKRo'}}
              defaultCenter = {this.props.center}
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