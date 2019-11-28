import React,{Component} from "react";
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
            {console.log(props.selectedAnimal)}
            <div className="marker-modal-image">
            <PreviewImage image = {props.selectedAnimal.image}/>
            </div>
            <div className="marker-modal-text">
            <p><label><FormattedMessage age id = "form.label.user" /> : </label> {props.selectedAnimal.userName}</p>
            <p><label> <FormattedMessage id = "form.label.name" /> : </label> {props.selectedAnimal.name} </p>

            <p><label><FormattedMessage id = "form.label.date" /> : </label> {Moment(props.location.dateTime).format("DD-MM-YY")}</p>  
            </div>
        </div>
    )
    }else{
        return (
            <div className="locationInfo">
                <p className="boldText"><FormattedMessage id = "form.label.user" /> :{props.location.userName} </p>
                <p className="boldText"><FormattedMessage id = "form.label.comment"  /> {props.location.comment}</p>
                <p className="boldText"><FormattedMessage id = "form.label.date"  /> : {Moment(props.location.dateTime).format("DD-MM-YY")}</p> 
            </div>
        )
    }
}

function renderButtons(props){
    if(props.isMarkerInfo){
        console.log(props)

        if(sessionStorage.getItem('serviceToken')!==null){
            return(

                <div className="lostAnimal-modal-footer">
                <button className="btn btn-danger" onClick={props.closeModal}><FormattedMessage id = "form.button.close" /></button>
                <button className="btn btn-primary" onClick={()=>props.contact(props.selectedAnimal.userName)}><FormattedMessage id = "form.button.contact" /></button>
                <button className="btn btn-primary" onClick={()=>props.showInfo(props.selectedAnimal.id)}><FormattedMessage id = "form.button.moreInfo" /></button>
               
            </div>
        )
        }else{
            return(

                <div className="lostAnimal-modal-footer">
                <button className="btn btn-danger" onClick={props.closeModal}><FormattedMessage id = "form.button.close" /></button>
                <button className="btn btn-primary" onClick={()=>props.showInfo(props.selectedAnimal.id)}><FormattedMessage id = "form.button.moreInfo" /></button>
               
            </div>
        ) 
        }

    }else{
        if(props.location.userName === "Desconocido"){
            return(
                <div className="lostAnimal-modal-footer">
                <button className="btn-cancel" onClick={props.close}><FormattedMessage id = "form.button.close" /></button>
            </div> 
            )
        }else{

            return (
                <div className="lostAnimal-modal-footer">
                <button className="btn-cancel" onClick={props.close}><FormattedMessage id = "form.button.close" /></button>
                <button className="btn-cancel" onClick={()=>props.contact(props.location.userName)}><FormattedMessage id = "form.button.contact" /></button>
            </div>
            )
        }

    }
}
class LostAnimalInfoModal extends Component {
    
    render(){

    
    return(
        <div>
        <div className="lostAnimal-modal-container"
            style={{
                transform: this.props.show ? 'translateY(0vh)' : 'translateY(-100vh)',
                opacity: this.props.show ? '1' : '0'
            }}>
            <div className="lostAnimal-modal-body">

                {renderMarkerInfo(this.props)}

            </div>
                {renderButtons(this.props)}
        </div>
    </div>
    )}
}


const mapStateToProps = state => ({
    location : state.lostAnimals.selectedLocation,
    isUserList : state.lostAnimals.isUserList,
    isMarkerInfo : state.lostAnimals.isMarkerInfo,
    selectedAnimal : state.lostAnimals.selectedAnimal,
    selectedBreed : state.lostAnimals.selectedBreed
    
})

export default connect(mapStateToProps,{closeModal})(LostAnimalInfoModal) 