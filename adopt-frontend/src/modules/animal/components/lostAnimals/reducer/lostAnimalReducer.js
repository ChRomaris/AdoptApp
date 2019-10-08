import  { GET_LOST_ANIMALS, NEXT_PAGE, PREVIOUS_PAGE } from '../actions/types'

const initialState = {
    animals : [],
    actualPage: 0,
    maxPage: 0
}

export default function (state = initialState, action) {
    switch (action.type) {
        case GET_LOST_ANIMALS:
            return { 
                ...state,   
                animals: action.payload.lostAnimals ,
                maxPage : action.payload.totalPages

            };
        case NEXT_PAGE:
            var previousPage = state.actualPage
            return{
                ...state,
                actualPage : previousPage + 1
            }
        case PREVIOUS_PAGE:
            var previousPage = state.actualPage
            return{
                ...state,
                actualPage : previousPage - 1
            }

        default : 
            return state;
    }
} 