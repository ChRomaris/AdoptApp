import React, { Component } from 'react';
import {CardHeader, CardBody, CardTitle, CardText, Button, CardFooter,Card} from 'reactstrap';
import PreviewImage from '../components/PreviewImage';
import Buttons from '../components/Buttons';
import '../../../styles/cardStyle.css'
class CardConst extends Component  {
constructor(props){
    super(props);
    this.showForm = this.showForm.bind(this)
}

showForm(){
    console.log("El id es :" + this.props.id)
    this.props.showEditingForm(this.props.id);
}
render(){


    return(
        <Card>
        <CardHeader>{this.props.name}</CardHeader>
        <CardBody className="cardBody">
            <div className="picture">
            <PreviewImage image = {this.props.image}/>
            </div>
            <div className="texts">
            <CardTitle>Genero: </CardTitle>
            <CardTitle>Id: {this.props.id} </CardTitle>
            <CardTitle>Edad: {this.props.birthDate}</CardTitle>
            <CardTitle>Raza: </CardTitle>
            <CardText>Descripción: {this.props.description}</CardText>

            
            </div>  
        <div>
            <Buttons reloadList={this.props.reloadList} animalId = {this.props.id} showEditingForm = {this.showForm} ></Buttons>
        </div>
        </CardBody>
        
        <CardFooter><Button onClick ={this.props.showEditingForm}>Mas Información</Button></CardFooter>
        
    </Card>
    )
}
    };

export default CardConst;