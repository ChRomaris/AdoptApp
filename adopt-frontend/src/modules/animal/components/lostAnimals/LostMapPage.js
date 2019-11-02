import React,{ Component } from "react";
import {connect} from 'react-redux';
import {getLostAnimalsInArea, showModal, setMarkerInfo,closeModal} from './actions/actions';
import MarkerMapMain from '../../../common/MarkerMapMain';
import TopMenu from '../../../app/components/TopMenu';
import LostAnimalInfoModal from './LostAnimalInfoModal';

class LostMapPage extends Component{


    componentDidMount (){
        const params = {
            token : sessionStorage.getItem('serviceToken')
        }
        this.props.setMarkerInfo();
        this.props.getLostAnimalsInArea(params);
        this.showInfo = this.showInfo.bind(this);
        this.props.closeModal();
    }


    showInfo(animalId){
        this.props.history.replace("/lost/"+animalId)
    }


    render(){
        return(
            <div>
                <TopMenu/>
                <LostAnimalInfoModal show = {this.props.show} showInfo = {this.showInfo}></LostAnimalInfoModal>
                <MarkerMapMain toggleModal ={this.props.showModal} markers={this.props.animals}></MarkerMapMain>
            </div>
        )
    }

}

const mapStateToProps = state =>({
    animals :  state.lostAnimals.animals,
    show : state.lostAnimals.showModal
})

export default connect (mapStateToProps, {getLostAnimalsInArea,showModal, setMarkerInfo, closeModal})(LostMapPage) ;