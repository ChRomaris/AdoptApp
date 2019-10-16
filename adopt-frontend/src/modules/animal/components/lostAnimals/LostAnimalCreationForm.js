import React,{Component} from 'react';
import {ToastsContainer, ToastsStore} from 'react-toasts';
import {Container, Button, Form, FormGroup, Label, Input,FormText} from 'reactstrap';
import { TopMenu } from '../../../app';
import {FormattedMessage} from 'react-intl'
import {getTypes} from '../../actions'
import {addLostAnimal, getLostAnimalInfo} from '../../actions'
import {resetAnimal} from './actions/actions'
import PositionSection from '../../../common/PositionSection'
import "react-datepicker/dist/react-datepicker.css";
import "../animalStyles.css"
import FileBase64 from 'react-file-base64';
import {connect} from 'react-redux';

class LostAnimalCreationForm extends Component {
    constructor(){
        super();
        this.state = {
            breeds:[],
            genres:[],
            colors:[],
            sizes:[],
            id : null,
            latitude : '',
            longitude : '',
            name : '',
            breed : '',
            genre : '',
            description: '',
            color : '',
            size : '',
            date : '',
            image : null,
            imageDescription: '',
            comment : ''
        }

        this.fillTypes = this.fillTypes.bind(this)
        this.setPosition = this.setPosition.bind(this)
        this.handleChange = this.handleChange.bind(this)
        this.setDefaultValues = this.setDefaultValues.bind(this)
        this.handleSubmit  = this.handleSubmit.bind(this)
    }

    componentDidMount(){
        this.fillTypes()
        this.setDefaultValues()
    }

    fillTypes(){
        getTypes().then(response=>{
            this.setState({
                breeds : response.breeds,
                genres : response.genres,
                colors : response.colors,
                sizes : response.sizes
            },()=>this.setDefaultValues())
        })
    }

    setDefaultValues(){
        this.setState ({
            breed:this.state.breeds[0],
            genre:this.state.genres[0],
            color:this.state.colors[0],
            size:this.state.sizes[0]
        })
    }

    handleChange (event){
        let target = event.target
        let value = target.value
        this.setState ({
            [target.name] : value,
        })
        
    }

    handleSubmit(event){
        event.preventDefault();
        const params = {
            id   : this.state.id,
            name : this.state.name,
            breed : this.state.breed,
            genre : this.state.genre,
            description : this.state.description,
            color : this.state.color,
            size : this.state.size,
            image : this.state.image,
            imageDescription : this.state.imageDescription,
            lostAnimalInfoDTO : {
                latitude : this.state.latitude,
                longitude : this.state.longitude,
                state : 'LOST',
                dateTime : this.state.date,
                comment : this.state.comment
            },
            userToken : sessionStorage.getItem('serviceToken')    
        }
        
        console.log(params)
        addLostAnimal(params).then(response=>{
            ToastsStore.success("Añadido Correctamente");
            this.props.history.replace("/user/animals")
        }).catch(error=>{
            console.log(error)
        })
    }

    setPosition(latitude, longitude){
        console.log(latitude)
        console.log(longitude)
        this.setState({
            latitude : latitude,
            longitude : longitude
        })
    }


    getFiles(files){
        this.setState({ image: files[0].base64})
      }




    render(){
        console.log("Estado renderizado")
        console.log(this.state)
        return(
            <div>
            <TopMenu></TopMenu>
    
            <div className ="animalFormPage">
            <PositionSection className = "positionSection" setParentLocation = {this.setPosition} ></PositionSection>
            <Container className="animalForm">
            <ToastsContainer store={ToastsStore}/>
                <h2><FormattedMessage id='form.tittle.addLostAnimal'/></h2>
            <Form onSubmit={this.handleSubmit}>
                <FormGroup>
                    <Label for="exampleName" className ="formLabel"><FormattedMessage id='form.label.name'/></Label>
                    <Input type="text" name="name" id="exampleName"  value={this.state.name || ''} onChange={this.handleChange}   ></Input>   
                    
                </FormGroup>
                <FormGroup>
                    <Label for="exampleBreed"><FormattedMessage id='form.label.breed'/></Label>
                    <Input type="select" name="breed" id="exampleBreed"  value={this.state.breed } onChange={this.handleChange}>
                        {this.state.breeds.map(breed => {
                            return <option key = {breed}>{breed}</option>
                        })}
                    </Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleEmail"><FormattedMessage id='form.label.genre'/></Label>
                    <Input type="select" name="genre" id="exampleGenre"  value={this.state.genre} onChange={this.handleChange}>
                    {this.state.genres.map(genre => {
                            return <option key = {genre}>{genre}</option>
                        })}   
                    </Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="description"><FormattedMessage id='form.label.description'/></Label>
                    <Input type="text" name="description" id="description"  value={this.state.description || ''} onChange={this.handleChange}></Input>  
                    <FormText><FormattedMessage id='form.text.description'/></FormText>   
                </FormGroup>
                <FormGroup>
                    <Label for="exampleColor"><FormattedMessage id='form.label.color'/></Label>
                    <Input type="select" name="color" id="exampleColor"  value={this.state.color} onChange={this.handleChange}>
                    {this.state.colors.map(color => {
                            return <option key = {color}>{color}</option>
                        })}
                    </Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleSize"><FormattedMessage id='form.label.size'/></Label>
                    <Input type="select" name="size" id="exampleSize"  value={this.state.size } onChange={this.handleChange}>

                    {this.state.sizes.map(size => {
                            return <option key = {size}>{size}</option>
                        })}
                    </Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="date"><FormattedMessage id='form.label.lostDateTime'/></Label>{"\n"}
                    <Input type="date" name="date" id="date" value ={this.state.date || ''} onChange={this.handleChange} />
                    <FormText><FormattedMessage id='form.text.date'/></FormText>
                </FormGroup>
                <FormGroup>
                    <p className="file64Label"><FormattedMessage id='form.label.image'/></p>
                    <FileBase64 className="base64Input" multiple={ true } onDone={ this.getFiles.bind(this) } />
                </FormGroup>
                <FormGroup>
                    <Label for="imageDescription"><FormattedMessage id='form.label.imageDescription'/></Label>
                    <Input type="text" name="imageDescription" id="imageDescription"  value={this.state.imageDescription || ''} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="comment"><FormattedMessage id='form.label.comment'/></Label>
                    <Input type="textarea" name="comment" id="comment" value = {this.state.comment || ''} onChange={this.handleChange}/>
                    </FormGroup>
                    <Button><FormattedMessage id='form.button.add'/></Button>
            </Form>
            </Container>
            </div>
            </div>
    )
    }
}


const mapStateToProps  = state => ({
    animalId : state.lostAnimals.selectedAnimal.id,
    isUserList : state.lostAnimals.isUserList
})


export default connect(mapStateToProps, {resetAnimal})(LostAnimalCreationForm);