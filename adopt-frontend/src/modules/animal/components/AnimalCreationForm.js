import React, {Component} from 'react';
import {addAnimal} from '../actions';
import {ToastsContainer, ToastsStore} from 'react-toasts';
import {Container, Button, Form, FormGroup, Label, Input} from 'reactstrap';
import FileBase64 from 'react-file-base64';
import { TopMenu } from '../../app';
import {FormattedMessage} from 'react-intl'


class AnimalCreationForm extends Component{

   constructor(){
        super();
        this.state={
            name : '',
            genre : '',
            breed: '',
            description: '',
            birthDate: '',
            healthComment: '',
            color: '',
            size: '',
            trained: '',
            state: '',
            image: '',
            imageDescription: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        
    }

    handleChange(e){

    
       
        let target = e.target;
        let value = target.type === 'checkbox' ? target.checked : target.value;
        let name = target.name;
        let genre = target.genre;
        let breed = target.breed;
        let description = target.description;
        let birthDate = target.birthDate;
        let healthComment = target.healthComment;
        let color = target.color;
        let size = target.size;
        let trained = target.trained;
        let state = target.state;
        let image = target.image;
        let imageDescription = target.imageDescription

        this.setState({
          [name]: value,
          [genre]: value,
          [breed]: value,
          [description] : value,
          [birthDate] : value,
          [healthComment] : value,
          [color] : value,
          [size] : value,
          [trained] : value,
          [state] : value,
          [image] : value,
          [imageDescription]: value
        });
    }

    getFiles(files){
        this.setState({ image: files[0].base64})
      }

    handleSubmit(e){
        console.log('The form was submitted with the following data:');
        e.preventDefault();


        const animalCreationData = {
            name : this.state.name,
            genre : this.state.genre,
            breed : this.state.breed,
            description : this.state.description,
            color : this.state.color,
            size : this.state.size,
            image : this.state.image,
            imageDescription : this.state.imageDescription,
            userToken : sessionStorage.getItem('serviceToken'),
            adoptionAnimalInfoDTO : {
                birthDate : this.state.birthDate,
                health_Comment : this.state.healthComment,
                trained: this.state.trained,
                state : this.state.state,
            }  
        };
        addAnimal(animalCreationData).then(response => 
          {
            ToastsStore.success("Creado Correctamente");
          }  ).catch(error =>{
            ToastsStore.error("Algo ha salido mal");
          })
    }


    render(){

        return (
            <div>
            <TopMenu/>
            <div className ="animalFormPage">
            <Container className="animalForm">
            
            <ToastsContainer store={ToastsStore}/>
                <h2><FormattedMessage id='form.tittle.addAnimal'/></h2>
            <Form onSubmit={this.handleSubmit}>
                <FormGroup>
                    <Label for="exampleName"><FormattedMessage id='form.label.name'/></Label>
        <Input type="text" name="name" id="exampleName"  value={this.state.name} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleBreed"><FormattedMessage id='form.label.breed'/></Label>
                    <Input type="text" name="breed" id="exampleBreed"  value={this.state.breed} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleEmail"><FormattedMessage id='form.label.genre'/></Label>
                    <Input type="text" name="genre" id="exampleGenre"  value={this.state.genre} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleDescription"><FormattedMessage id='form.label.description'/></Label>
                    <Input type="text" name="description" id="exampleDescription"  value={this.state.description} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleBirthDate"><FormattedMessage id='form.label.birthDate'/></Label>
                    <Input type="date" name="birthDate" id="exampleBirthDate"  value={this.state.birthDate} onChange={this.handleChange}></Input>     
                </FormGroup> 
                <FormGroup>
                    <Label for="exampleHealthComment"><FormattedMessage id='form.label.healthComment'/></Label>
                    <Input type="text" name="healthComment" id="exampleHealthComment"  value={this.state.healthComment} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleColor"><FormattedMessage id='form.label.color'/></Label>
                    <Input type="text" name="color" id="exampleColor"  value={this.state.color} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleSize"><FormattedMessage id='form.label.size'/></Label>
                    <Input type="text" name="size" id="exampleSize"  value={this.state.size} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleTrained"><FormattedMessage id='form.label.trained'/></Label>
                    <Input type="checkbox" name="trained" id="exampleTrained"  value={this.state.trained} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleState"><FormattedMessage id='form.label.adoptionState'/></Label>
                    <Input type="text" name="state" id="exampleState"  value={this.state.state} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleImage"><FormattedMessage id='form.label.image'/></Label>
                    <FileBase64 multiple={ true } onDone={ this.getFiles.bind(this) } />
                </FormGroup>
                <FormGroup>
                    <Label for="exampleImageDescription"><FormattedMessage id='form.label.imageDescription'/></Label>
                    <Input type="text" name="imageDescription" id="exampleImageDescription"  value={this.state.imageDescription} onChange={this.handleChange}></Input>     
                </FormGroup>
                    <Button><FormattedMessage id='form.button.add'/></Button>
            </Form>
            </Container>
            </div>
            </div>
           
        )
    }
}
export default AnimalCreationForm;