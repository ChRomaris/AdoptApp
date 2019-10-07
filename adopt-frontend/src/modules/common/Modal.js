import React from 'react';
import PreviewImage from '../mainList/components/PreviewImage'
import {FormattedMessage} from "react-intl"

import './styles/common.css';

const modal = (props) => {
    return (
        <div>
            <div className="modal-wrapper"
                style={{
                    transform: props.show ? 'translateY(0vh)' : 'translateY(-100vh)',
                    opacity: props.show ? '1' : '0'
                }}>
                <div className="modal-header">
                    <h3>{props.name}</h3>
                    <span className="close-modal-btn" onClick={props.close}>×</span>
                </div>
                <div className="modal-body">
                    <div className="modal-image">
                    <PreviewImage image = {props.image}/>
                    </div>
                    <div className="modal-data">
                        <div className="modal-data-field"><FormattedMessage id = "form.label.distance" /> : {props.distance} Km  </div> 
                        <div className="modal-data-field"><FormattedMessage id = "form.label.breed" />: {props.breed}  </div> 
                        <div className="modal-data-field"><FormattedMessage id = "form.label.age" />: {props.age}  </div>  
                    </div>

                </div>
                <div className="modal-footer">
                    <button className="btn-cancel" onClick={props.close}><FormattedMessage id = "form.button.close" /></button>
                    <button className="btn-continue"><FormattedMessage id = "form.button.moreInfo" /></button>
                </div>
            </div>
        </div>
    )
}

export default modal;