import React,{Component}  from 'react';
import GoogleMapReact from 'google-map-react';
import Marker from './Marker';

import '../../styles/userStyles.css'

//const AnyReactComponent = ({ text }) => <img  src= {animalMarker} alt={text} height="20px" width="5px"  ></img>;

class AddLocationMap extends Component {
    constructor(props){
        super(props);
        this.state={
            selectedLatitude: '',
            selectedLongitude:''
        }

        this.setParentLocation = this.setParentLocation.bind(this)
        
    }
    static defaultProps = {
        center: {
          lat: 42.09989087544122,
          lng: -77.03967669057192
        },
        zoom:11
      };

      setMapPointer(lat, long){
        this.setState({
          selectedLatitude: lat,
          selectedLongitude: long
        })
      }

      setParentLocation(lat,long){
        this.props.setParentLocationState(lat,long)
      }

      _onClick = ({x, y, lat, lng, event}) => {
        
        this.setState({
          selectedLatitude: lat,
          selectedLongitude: lng
        },this.setParentLocation(lat,lng))
        }
     
      render() {
        return (    
          <div style={{ height: '50vh', width: '100%' }}>
            <GoogleMapReact onClick={this._onClick}
              bootstrapURLKeys={{ key: 'AIzaSyAREV4WoFuo_aAjetmOHXmr9ulKepuYKRo' }}
              defaultCenter={this.props.center}
              defaultZoom={this.props.zoom}
            >
            <Marker
              lat={this.state.selectedLatitude}
              lng={this.state.selectedLongitude}
              name="My Marker"
          />
            </GoogleMapReact>
          </div>
        );
      }
}

export default AddLocationMap;