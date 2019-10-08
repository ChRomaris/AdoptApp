import React,{ Component } from "react";
import Moment from 'moment';
import {CardHeader, CardBody, CardTitle, CardText, Button, CardFooter,Card} from 'reactstrap';
import PreviewImage from '../../../mainList/components/PreviewImage';
import {FormattedMessage} from 'react-intl'
class LostAnimalCard extends Component{
    constructor(props){
        super()
        this.renderGenre = this.renderGenre.bind(this)
    }
    renderGenre(){
        if(this.props.animal.genre === "MALE" ){
           return <FormattedMessage id='form.enum.male'/>  
        }else if(this.props.animal.genre === "FEMALE"){
           return <FormattedMessage id='form.enum.female'/>  
        }       
    }
    render(){
        
        return(
            <Card>
                <CardHeader>{this.props.animal.name}</CardHeader>
                <CardBody className="cardBody">
                    <div className="picture">
                        <PreviewImage image={this.props.animal.image}/>
                    </div>
                    <div className="texts">
                        <CardTitle><FormattedMessage id='form.label.date'/> : {Moment(this.props.animal.date).format("DD-MM-YY")}</CardTitle>
                        <CardTitle><FormattedMessage id='form.label.genre'/> : {this.renderGenre()} </CardTitle>
                        <CardTitle><FormattedMessage id='form.label.breed'/> : {this.props.animal.breed} </CardTitle>
                        <CardText><FormattedMessage id='form.label.distance'/> : {Math.round(this.props.animal.distance)}</CardText>
                    </div>  
                </CardBody>
                <CardFooter>
                    <Button>Mas Información</Button>
                    <Button>Localizar</Button>
                </CardFooter>
            
            </Card>
        )
    }
}
export default LostAnimalCard