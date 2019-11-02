import  {GET_PREFERENCES, SET_PREFERENCES, GET_USER_ENUMS} from '../actions/types'


const initialState = {
    profilePreferences : {},
    userSelectorValues : {
        types: [],
        genres : []
    }

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
        case GET_USER_ENUMS:
                 return{
                      ...state,
                        userSelectorValues : action.payload
                 }
        
        default : 
            return state;
    }
} 

