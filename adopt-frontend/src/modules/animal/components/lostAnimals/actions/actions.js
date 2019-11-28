import  { DISABLE_MARKER_INFO,GET_LOST_ANIMALS, NEXT_PAGE, PREVIOUS_PAGE, SHOW_MODAL, CLOSE_MODAL, SAVE_LOCATION, SET_LOCATION, GET_USER_ANIMALS, GET_ANIMAL_LOCATIONS, SET_SELECTED_LOCATION, GET_LOST_AREA, SET_MARKER_INFO, SET_ANIMAL, RESET_ANIMAL, DELETE_LOST} from './types';

const request = (options) => {
    const headers = new Headers({
        'Content-Type': 'application/json',
    })

    const defaults = {headers: headers};
    options = Object.assign({}, defaults, options);

    return fetch(options.url, options)
    .then(response => 
        response.json().then(json => {
            if(!response.ok) {
                return Promise.reject(json);
            }
            return json;
        })
    );
};

export const getAnimals = (params) => dispatch  => { 

        request ({
            url: "http://localhost:8080/animal/searchByDistance",
            method: 'POST',
            body: JSON.stringify(params)
        }).then(animals => dispatch({
            type : GET_LOST_ANIMALS,
            payload: animals
        }));  
}

export const nextPage = () => dispatch => {
    dispatch ({
        type : NEXT_PAGE
    })
}

export const previousPage = () => dispatch => {
    dispatch ({
        type : PREVIOUS_PAGE
    })
}

export const showModal = (id) => dispatch => {
    dispatch ({
        type : SHOW_MODAL,
        payload : id
    })
}

export const closeModal = () => dispatch => {
    dispatch ({
        type : CLOSE_MODAL
    })
}

export const saveLocation = (params) => dispatch => {
    request ({
        url: "http://localhost:8080/animal/addLocation",
        method: 'POST',
        body: JSON.stringify(params)
    }).then(() => dispatch({
        type : SAVE_LOCATION,
    }));  
}

export const setLocation = (params) => dispatch => {
    dispatch ({
        type : SET_LOCATION,
        payload : params
    })
}

export const getUserAnimals = (params) => dispatch => {
    request ({
        url: "http://localhost:8080/user/getAnimals?userToken="+params.token+"&page="+0,
        method: 'GET',
    }).then(animals => dispatch({
        type : GET_USER_ANIMALS,
        payload : animals
    }));
}

export const getLocations = (params) => dispatch => {
    console.log("actions")
    console.log(params)
    request ({
        url: "http://localhost:8080/animal/locations?animalId="+params.animalId+"&token="+params.token,
        method: 'GET',
    }).then(locations => dispatch({
        type : GET_ANIMAL_LOCATIONS,
        payload : locations
    }));
}

export const setSelectedLocation = (SelectedLocation) => dispatch => {
    dispatch ({
        type: SET_SELECTED_LOCATION,
        payload : SelectedLocation
    })
}

export const getLostAnimalsInArea = (params) => dispatch => {
    request ({
        url: "http://localhost:8080/animal/lostAnimalsInArea?token="+params.token,
        method: 'GET',
    }).then(animals => dispatch({
        type : GET_LOST_AREA,
        payload : animals
    }));
}

export const setMarkerInfo =  () => dispatch => {
    dispatch ({
        type: SET_MARKER_INFO
    })
}

export const disableMarkerInfo =  () => dispatch => {
    dispatch ({
        type: DISABLE_MARKER_INFO
    })
}


export const setAnimal = (animal) => dispatch => {
    dispatch({
        type : SET_ANIMAL,
        payload : animal
    })
}

export const resetAnimal = () => dispatch => {
    dispatch({
        type : RESET_ANIMAL
    })
}

export const deleteLost = (params) => dispatch => {
    request ({
        url: "http://localhost:8080/user/deleteLost",
        method: 'POST',
        body: JSON.stringify(params)
    }).then(animals => dispatch({
        type : DELETE_LOST,
        payload : animals
    })); 
}

