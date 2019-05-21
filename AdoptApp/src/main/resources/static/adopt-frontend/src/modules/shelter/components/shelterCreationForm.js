import React ,{ Component }from 'react';
import {Container, Button, Form, FormGroup, Label, Input} from 'reactstrap';
import {addShelter} from '../actions';
import {ToastsContainer, ToastsStore} from 'react-toasts';


  import 'bootstrap/dist/css/bootstrap.css';
  import '../../../styles/shelter.css'


  

class shelterCreationForm extends Component{

    constructor(){
        super();
        this.state = {
            name : '',
            email : ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(e) {
        let target = e.target;
        let value = target.type === 'checkbox' ? target.checked : target.value;
        let name = target.name;
        let email = target.email;

        this.setState({
          [name]: value,
          [email]: value
        });
    }



    handleSubmit(e){

        console.log('The form was submitted with the following data:');
        e.preventDefault();

        const shelterCreationData = {
            name : this.state.name,
            email : this.state.email
        };
        addShelter(shelterCreationData).then(response => 
          {
            ToastsStore.success("Creado Correctamente");
          }  ).catch(error =>{
            ToastsStore.error("Algo ha salido mal");
          })


    }

    render(){

        return (
                
            <Container className="shelterForm">
            <ToastsContainer store={ToastsStore}/>
                <h2>CREAR ASOCIACIÓN</h2>
            <Form onSubmit={this.handleSubmit}>
                <FormGroup>
                    <Label for="exampleName">Nombre</Label>
                    <Input type="text" name="name" id="exampleName" placeholder="Nombre de la asociación" value={this.state.name} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleEmail">Email</Label>
                    <Input type="email" name="email" id="exampleEmail" placeholder="Introducir email" value={this.state.email} onChange={this.handleChange}></Input>     
                </FormGroup>   
                    <Button>Crear</Button>
            </Form>
            </Container>
           
        )
    }

}

export default shelterCreationForm;
