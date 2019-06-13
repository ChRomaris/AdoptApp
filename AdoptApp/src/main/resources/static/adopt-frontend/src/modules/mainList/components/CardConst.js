import React from 'react';
import {CardHeader, CardBody, CardTitle, CardText, Button, CardFooter,Card} from 'reactstrap';
import PreviewImage from '../components/PreviewImage';
import '../../../styles/cardStyle.css'
const CardConst = (props) =>  {
    return(
        <Card>
        <CardHeader>{props.name}</CardHeader>
        <CardBody className="cardBody">
            <div className="picture">
            <PreviewImage image = {props.image}/>
            </div>
            <div className="texts">
            <CardTitle>Genero: </CardTitle>
            <CardTitle>Edad: {props.birthDate}</CardTitle>
            <CardTitle>Raza: </CardTitle>
            <CardText>Descripción: {props.description}</CardText>
            </div>>
        </CardBody>
        
        <CardFooter><Button>Mas Información</Button></CardFooter>
        
    </Card>
    )
    };

export default CardConst;