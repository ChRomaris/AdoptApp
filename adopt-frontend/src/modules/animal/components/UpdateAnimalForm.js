import { editAnimal } from '../actions';
import React, {Component} from 'react';
import {ToastsContainer, ToastsStore} from 'react-toasts';
import {Container, Button, Form, FormGroup, Label, Input} from 'reactstrap';
//import FileBase64 from 'react-file-base64';
import { TopMenu } from '../../app';
import {getAnimalInfo} from '../actions';
import {FormattedMessage} from 'react-intl';
import {connect} from 'react-redux';
import {getAnimalEnums} from '../actions/actions';

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
       console.log("Formulario de edicion montado")
       this.props.getAnimalEnums();
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
     
        console.log("render de formulario")
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
                    <Label for="exampleBreed"><FormattedMessage id='form.label.breed'/></Label>
                    <Input type="select" name="breed" id="exampleBreed"  value={this.state.breed} onChange={this.handleChange}>
                        {this.props.enumValues.breeds.map(breed => {
                            return <option key = {breed}>{breed.name}</option>
                        })}
                    </Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleEmail"><FormattedMessage id='form.label.genre'/></Label>
                    <Input type="select" name="genre" id="exampleGenre"  value={this.state.genre} onChange={this.handleChange}>
                    {this.props.enumValues.genres.map(genre => {
                            return <option key = {genre}>{genre}</option>
                        })}   
                    </Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleDescription"><FormattedMessage id = "form.label.description" /></Label>
                    <Input type="text" name="description" id="exampleDescription" placeholder="Introducir Descripción" value={this.state.description || ''} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleBirthDate"><FormattedMessage id = "form.label.birthDate" /></Label>
                    <Input type="date" name="birthDate" id="exampleBirthDate" placeholder="Introducir Fecha de nacimiento" value={this.state.birthDate || ''} onChange={this.handleChange}></Input>     
                </FormGroup> 
                <FormGroup>
                    <Label for="exampleHealthComment"><FormattedMessage id = "form.label.healthComment" /></Label>
                    <Input type="text" name="healthComment" id="exampleHealthComment" placeholder="Introducir Comentario sobre salud" value={this.state.healthComment || ''} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleColor"><FormattedMessage id='form.label.color'/></Label>
                    <Input type="select" name="color" id="exampleColor"  value={this.state.color} onChange={this.handleChange}>
                    {this.props.enumValues.colors.map(color => {
                            return <option key = {color}>{color}</option>
                        })}
                    </Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleSize"><FormattedMessage id='form.label.size'/></Label>
                    <Input type="select" name="size" id="exampleSize"  value={this.state.size } onChange={this.handleChange}>

                    {this.props.enumValues.sizes.map(size => {
                            return <option key = {size}>{size}</option>
                        })}
                    </Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleTrained" className="trainedLabel"><FormattedMessage id = "form.label.trained" /></Label>
                    <Input type="checkbox" name="trained" id="exampleTrained" placeholder="Esta entrenado" value={this.state.trained || ''} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleState"><FormattedMessage id='form.label.adoptionState'/></Label>
                    <Input type="select" name="state" id="exampleState"  value={this.state.state } onChange={this.handleChange}>

                    {this.props.enumValues.adoptionStates.map(state => {
                            return <option key = {state}>{state}</option>
                        })}
                    </Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleImage"><FormattedMessage id = "form.label.image" /></Label>
                 { /*<FileBase64 multiple={ true } onDone={ this.getFiles.bind(this) } /> */}
                </FormGroup>
                <FormGroup>
                    <Label for="exampleImageDescription"><FormattedMessage id = "form.label.imageDescription" /></Label>
                    <Input type="text" name="imageDescription" id="exampleImageDescription" placeholder="Introducir Descripcion de la imagen" value={this.state.imageDescription || ''} onChange={this.handleChange}></Input>     
                </FormGroup>
                    <Button><FormattedMessage id = "form.button.updateInfo" /></Button>
            </Form>
            </Container>
            </div>
           
        )
    }

}

const mapStateToProps = state => (console.log(state),{
    enumValues : state.animal.animalSelectorValues
})

export default connect(mapStateToProps, {getAnimalEnums})(UpdateAnimalForm);