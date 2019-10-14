import React from "react";
import {FormattedMessage} from "react-intl";
import {connect} from 'react-redux';
import Moment from 'moment';
import {closeModal} from './actions/actions';
import PreviewImage from '../../../mainList/components/PreviewImage'
import './styles/styles.css';

function renderMarkerInfo(props){
    if(props.isMarkerInfo){
        console.log(props)
        return(
        <div>
            <div className="marker-modal-image">
            <PreviewImage image = {props.selectedAnimal.image}/>
            </div>
            <div className="marker-modal-text">
            <p><label><FormattedMessage age id = "form.label.user" /> : </label> {props.selectedAnimal.userName}</p>
            <p><label> <FormattedMessage id = "form.label.name" /> : </label> {props.selectedAnimal.name} </p>
            <p><label><FormattedMessage id = "form.label.breed" /> : </label> {props.selectedAnimal.breed}</p>
            <p><label><FormattedMessage id = "form.label.date" /> : </label> {Moment(props.location.dateTime).format("DD-MM-YY")}</p>  
            </div>
        </div>
    )
    }else{
        return (
            <div>
                <p> <FormattedMessage id = "form.label.user" /> : {props.location.userName} </p>
                <p><FormattedMessage id = "form.label.comment" /> :{props.location.comment}</p>
                <p><FormattedMessage id = "form.label.date" /> : {Moment(props.location.dateTime).format("DD-MM-YY")}</p> 
            </div>
        )
    }
}
const LostAnimalInfoModal = (props) => {
    return(
        <div>
        <div className="lostAnimal-modal-container"
            style={{
                transform: props.show ? 'translateY(0vh)' : 'translateY(-100vh)',
                opacity: props.show ? '1' : '0'
            }}>
            <div className="lostAnimal-modal-body">
            
                {renderMarkerInfo(props)}

            </div>
            <div className="lostAnimal-modal-footer">
                <button className="btn-cancel" onClick={props.closeModal}><FormattedMessage id = "form.button.close" /></button>
                <button className="btn-cancel" onClick={props.closeModal}><FormattedMessage id = "form.button.contact" /></button>
            </div>
        </div>
    </div>
    )
}


const mapStateToProps = state => (console.log(state),{
    location : state.lostAnimals.selectedLocation,
    isUserList : state.lostAnimals.isUserList,
    isMarkerInfo : state.lostAnimals.isMarkerInfo,
    selectedAnimal : state.lostAnimals.selectedAnimal
    
})

export default connect(mapStateToProps,{closeModal})(LostAnimalInfoModal) 