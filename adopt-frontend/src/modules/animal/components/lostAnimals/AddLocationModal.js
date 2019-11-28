import React, { Component } from "react";
import {FormattedMessage} from "react-intl";
import AddLocationMap from '../../../common/AddLocationMap';
import {Form, FormGroup, Label, Input} from 'reactstrap';
import './styles/styles.css';


class AddLocationModal extends Component {

    render(){
    return(
        <div>
        <div className="addLocation-modal-container"
            style={{
                transform: this.props.show ? 'translateY(0vh)' : 'translateY(-100vh)',
                opacity: this.props.show ? '1' : '0'
            }}>
            <div className="modal-header">
                <h3><FormattedMessage id = "form.tittle.addLocation" /></h3>
                <span className="close-modal-btn" onClick={this.props.close}>×</span>
            </div>
            <div className="addLocation-modal-body">
                <AddLocationMap setParentLocationState = {this.props.set}></AddLocationMap>
                <div>
                <Form >
                    <FormGroup>
                        <Label for="exampleName">Comentario</Label>
                        <Input type="text" name="name" id="exampleName" onChange = {this.props.commentChange} ></Input>     
                    </FormGroup>
                    <FormGroup>
                    <Label for="exampleBirthDate">Fecha</Label>
                    <Input type="date" name="birthDate" id="exampleBirthDate" onChange ={this.props.dateChange} ></Input>     
                </FormGroup> 
                </Form>
                </div>
            </div>
            <div className=".addLocation-modal-footer">
                <button className="btn-cancel" onClick={this.props.close}><FormattedMessage id = "form.button.close" /></button>
                <button className="btn-continue"onClick={this.props.save}>Añadir</button>
            </div>
        </div>
    </div>
    )}
}


export default AddLocationModal 