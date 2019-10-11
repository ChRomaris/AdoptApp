import React from "react";
import {FormattedMessage} from "react-intl";
import {connect} from 'react-redux';
import Moment from 'moment';
import './styles/styles.css';
const LostAnimalInfoModal = (props) => {
    return(
        <div>
        <div className="lostAnimal-modal-container"
            style={{
                transform: props.show ? 'translateY(0vh)' : 'translateY(-100vh)',
                opacity: props.show ? '1' : '0'
            }}>
            <div className="lostAnimal-modal-body">
           <p> <FormattedMessage id = "form.label.user" /> : {props.location.userName} </p>
            <p><FormattedMessage id = "form.label.comment" /> :{props.location.comment}</p>
           <p><FormattedMessage id = "form.label.date" /> : {Moment(props.location.dateTime).format("DD-MM-YY")}</p> 

            </div>
            <div className="lostAnimal-modal-footer">
                <button className="btn-cancel" onClick={props.close}><FormattedMessage id = "form.button.close" /></button>
                <button className="btn-cancel" onClick={props.close}><FormattedMessage id = "form.button.contact" /></button>
            </div>
        </div>
    </div>
    )
}

const mapStateToProps = state => (console.log(state),{
    location : state.lostAnimals.selectedLocation
})

export default connect(mapStateToProps,{})(LostAnimalInfoModal) 