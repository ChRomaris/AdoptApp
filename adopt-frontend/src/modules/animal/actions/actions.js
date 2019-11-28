import  { GET_ANIMAL_ENUMS} from './types';

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


export const getAnimalEnums = () => dispatch => {
    console.log("action")
    request ({
        url: "http://localhost:8080/animal/getTypes?name=",
        method: 'GET',
    }).then(enumValues => dispatch({
        type : GET_ANIMAL_ENUMS,
        payload : enumValues
    }));  
}