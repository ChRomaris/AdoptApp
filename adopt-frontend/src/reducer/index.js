import {combineReducers} from 'redux';
import lostAnimalReducer from '../modules/animal/components/lostAnimals/reducer/lostAnimalReducer';
import userReducer from '../modules/user/reducer/userReducer'

export default combineReducers ({
    lostAnimals: lostAnimalReducer,
    user: userReducer
    
}); 