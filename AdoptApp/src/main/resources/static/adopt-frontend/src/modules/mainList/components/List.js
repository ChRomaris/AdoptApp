import React, {Component} from 'react';
import CardConst from '../components/CardConst';
import {getAllAdoptionAnimals} from '../actions'
import {ToastsContainer, ToastsStore} from 'react-toasts';
import {Container} from 'reactstrap';
import Moment from 'moment';
import Header from '../../app/components/Header'

import '../../../styles/MainListStyle.css'


class List extends Component {
    constructor(props){
        super();
        this.state = {
            animals : []
        }

        this.formatDate = this.formatDate.bind(this);
    }


    componentDidMount(){
        getAllAdoptionAnimals().then( data =>  {
            this.setState({
                animals : data
            })
            ToastsStore.success("Todo correcto");
        }).catch(error => {
            
               ToastsStore.error("Error al recuperar la informacion");
        });
    }

    formatDate(date){
        return ( new Intl.DateTimeFormat('en-GB', { 
            year: 'numeric', 
            month: 'long', 
            day: '2-digit' 
        }).format(date) )
    }

    render (){
    Moment.locale('es');
        return(
            <Container >
            <Header/>
            <ToastsContainer store={ToastsStore}/>
            <div>
            {this.state.animals.map(item => (
                <CardConst classname="card" name = {item.name} genre = {item.genre} birthDate = {Moment(item.birthDate).fromNow(true)} description = {item.description} key={item.name} image ={item.image} ></CardConst>
            ))}
    </div>
            </Container>
        )
    }

}

export default List;