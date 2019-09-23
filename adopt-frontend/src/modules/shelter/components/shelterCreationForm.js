import React ,{ Component }from 'react';
import {Container, Button, Form, FormGroup, Label, Input} from 'reactstrap';
import {addShelter} from '../actions';
import {ToastsContainer, ToastsStore} from 'react-toasts';
import {TopMenu} from '../../app';
import PositionSection from '../../common/PositionSection'


  import 'bootstrap/dist/css/bootstrap.css';
  import '../../../styles/shelter.css'


  

class ShelterCreationForm extends Component{

    constructor(){
        super();
        this.state = {
            id:'',
            name : '',
            email : '',
            type:'Privada',
            phone:'',
            latitude:'',
            longitude:'',
            isEdit:''
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.setLocation = this.setLocation.bind(this);
    }

    handleChange(e) {
        let target = e.target;
        let value = target.type === 'checkbox' ? target.checked : target.value;
        let name = target.name;
        let email = target.email;
        let type = target.type;
        let phone = target.phone;
        let latitude = target.latitude;
        let longitude = target.longitude;

        this.setState({
          [name]: value,
          [email]: email,
          [type]: type,
          [phone]: phone,
          [latitude]: latitude,
          [longitude]: longitude
        });
    }
    
    componentWillReceiveProps(nextProps){
        console.log("Se esta editando en shelterCreationForm :"+ nextProps.shelterId)
        if(nextProps.shelterId !==''){
            this.setState({
                id: nextProps.shelterId
            })
        }
    }



    handleSubmit(e){

        console.log('The form was submitted with the following data:');
        e.preventDefault();

        const shelterCreationData = {
            shelterId: this.state.id,
            name : this.state.name,
            type: this.state.type,
            phoneNumber: this.state.phone,
            email : this.state.email,
            latitude: this.state.latitude,
            longitude: this.state.longitude,
            userToken : sessionStorage.getItem('serviceToken')
        };
        addShelter(shelterCreationData).then(response => 
          {
            ToastsStore.success("Creado Correctamente");
          }  ).catch(error =>{
            ToastsStore.error("Algo ha salido mal");
          })


    }

    printState(){
        console.log(
            "Nombre: "+ this.state.name+
            "\nTelefono: "+ this.state.phone+
            "\nEmail: "+ this.state.email+
            "\nTipo: "+ this.state.type+
            "\nLatitude: "+ this.state.latitude+
            "\nLongitude: "+ this.state.longitude+
            "\nuserToken: "+ sessionStorage.getItem('serviceToken')
        )
    }

    setLocation(lat, long)
    {
        this.setState({
            latitude:lat,
            longitude:long
        },this.printState())
    }

    render(){

        return (
            <div>
            <TopMenu/>
            <Container className="shelterForm">
            <ToastsContainer store={ToastsStore}/>
                <h2>CREAR ASOCIACIÓN</h2>
            <Form onSubmit={this.handleSubmit}>
                <FormGroup>
                    <Label for="exampleName">Nombre</Label>
                    <Input type="text" name="name" id="exampleName" placeholder="Nombre de la asociación" value={this.state.name} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleType">Tipo</Label>
                    <Input type="select" name="type" id="exampleType" placeholder="Tipo de asociación" value={this.state.type } onChange={this.handleChange}>
                        <option>Pública</option>
                        <option>Privada</option>
                    </Input>   
                </FormGroup>
                <FormGroup>
                    <Label for="examplePhone">Teléfono</Label>
                    <Input type="number" name="phone" id="examplePhone" placeholder="Teléfono de la asociación" value={this.state.phone} onChange={this.handleChange}></Input>     
                </FormGroup>
                <FormGroup>
                    <Label for="exampleEmail">Email</Label>
                    <Input type="text" name="email" id="exampleEmail" placeholder="Introducir email" value={this.state.email} onChange={this.handleChange}></Input>     
                </FormGroup>  
                <PositionSection setParentLocation={this.setLocation}></PositionSection>
                    <Button className = "FormButton">Crear</Button>
            </Form>
            
            
            </Container>
            </div>
           
        )
    }

}

export default ShelterCreationForm;
