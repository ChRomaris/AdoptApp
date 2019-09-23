import React,{ Component } from "react";
import GoogleMapReact from 'google-map-react';
import Marker from './Marker';

import '../../styles/userStyles.css'
import './styles/common.css'

class MarkersMap extends Component{
    constructor(props){
        super(props);
        this.state={
            selectedLatitude: '',
            selectedLongitude:'',
            center: {
              lat: 42.09989087544122,
              lng: -77.03967669057192
            },
            markers:[]
        }

        this.renderMarkers = this.renderMarkers.bind(this)
      
        
    }

    componentDidMount(){
      
      

      if(this.props.markers.length){
        this.setState({
          markers : this.props.markers,
          center :{
           lat : this.props.markers[0].latitude,
           lng : this.props.markers[0].longitude
          } 

        })

      }
    }

    

    static defaultProps = {
        center: {
          lat: 42.09989087544122,
          lng: -77.03967669057192
        },
        zoom:11
      };

      renderMarkers(){
        console.log(this.state.markers)
         this.state.markers.map((item) =>{
          
         return <Marker lat={item.latitude} lng={item.longitude}  name="My Marker"
         /> }
         )
      }




    render(){
        return(
            <div className="markersMap" >
            <GoogleMapReact 
              bootstrapURLKeys={{ key: 'AIzaSyAREV4WoFuo_aAjetmOHXmr9ulKepuYKRo'}}
              defaultCenter={this.state.center}
              defaultZoom={this.props.zoom}
            >
            
            {this.props.markers.map(marker => (
        
            <Marker toggleModal={()=>this.props.toggleModal(marker.id,marker.name,marker.birthDate, marker.distance, marker.image, marker.breed)}
              key={marker.id}
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

export default MarkersMap;