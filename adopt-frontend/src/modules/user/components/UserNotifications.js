import React,{Component} from 'react'
import UserTopMenu from './UserTopMenu';
import Notification from '../../common/Notification';
class UserNotifications extends Component{
constructor(props){
    super(props)

    this.adoptionAnimalInfo = this.adoptionAnimalInfo.bind(this);
    this.lostAnimalInfo = this.lostAnimalInfo.bind(this);
}
    adoptionAnimalInfo(animalId){
        this.props.history.replace('/adoption/'+animalId)
    }

    lostAnimalInfo(animalId){
        this.props.history.replace('/lost/'+animalId)
    }


    render(){
        return(
            <div className ="userNotifications Section">
                <UserTopMenu></UserTopMenu>
                <Notification lostAnimalInfo={this.lostAnimalInfo} adoptionAnimalInfo = {this.adoptionAnimalInfo}></Notification>
            </div>
        )
    }
}

export default UserNotifications