import {combineReducers} from 'redux';
import lostAnimalReducer from '../modules/animal/components/lostAnimals/reducer/lostAnimalReducer';

export default combineReducers ({
    lostAnimals: lostAnimalReducer
    
}); 