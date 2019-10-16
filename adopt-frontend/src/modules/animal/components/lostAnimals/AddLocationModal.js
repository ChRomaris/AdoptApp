import React from "react";
import {FormattedMessage} from "react-intl";
import AddLocationMap from '../../../common/AddLocationMap';
import {Container, Button, Form, FormGroup, Label, Input} from 'reactstrap';
import './styles/styles.css';


const AddLocationModal = (props) => {
    return(
        <div>
        <div className="addLocation-modal-container"
            style={{
                transform: props.show ? 'translateY(0vh)' : 'translateY(-100vh)',
                opacity: props.show ? '1' : '0'
            }}>
            <div className="modal-header">
                <h3><FormattedMessage id = "form.tittle.addLocation" /></h3>
                <span className="close-modal-btn" onClick={props.close}>×</span>
            </div>
            <div className="addLocation-modal-body">
                <AddLocationMap setParentLocationState = {props.set}></AddLocationMap>
                <div>
                <Form >
                    <FormGroup>
                        <Label for="exampleName">Comentario</Label>
                        <Input type="text" name="name" id="exampleName" ></Input>     
                    </FormGroup>
                    <FormGroup>
                    <Label for="exampleBirthDate">Fecha</Label>
                    <Input type="date" name="birthDate" id="exampleBirthDate" ></Input>     
                </FormGroup> 
                </Form>
                </div>
            </div>
            <div className=".addLocation-modal-footer">
                <button className="btn-cancel" onClick={props.close}><FormattedMessage id = "form.button.close" /></button>
                <button className="btn-continue"onClick={props.save}>Añadir</button>
            </div>
        </div>
    </div>
    )
}


export default AddLocationModal 