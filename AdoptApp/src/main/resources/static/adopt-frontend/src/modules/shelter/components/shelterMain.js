import React, {Component} from 'react';
import ShelterCreationForm from './ShelterCreationForm';
import Header from '../../app/components/Header';
class shelterMain extends Component{

render(){
    return (
        <div class="shelterMain">
        <Header/>
        <ShelterCreationForm/>
        </div>
    );
}
}

export default shelterMain;