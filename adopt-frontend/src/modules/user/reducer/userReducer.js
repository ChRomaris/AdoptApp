import  {GET_PREFERENCES, SET_PREFERENCES} from '../actions/types'


const initialState = {
    profilePreferences : {}

}

export default function (state = initialState, action) {
    switch (action.type) {
        case GET_PREFERENCES:
            console.log("reducer")
            return { 
                ...state,   
                profilePreferences : action.payload
            };
        case SET_PREFERENCES:
            return{
                ...state,
                profilePreferences : action.payload
            }
        
        default : 
            return state;
    }
} 

