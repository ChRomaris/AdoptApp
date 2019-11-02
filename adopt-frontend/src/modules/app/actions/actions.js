import  { GET_ANIMAL_ENUMS, GET_PROFILE_ENUMS} from './types';

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

export const getAnimalEnums = () => dispatch  => { 

        request ({
            url: "http://localhost:8080/animal/getTypes",
            method: 'GET',
        }).then(enumValues => dispatch({
            type : GET_ANIMAL_ENUMS,
            payload: enumValues
        }));  
}

export const getProfileEnums = () => dispatch  => { 

    request ({
        url: "http://localhost:8080/profile/enums",
        method: 'GET',
    }).then(enumValues => dispatch({
        type : GET_PROFILE_ENUMS,
        payload: enumValues
    }));  
}