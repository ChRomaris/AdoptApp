import React, { Component } from 'react';
import {CardHeader, CardBody, CardTitle, CardText, Button, CardFooter,Card} from 'reactstrap';
import PreviewImage from '../components/PreviewImage';
import Buttons from '../components/Buttons';
import Moment from 'moment';
import 'moment/locale/es' 
import '../../../styles/cardStyle.css'
import {FormattedMessage} from 'react-intl'
import {TwitterShareButton} from 'react-twitter-embed';
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
        console.log("Valor del animal en card")
        console.log(this.props.animal)
        return( <Buttons animalId = {this.props.animal.id} showEditingForm = {this.showForm} deleteAnimal = {this.props.deleteAnimal} ></Buttons>, <TwitterShareButton url={'https://adoptapp.com/'+this.props.animal.id} options={{ text: ' Hay un nuevo animal en nuestra asociación. Se llama '+ this.props.animal.name +' y es un '+this.props.animal.breed+ '. Mas información en:' }}/>    )
    }
}
render(){
    Moment.locale('es');
    console.log(this.props);
    return(
        <Card>
        <CardHeader>{this.props.animal.name}</CardHeader>
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
        
        <CardFooter><Button onClick ={()=>this.props.showInfo(this.props.animal.id)}><FormattedMessage id ="form.button.moreInfo"/></Button></CardFooter>
        
    </Card>
    )
}
    };
export default CardConst;