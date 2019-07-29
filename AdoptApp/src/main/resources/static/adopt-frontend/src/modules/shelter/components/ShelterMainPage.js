import React, {Component} from 'react';

class ShelterMainPage extends Component {
    constructor(props){
        super();
        this.state  = {
            shelterName: props.shelterName
        }
    }

    render(){
        return(
            <p>Existe asociación</p>
        )
    }
}

export default ShelterMainPage;