import React, { Component } from 'react';
import {CardHeader, CardBody, CardTitle, CardText, Button, CardFooter,Card} from 'reactstrap';
import PreviewImage from '../components/PreviewImage';
import Buttons from '../components/Buttons';
import Moment from 'moment';
import '../../../styles/cardStyle.css'
class CardConst extends Component  {
constructor(props){
    super(props);
    this.showForm = this.showForm.bind(this)
}

showForm(){
    
    this.props.showEditingForm(this.props.animal.id);
}



render(){
    Moment.locale('es');
    console.log(this.props);
    return(
        <Card>
        <CardHeader>{this.props.name}</CardHeader>
        <CardBody className="cardBody">
            <div className="picture">
            <PreviewImage image = {this.props.animal.image}/>
            </div>
            <div className="texts">
            <CardTitle>Genero: </CardTitle>
            <CardTitle>Id: {this.props.animal.id} </CardTitle>
            <CardTitle>Edad: {Moment(this.props.animal.birthDate).fromNow(true)}</CardTitle>
            <CardTitle>Raza: </CardTitle>
            <CardText>Descripción: {this.props.animal.description}</CardText>

            
            </div>  
        <div>
            
            <Buttons animalId = {this.props.animal.id} showEditingForm = {this.showForm} deleteAnimal = {this.props.deleteAnimal} ></Buttons>
        </div>
        </CardBody>
        
        <CardFooter><Button onClick ={this.props.showEditingForm}>Mas Información</Button></CardFooter>
        
    </Card>
    )
}
    };

export default CardConst;