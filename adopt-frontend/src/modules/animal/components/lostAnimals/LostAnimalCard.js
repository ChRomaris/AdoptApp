import React,{ Component } from "react";
import Moment from 'moment';
import {CardHeader, CardBody, CardTitle, CardText, Button, CardFooter,Card} from 'reactstrap';
import PreviewImage from '../../../mainList/components/PreviewImage';
import {FormattedMessage} from 'react-intl';
import {showModal, getLocations, setAnimal, deleteLost} from './actions/actions';
import {connect} from 'react-redux';

class LostAnimalCard extends Component{
    constructor(props){
        super()
        this.renderGenre = this.renderGenre.bind(this)
        this.renderFooter = this.renderFooter.bind(this)
        this.locationsClick = this.locationsClick.bind(this)
        this.deleteClick = this.deleteClick.bind(this)
        this.moreInfoClick = this.moreInfoClick.bind(this)
    }

    renderGenre(){
        if(this.props.animal.genre === "MALE" ){
           return <FormattedMessage id='form.enum.male'/>  
        }else if(this.props.animal.genre === "FEMALE"){
           return <FormattedMessage id='form.enum.female'/>  
        }       
    }

    locationsClick(animalId){
    const params = {
        animalId :animalId ,
        token : sessionStorage.getItem('serviceToken')
    }   
    
     this.props.getLocations(params)
     this.props.redirectLocations()
     
     
    }

    editClick(animalId){
        this.props.editAnimal(animalId)
        console.log("LostAnimalCard - edit")
    }

    deleteClick(animalId){
        const params = {
            userToken : sessionStorage.getItem('serviceToken'),
            animalId : animalId
        }
        this.props.deleteLost (params)
    }

    moreInfoClick(animalId){
        this.props.showInfo(animalId);
    }

    renderFooter(animalId){
        if (this.props.isUserList){
            return [<Button onClick = {()=>this.editClick(animalId)}>Editar</Button>,<Button onClick = {()=>this.deleteClick(animalId)}>Borrar</Button>,<Button onClick={()=>this.locationsClick(animalId)}>Localizaciones</Button>]

        }else{
            return [<Button onClick = {()=>this.moreInfoClick(animalId)} >Mas Información</Button>,<Button onClick={()=>this.showModal(this.props.animal.id)}>Localizar</Button>]
        }
    }



    showModal (id){
        this.props.showModal(id)
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
                    
                    {this.renderFooter(this.props.animal.id)}
                </CardFooter>
            
            </Card>
        )
    }
}

const mapStateToProps = state =>(console.log(state),{
    selectedAnimal : state.lostAnimals.selectedAnimal,
    showModal : state.lostAnimals.showModal,
    isUserList : state.lostAnimals.isUserList,
    locations : state.lostAnimals.locations
})

export default connect (mapStateToProps, {showModal, getLocations, setAnimal, deleteLost}) (LostAnimalCard)