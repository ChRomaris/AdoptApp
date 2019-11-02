import {combineReducers} from 'redux';
import lostAnimalReducer from '../modules/animal/components/lostAnimals/reducer/lostAnimalReducer';
import userReducer from '../modules/user/reducer/userReducer';
import appReducer from '../modules/app/reducer/appReducer';
import animalReducer from '../modules/animal/reducer/animalReducer'

export default combineReducers ({
    lostAnimals: lostAnimalReducer,
    user: userReducer,
    app : appReducer,
    animal : animalReducer
    
}); 