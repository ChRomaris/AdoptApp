import React from 'react';
import {FormattedMessage} from "react-intl"

import './styles/common.css';

const modal = (props) => {
    console.log(props)
    return (
        <div>
            <div className="modal-wrapper"
                style={{
                    transform: props.show ? 'translateY(0vh)' : 'translateY(-100vh)',
                    opacity: props.show ? '1' : '0'
                }}>
                <div className="modal-header">
                    <h3>{props.shelter.name}</h3>
                    <span className="close-modal-btn" onClick={props.close}>×</span>
                </div>
                <div className="modal-body">
                    <div className="modal-data">
                        <div className="modal-data-field"><p><FormattedMessage id = "form.label.type" />:</p> {props.shelter.type}  </div> 
                        <div className="modal-data-field"><p><FormattedMessage id = "form.label.address" />:</p> {props.shelter.address}  </div>  
                        <div className="modal-data-field"><p><FormattedMessage id = "form.label.email" />:</p> {props.shelter.email}  </div> 
                        <div className="modal-data-field"><p><FormattedMessage id = "form.label.phoneNumber" />:</p> {props.shelter.phoneNumber}  </div> 
                        <div className="modal-data-field"><p><FormattedMessage id = "form.label.distance" /> :</p> {Math.round(props.shelter.distance)} Km  </div> 
                    </div>

                </div>
                <div className="modal-footer">
                    <button className="btn-cancel" onClick={props.close}><FormattedMessage id = "form.button.close" /></button>
                    <button className="btn-continue" onClick={()=>props.showAnimals(props.shelter.id)}><FormattedMessage id = "form.button.animal" /></button>
                </div>
            </div>
        </div>
    )
}

export default modal;