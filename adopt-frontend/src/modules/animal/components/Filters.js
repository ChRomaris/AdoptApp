import React, { Component } from "react";
import '../styles/filter.css';
import {FormattedMessage} from 'react-intl';
import {  Input } from 'reactstrap';
import {getFilterValues} from '../actions'

class Filters extends Component{
constructor(props){
    super(props);
    this.state = {
        breeds : [],
        colors : [],
        genres : [],
        sizes : [],
        breed : '',
        color : '',
        genre : '',
        size : ''
    }

    this.breedSelector = React.createRef();

    this.handleChange = this.handleChange.bind(this);
    this.filter = this.filter.bind(this);
    this.showGenre = this.showGenre.bind(this);
    this.showSize = this.showSize.bind(this);
    this.castGenre = this.castGenre.bind(this);
    this.castSize = this.castSize.bind(this);

}

componentDidMount(){
  getFilterValues().then(response=>{
    this.setState({ 
      breeds : response.breeds,
      colors: response.colors,
      genres: response.genres,
      sizes: response.sizes
    })
  })
}

filter(){
    console.log(this.breedSelector.current)
    const filters = {
      breed : this.state.breed,
      color : this.state.color,
      genre : this.castGenre(),
      size  : this.castSize()
    }

    this.props.filter(filters)
}

handleChange(e){
  let target = e.target;
  let value  = target.value;
  let breed  = target.breed;
  let color  = target.color;
  let genre  = target.genre;
  let size   = target.size;

  this.setState({
    [breed] : value,
    [color] : value,
    [genre] : value,
    [size]  : value 
  },()=>console.log(this.state)) 
}

castGenre (){
  if(this.state.genre === "Macho"){
    return "MALE"
  }else{
    return "FEMALE"
  }
}

castSize (){
  if(this.state.size === "Pequeño"){
    return "SMALL"
    }else if (this.state.size === "Mediano"){
      return "MEDIUM"
    }else{
      return "BIG"
    }
}

showGenre (genre){
  if(genre === "MALE"){
  return "Macho"
  }else{
    return "Femia"
  }
}

showSize (size){
  if(size === "SMALL"){
  return "Pequeño"
  }else if (size === "MEDIUM"){
    return "Medio"
  }else{
    return "Grande"
  }
}



render(){

    return(
        <div className = "filterContainer">
            <div className="filterGroup">
             <div className="singleFilter">
                 <div className = "filterLabel">
                  <label ><FormattedMessage id ="form.label.breed"/></label>
                 </div>
                 <div className="filterField">
                 <div className = "filterValue">
                 <select  value = {this.state.breed} onChange={this.handleChange} >
                  {this.state.breeds.map(breed=>(<option key={breed} value={breed} >{breed}</option>))}
                </select >
                  </div>
                </div>
                </div>
             <div className="singleFilter">
             <div className = "filterLabel">
             <label><FormattedMessage id ="form.label.color"/></label>
             </div>
             <div className="filterField">
             <div className = "filterValue">
             <select type="select" name="color" id="color"  onChange={this.handleChangeColor} >
                  {this.state.colors.map(color=>(<option key={color}>{color}</option>))}
                     </select>
                  </div>
                </div>
              </div>
                <div className="singleFilter">
                <div className = "filterLabel">
                <label><FormattedMessage id ="form.label.genre"/></label>
                </div>
                <div className="filterField">
                <div className = "filterValue">
                    <Input type="select" name="genre" id="genre"  onChange={this.handleChangeGenre} >
                      {this.state.genres.map(genre=>(<option key={genre}>{this.showGenre(genre)}</option>))}
                     </Input>
                  </div>
                </div>
              </div>
            <div className="singleFilter">
            <div className = "filterLabel">
            <label><FormattedMessage id ="form.label.size"/></label>
            </div>
            <div className="filterField">
            <div className = "filterValue">
            <Input type="select" name="size" id="size"  onChange={this.handleChangeSize} >
                  {this.state.sizes.map(size=>(<option key={size}>{this.showSize(size)}</option>))}
                     </Input>
                  </div>
                </div>
                </div>
              </div>
              <div className ="filterButton" onClick={this.filter}>
                <span><FormattedMessage id = "form.button.filter"/></span>
              </div>
           </div>
    )
}
}

export default Filters;