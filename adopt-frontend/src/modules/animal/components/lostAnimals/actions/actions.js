import  { GET_LOST_ANIMALS, NEXT_PAGE, PREVIOUS_PAGE } from './types';

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



