import React, {Component} from 'react';
import {addAnimal} from '../actions';
import {ToastsContainer, ToastsStore} from 'react-toasts';
import {Container, Button, Form, FormGroup, Label, Input} from 'reactstrap';
import FileBase64 from 'react-file-base64';
import Header from '../../app/components/Header';

class AnimalCreationForm extends Component{

   constructor(){
        super();
        this.state={
            name : '',
            genre : '',
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
        console.log(this.state.image);
        console.log(this.state.name);
      }

    handleSubmit(e){
        console.log('The form was submitted with the following data:');
        e.preventDefault();


        const animalCreationData = {
            name : this.state.name,
            genre : this.state.email,
            description : this.state.description,
            birthDate : this.state.birthDate,
            health_Comment : this.state.healthComment,
            color : this.state.color,
            size : this.state.size,
            trained: this.state.trained,
            state : this.state.state,
            image : this.state.image,
            imageDescription : this.state.imageDescription
            
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
            
            <Container className="animalForm">
            <Header/>
            <ToastsContainer store={ToastsStore}/>
                <h2>AÑADIR ANIMAL</h2>
            <Form onSubmit={this.handleSubmit}>
                <FormGroup>
                    <Label for="exampleName">Nombre</Label>
                    <Input type="text" name="name" id="exampleName" placeholder="Nombre de la asociación" value={this.state.name} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleEmail">Genero</Label>
                    <Input type="text" name="genre" id="exampleGenre" placeholder="Introducir Genero" value={this.state.genre} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleDescription">Descripción</Label>
                    <Input type="text" name="description" id="exampleDescription" placeholder="Introducir Descripción" value={this.state.description} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleBirthDate">Fecha de nacimiento</Label>
                    <Input type="date" name="birthDate" id="exampleBirthDate" placeholder="Introducir Fecha de nacimiento" value={this.state.birthDate} onChange={this.handleChange}></Input>     
                </FormGroup> 
                <FormGroup>
                    <Label for="exampleHealthComment">Comentario sobre salud</Label>
                    <Input type="text" name="healthComment" id="exampleHealthComment" placeholder="Introducir Comentario sobre salud" value={this.state.healthComment} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleColor">Color</Label>
                    <Input type="text" name="color" id="exampleColor" placeholder="Introducir Color" value={this.state.color} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleSize">Tamaño</Label>
                    <Input type="text" name="size" id="exampleSize" placeholder="Introducir Tamaño" value={this.state.size} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleTrained">Entrenado</Label>
                    <Input type="checkbox" name="trained" id="exampleTrained" placeholder="Esta entrenado" value={this.state.trained} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleState">Estado de la adopción</Label>
                    <Input type="text" name="state" id="exampleState" placeholder="Introducir Estado" value={this.state.state} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleImage">Imagen</Label>
                    <FileBase64 multiple={ true } onDone={ this.getFiles.bind(this) } />
                </FormGroup>
                <FormGroup>
                    <Label for="exampleImageDescription">Descripción de imagen</Label>
                    <Input type="text" name="imageDescription" id="exampleImageDescription" placeholder="Introducir Descripcion de la imagen" value={this.state.imageDescription} onChange={this.handleChange}></Input>     
                </FormGroup>
                    <Button>Añadir</Button>
            </Form>
            </Container>
           
        )
    }
}
export default AnimalCreationForm;