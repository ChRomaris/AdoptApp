import React,{ Component } from "react";
import MarkersMap from "../common/MarkersMap";
import './styles/common.css'

class MarkerMapMain extends Component{
    constructor(props){
        super(props);
        this.state={
            markers:[]
        }
        
    }

    render(){
        return(
        <div   >
        <MarkersMap  toggleModal = {this.props.toggleModal} markers={this.props.markers}></MarkersMap>
        </div>
        )
    }
}

export default MarkerMapMain;