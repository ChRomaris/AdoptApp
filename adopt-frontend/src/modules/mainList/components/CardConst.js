import React, { Component } from 'react';
import {CardHeader, CardBody, CardTitle, CardText, Button, CardFooter,Card} from 'reactstrap';
import PreviewImage from '../components/PreviewImage';
import Buttons from '../components/Buttons';
import Moment from 'moment';
import 'moment/locale/es' 
import '../../../styles/cardStyle.css'
import {FormattedMessage} from 'react-intl'
class CardConst extends Component  {
constructor(props){
    super(props);
    this.showForm = this.showForm.bind(this)
    this.renderButtons = this.renderButtons.bind(this)
}

showForm(){
    
    this.props.showEditingForm(this.props.animal.id);
}

renderButtons(){
    if(this.props.showButtons){
        return( <Buttons animalId = {this.props.animal.id} showEditingForm = {this.showForm} deleteAnimal = {this.props.deleteAnimal} ></Buttons>   )
    }
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
            <CardTitle><FormattedMessage id='form.label.genre'/> : {this.props.animal.genre} </CardTitle>
            <CardTitle><FormattedMessage id='form.label.age'/> : {Moment(this.props.animal.birthDate).fromNow(true)}</CardTitle>
            <CardTitle><FormattedMessage id='form.label.breed'/> : {this.props.animal.breed} </CardTitle>
            <CardText><FormattedMessage id='form.label.description'/> : {this.props.animal.description}</CardText>

            
            </div>  
        <div>
            
            {this.renderButtons()}
        </div>
        </CardBody>
        
        <CardFooter><Button onClick ={this.props.showEditingForm}><FormattedMessage id ="form.button.moreInfo"/></Button></CardFooter>
        
    </Card>
    )
}
    };

export default CardConst;