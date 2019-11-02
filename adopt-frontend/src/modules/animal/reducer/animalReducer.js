import  {GET_ANIMAL_ENUMS } from '../actions/types'


const initialState = {
    animalSelectorValues : {
        breeds: [],
        colors: [],
        sizes: [],
        genres: [],
        adoptionStates:[]
    }

}

export default function (state = initialState, action) {
    switch (action.type) {
        case GET_ANIMAL_ENUMS:
            console.log("reducer")
            return { 
                ...state,   
                animalSelectorValues : action.payload
            };

        default : 
            return state;
    }
} 