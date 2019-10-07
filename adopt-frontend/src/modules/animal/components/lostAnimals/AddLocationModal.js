import React from "react";
import {FormattedMessage} from "react-intl"

const AddLocationModal = (props) => {
    return(
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
                <p>Cuerpo del modal</p>
            </div>
            <div className="modal-footer">
                <button className="btn-cancel" onClick={props.close}><FormattedMessage id = "form.button.close" /></button>
                <button className="btn-continue">Añadir</button>
            </div>
        </div>
    </div>
    )
}


export default AddLocationModal