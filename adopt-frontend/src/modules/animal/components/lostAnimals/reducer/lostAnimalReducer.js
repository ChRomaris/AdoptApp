import  { GET_LOST_ANIMALS, NEXT_PAGE, PREVIOUS_PAGE, SHOW_MODAL, CLOSE_MODAL, SAVE_LOCATION, SET_LOCATION, GET_USER_ANIMALS, GET_ANIMAL_LOCATIONS, SET_SELECTED_LOCATION, GET_LOST_AREA, SET_MARKER_INFO, SET_ANIMAL, RESET_ANIMAL, DELETE_LOST} from '../actions/types'


const initialState = {
    animals : [],
    actualPage: 0,
    maxPage: 0,
    isEditing : false,
    showModal : false,
    showLocationModal : false,
    selectedLocation : {},
    selectedAnimal : {},
    selectedAnimalId: '',
    selectedLatitude : '',
    selectedLongitude : '',
    isUserList: false,
    locations: [],
    locationsLoaded : false,
    selectedLocation: '',
    isMarkerInfo:false


}

export default function (state = initialState, action) {
    switch (action.type) {
        case GET_LOST_ANIMALS:
            return { 
                ...state,   
                animals: action.payload.lostAnimals ,
                maxPage : action.payload.totalPages,
                isUserList: false
            };
        case NEXT_PAGE:
            var previousPage = state.actualPage
            return{
                ...state,
                actualPage : previousPage + 1
            }
        case PREVIOUS_PAGE:
            var previousPage2 = state.actualPage
            return{
                ...state,
                actualPage : previousPage2 - 1
            }
        case SHOW_MODAL:
            return{
                ...state,
                showModal : true,
                selectedAnimal : action.payload
            }
        case CLOSE_MODAL:
            return{
                ...state,
                showModal : false
            }
        case SAVE_LOCATION :
            return{
                ...state,
                showModal: false
            }
        case SET_LOCATION :
            return{
                ...state,
                selectedLongitude : action.payload.longitude,
                selectedLatitude : action.payload.latitude 
                
            }
        case GET_USER_ANIMALS :
            return{
                ...state,
                animals : action.payload.lostAnimals,
                maxPage : 0,
                isUserList: true
            }
        case GET_ANIMAL_LOCATIONS :
            return{
                ...state,
                locations: action.payload.locations,
                locationsLoaded : true
            }
        case SET_SELECTED_LOCATION :
            return{
                ...state,
                selectedLocation : action.payload

            }
        case GET_LOST_AREA :
            return{
                ...state,
                animals : action.payload.animals
            }
        case SET_MARKER_INFO:
            return{
                ...state,
                isMarkerInfo : true

            }
        case SET_ANIMAL:
            return{
                ...state,
                selectedAnimal : action.payload
            }
        case RESET_ANIMAL:
            return{
                ...state,
                selectedAnimal : {}
            }
        case DELETE_LOST:
            return{
                ...state,
                animals : action.payload.lostAnimals
        }
        default : 
            return state;
    }
} 