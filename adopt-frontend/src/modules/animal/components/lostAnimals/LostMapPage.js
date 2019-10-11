import React,{ Component } from "react";
import {connect} from 'react-redux';
import {getAnimals} from './actions/actions';
import MarkerMapMain from '../../../common/MarkerMapMain';
import TopMenu from '../../../app/components/TopMenu';


class LostMapPage extends Component{

    componentDidMount (){
        this.props.getAnimals()
    }

    render(){
        return(
            <div>
                <TopMenu/>
                <MarkerMapMain toggleModal ="" markers={this.props.animals}></MarkerMapMain>
            </div>
        )
    }

}

const mapStateToProps = state => ({
    animals :  state.lostAnimals.animals
})

export default connect (mapStateToProps, {getAnimals})(LostMapPage) ;