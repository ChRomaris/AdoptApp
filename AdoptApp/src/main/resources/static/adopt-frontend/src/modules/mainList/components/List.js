import React, {Component} from 'react';
import CardConst from '../components/CardConst';
import {ToastsContainer, ToastsStore} from 'react-toasts';
import {Container} from 'reactstrap';
import Moment from 'moment';
import {SideMenu} from '../../app/'


import '../../../styles/MainListStyle.css'


class List extends Component {
    constructor(props){
        super(props);
        this.showForm = this.showForm.bind(this);
        this.formatDate = this.formatDate.bind(this);
    }


    formatDate(date){
        return ( new Intl.DateTimeFormat('en-GB', { 
            year: 'numeric', 
            month: 'long', 
            day: '2-digit' 
        }).format(date) )
    }

    showForm(id){
        console.log("id:" + id)
        this.props.ShowEditingForm(id);
    }

    render (){
    Moment.locale('es');
    
        return(
            <div className="main">
            <SideMenu></SideMenu>
            <Container>
            <ToastsContainer store={ToastsStore}/>
            <div>
            {this.props.animales.map(item => (
                <CardConst  classname="card" showEditingForm={this.showForm}  id = {item.id} name = {item.name} genre = {item.genre} birthDate = {Moment(item.birthDate).fromNow(true)} description = {item.description} key={item.name} image ={item.image} ></CardConst>
            ))}
            </div>

            </Container>
            </div>
        )
    }

}

export default List;