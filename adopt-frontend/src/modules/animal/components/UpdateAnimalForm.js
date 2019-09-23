import { editAnimal } from '../actions';
import React, {Component} from 'react';
import {ToastsContainer, ToastsStore} from 'react-toasts';
import {Container, Button, Form, FormGroup, Label, Input} from 'reactstrap';
//import FileBase64 from 'react-file-base64';
import { TopMenu } from '../../app';
import {getAnimalInfo} from '../actions';
import {FormattedMessage} from 'react-intl';
class UpdateAnimalForm extends Component{
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
        this.showList = this.showList.bind(this);
        
    }

    componentDidMount(){
        console.log("id edicion :" + this.props.animalId)
       const getAnimalInfoParams = {
           id: this.props.animalId
       }

       getAnimalInfo (getAnimalInfoParams).then(response => {
           this.setState({
               name : response.name,
               genre: response.genre,
               description: response.description,
               birthDate: response.birthDate,
               healthComment: response.healthComment,
               color: response.color,
               size: response.size,
               trained: response.trained,
               state: response.state,

           })
       }).catch(error => {
        ToastsStore.error("fallo recuperando info");
       })

        
    }

    handleChange(e) {
        let target = e.target;
        let value = target.type === 'checkbox' ? target.checked : target.value;
        let name = target.name;

        this.setState({
          [name]: value
        });
    }
    showList(){
        this.props.showList()
    }

    handleSubmit(e){
        console.log('The form was submitted with the following data:');
        e.preventDefault();


        const animalEditionData = {
            id : this.props.animalId,
            name : this.state.name,
            genre : this.state.genre,
            description : this.state.description,
            color : this.state.color,
            size : this.state.size,
            image : this.state.image,
            imageDescription : this.state.imageDescription,
            adoptionAnimalInfoDTO : {
                birthDate : this.state.birthDate,
            },
            userToken : sessionStorage.getItem('serviceToken'),
            health_Comment : this.state.healthComment,
            trained: this.state.trained,
            state : this.state.state
        };

        editAnimal(animalEditionData).then(response => 
          {
            ToastsStore.success("Modificado Correctamente");
            this.showList();
          }  ).catch(error =>{
            ToastsStore.error("Algo ha salido mal");
          })
    }

    getFiles(files){
        this.setState({ image: files[0].base64})
      }

    render(){

        return (
            <div>
            <TopMenu/>
            <Container className="animalForm">
            
            <ToastsContainer store={ToastsStore}/>
                <h2> <FormattedMessage id = "form.tittle.editAnimal" /></h2>
            <Form onSubmit={this.handleSubmit}>
                <FormGroup>
                    <Label for="exampleName"><FormattedMessage id = "form.label.name"/></Label>
                    <Input type="text" name="name" id="exampleName" placeholder="Nombre de la asociación" value={this.state.name || ''} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleEmail"><FormattedMessage id = "form.label.genre"/></Label>
                    <Input type="text" name="genre" id="exampleGenre" placeholder="Introducir Genero" value={this.state.genre || ''} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleDescription"><FormattedMessage id = "form.label.description" /></Label>
                    <Input type="text" name="description" id="exampleDescription" placeholder="Introducir Descripción" value={this.state.description || ''} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleBirthDate"><FormattedMessage id = "form.lalel.birthDate" /></Label>
                    <Input type="date" name="birthDate" id="exampleBirthDate" placeholder="Introducir Fecha de nacimiento" value={this.state.birthDate || ''} onChange={this.handleChange}></Input>     
                </FormGroup> 
                <FormGroup>
                    <Label for="exampleHealthComment"><FormattedMessage id = "form.lalel.healthComment" /></Label>
                    <Input type="text" name="healthComment" id="exampleHealthComment" placeholder="Introducir Comentario sobre salud" value={this.state.healthComment || ''} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleColor"><FormattedMessage id = "form.lalel.color" /></Label>
                    <Input type="text" name="color" id="exampleColor" placeholder="Introducir Color" value={this.state.color || ''} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleSize"><FormattedMessage id = "form.lalel.size" /></Label>
                    <Input type="text" name="size" id="exampleSize" placeholder="Introducir Tamaño" value={this.state.size || ''} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleTrained"><FormattedMessage id = "form.lalel.trained" /></Label>
                    <Input type="checkbox" name="trained" id="exampleTrained" placeholder="Esta entrenado" value={this.state.trained || ''} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleState"><FormattedMessage id = "form.label.adoptionState" /></Label>
                    <Input type="text" name="state" id="exampleState" placeholder="Introducir Estado" value={this.state.state || ''} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleImage"><FormattedMessage id = "form.lalel.image" /></Label>
                 { /*<FileBase64 multiple={ true } onDone={ this.getFiles.bind(this) } /> */}
                </FormGroup>
                <FormGroup>
                    <Label for="exampleImageDescription"><FormattedMessage id = "form.lalel.imageDescription" /></Label>
                    <Input type="text" name="imageDescription" id="exampleImageDescription" placeholder="Introducir Descripcion de la imagen" value={this.state.imageDescription || ''} onChange={this.handleChange}></Input>     
                </FormGroup>
                    <Button><FormattedMessage id = "form.button.updateInfo" /></Button>
            </Form>
            </Container>
            </div>
           
        )
    }

}

export default UpdateAnimalForm;