import React,{ Component } from "react";
import {Input, Label, Button} from 'reactstrap';
import {getTypes} from '../animal/actions';
import '../animal/components/styles/styles.css'

class Filter extends Component{
    constructor(){
        super()
        this.state = {
            AnimalType: null,
            breed: null,
            genre: null,
            color: null,
            size : null,
            animalTypes:[],
            breeds : [],
            genres : [],
            colors : [],
            sizes : []
        }

        this.handleChange = this.handleChange.bind(this);
        this.handleFilter = this.handleFilter.bind(this);
        this.fillTypes = this.fillTypes.bind(this);
    }

    componentDidMount(){
        this.fillTypes()
    }

    fillTypes(){
        getTypes(this.state.type).then(response=>{
            this.setState({
                animalTypes : response.animalTypes,
                breeds : response.breeds,
                genres : response.genres,
                colors : response.colors,
                sizes : response.sizes,
                states : response.adoptionStates
            })
        })
    }

    refreshBreeds(type){
        getTypes(type).then(response=>{
            this.setState({
                breeds : response.breeds

            })
        })
    }

    handleChange (event){
        let target = event.target
        let value = target.value
        console.log("Algo ha cambiado" + value)
        this.setState ({
            [target.name] : value,
        })

        if(target.name === "animalType"){
            if(target.value === "Todos"){
                this.refreshBreeds(null)
            }else{
                this.refreshBreeds(target.value)
            }
        }
        

        
    }





    handleFilter(){
        const filter = {
            animalType: this.state.animalType,
            breed: this.state.breed,
            genre: this.state.genre,
            color: this.state.color,
            size: this.state.size

        }

        if(filter.animalType == 'Todos'){
            filter.animalType = null
        }
        
        if(filter.breed == 'Todos'){
            filter.breed = null
        }
        if(filter.genre == 'Todos'){
            filter.genre = null
        }
        if(filter.color == 'Todos'){
            filter.color = null
        }
        if(filter.size == 'Todos'){
            filter.size = null
        }

        
        this.props.handleFilter(filter)
    }

    render(){
        return(
            <div className="filterContainer">
                <h5>Filtrar por:</h5>
                <Label for="animalType" className = "animalType">Tipo de animal:</Label>
                <Input type="select" name="animalType" id="animalType"  value={this.state.animalType} onChange={this.handleChange} className = "filterInput">
                    <option>Todos</option>
                    {this.state.animalTypes.map(animalType => {
                            return <option key = {animalType.name}>{animalType.name}</option>
                        })}
                </Input>
                <Label for="breed" className = "filterLabel">Raza:</Label>
                <Input type="select" name="breed" id="breed"  value={this.state.breed} onChange={this.handleChange} className = "filterInput">
                    <option>Todos</option>
                    {this.state.breeds.map(breed => {
                            return <option key = {breed.name}>{breed.name}</option>
                        })}
                </Input>
                <Label for="genre" className = "filterLabel" >Genero:</Label>
                <Input type="select" name="genre" id="genre"  value={this.state.genre} onChange={this.handleChange} className = "filterInput">
                    <option>Todos</option>
                    {this.state.genres.map(genre => {
                            return <option key = {genre}>{genre}</option>
                        })}
                </Input>
                <Label for="color" className = "filterLabel" >Color:</Label>
                <Input type="select" name="color" id="color"  value={this.state.color} onChange={this.handleChange} >
                    <option>Todos</option>
                    {this.state.colors.map(color => {
                            return <option key = {color}>{color}</option>
                        })}
                </Input>
                <Label for="size" className = "filterLabel">Tamaño:</Label>
                <Input type="select" name="size" id="size"  value={this.state.size} onChange={this.handleChange} className = "filterInput">
                    <option>Todos</option>
                    {this.state.sizes.map(size => {
                            return <option key = {size}>{size}</option>
                        })}
                </Input>
                <Button className = "filterButton" onClick={this.handleFilter}>Filtrar</Button>
        </div>
        )
        
    }
}

export default Filter;