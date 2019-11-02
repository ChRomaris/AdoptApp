import  { GET_ANIMAL_ENUMS, GET_PROFILE_ENUMS } from '../actions/types'


const initialState = {
    AnimalSelectorValues : {
        Breeds : [],
        Genres : [],
        Colors : [],
        Sizes : [],
        AdoptionStates : []
    },

    ProfileSelectorValues : {
        Genres : [],
        Types : []
    }
}

export default function (state = initialState, action) {
    switch (action.type) {
        case GET_ANIMAL_ENUMS:
            return { 
               ...state,
               AnimalSelectorValues : action.payload
            };
        case GET_PROFILE_ENUMS:
            return{
                ...state,
                ProfileSelectorValues : action.payload 
            }
            default : 
        return state;
        }  

        
} 