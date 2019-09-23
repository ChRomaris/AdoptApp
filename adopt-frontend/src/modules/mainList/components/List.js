import React, { Component } from 'react';
import CardConst from '../components/CardConst';
import { ToastsContainer, ToastsStore } from 'react-toasts';
import { Container } from 'reactstrap';
import { TopMenu } from '../../app/'


import '../../../styles/MainListStyle.css'


class List extends Component {
    constructor(props) {
        super(props);
        this.showForm = this.showForm.bind(this);
        this.formatDate = this.formatDate.bind(this);
        
    }


    formatDate(date) {
        return (new Intl.DateTimeFormat('en-GB', {
            year: 'numeric',
            month: 'long',
            day: '2-digit'
        }).format(date))
    }

    showForm(id) {
        console.log("id:" + id)
        this.props.showEditingForm(id);
    }


    render() {
        
        console.log( this.props);
        return (
            <div>
            <TopMenu></TopMenu>
            <div className="Main">
                <Container>
                    <ToastsContainer store={ToastsStore} />
                    <div>
                        {this.props.animales.map(item => (
                            <CardConst classname="card" showEditingForm={this.showForm} animal={item} key={item.name} deleteAnimal = {this.props.deleteAnimal} showButtons = {this.props.showButtons}  ></CardConst>
                        ))}
                    </div>

                </Container>
            </div>
            </div>
        )
    }

}

export default List;