import React,{ Component } from "react";
import GoogleMapReact from 'google-map-react';
import Marker from './Marker';
import {setAnimal} from '../animal/components/lostAnimals/actions/actions';
import {connect} from 'react-redux';

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
          markers : this.props.markers

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
    
            <Marker toggleModal={()=>(this.props.toggleModal(marker),this.props.setAnimal(marker))}
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

const mapStateToProps = state => (console.log(state),{
  selectedAnimal : state.lostAnimals.selectedAnimal
})

export default connect (mapStateToProps,{setAnimal})(MarkersMap);