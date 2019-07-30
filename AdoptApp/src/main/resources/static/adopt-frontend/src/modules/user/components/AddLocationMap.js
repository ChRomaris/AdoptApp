import React,{Component}  from 'react';
import GoogleMapReact from 'google-map-react';
import animalMarker from '../../../images/dog.png'

const AnyReactComponent = ({ text }) => <img src={animalMarker} alt="marker" height="30px"></img>;

class AddLocationMap extends Component {
    constructor(){
        super();
        this.state={
            selectedLatitude: '',
            selectedLongitude:''
        }
    }
    static defaultProps = {
        center: {
          lat: 40.411816,
          lng: -3.709079
        },
        zoom: 6
      };

      _onClick = ({x, y, lat, lng, event}) => {
          this.setState({
              selectedLatitude:lat,
              selectedLongitude:lng
          }, () => {
            console.log("latitude: "+ this.state.selectedLatitude + "longitude: "+ this.state.selectedLongitude)
          })
        }
     
      render() {
        return (    
          <div style={{ height: '60vh', width: '100%' }}>
            <GoogleMapReact onClick={this._onClick}
              bootstrapURLKeys={{ key: "AIzaSyAREV4WoFuo_aAjetmOHXmr9ulKepuYKRo" }}
              defaultCenter={this.props.center}
              defaultZoom={this.props.zoom}
            >
            <AnyReactComponent
              lat={this.state.selectedLatitude}
              lng={this.state.selectedLongitude}
              text="My Marker"
          />
            </GoogleMapReact>
          </div>
        );
      }
}

export default AddLocationMap;