import React,{Component} from 'react';
import AddLocationMap from './AddLocationMap';

class PositionSection extends Component{
    constructor(props){
        super();
        this.setParentLocation = this.setParentLocation.bind(this);
    }

    

    setParentLocation(lat, long){
        try
        {
        this.props.setParentLocation(lat,long)
        }
        catch(error)
        {
            console.log("Funcion para recuperar coodenadas no definida")
        }
    }

    render(){
        return(
            
            <div className="mainPositionSection">
            <div><h4>Añadir ubicación:</h4></div>
                <AddLocationMap setParentLocationState={this.setParentLocation}></AddLocationMap>
            </div>
           
        )
    }
}

export default PositionSection;