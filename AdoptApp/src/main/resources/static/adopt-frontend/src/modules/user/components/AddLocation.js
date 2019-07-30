import React, {Component} from 'react';
import { Link } from 'react-router-dom';
import AddLocationMap from './AddLocationMap'

import '../../../styles/userStyles.css'

class AddLocation extends Component {
    constructor(){
        super()
        this.state={
            latitude:'',
            longitude:''
        }
    }

    render(){
        return(
            <div className="addLocationComplete">
            <p>
                Para una mejor experiencia recomendamos que añada su ubicación:
            </p>
             <div className="addLocationMainSection">
                 <AddLocationMap></AddLocationMap>
                 <form className="FormFields">
                        <div className="FormField">
                            <div className="buttonSection">
                                <button type ="submit" className="FormField__Button mr-20">Añadir Localización</button>
                                <Link to="/List" className="FormField__Link">Continuar sin añadir</Link>
                           </div>
                     </div>
                    </form>
                </div>
            </div>

        )
    }
}

export default AddLocation;