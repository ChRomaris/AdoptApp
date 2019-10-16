import  { SET_PREFERENCES, GET_PREFERENCES} from './types';

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
export const setPreferences = (params) => dispatch => {
    console.log("actions")
    request ({
        url: "http://localhost:8080/user/preferences",
        method: 'POST',
        body : JSON.stringify(params)
    }).then(preferences => dispatch({
        type : SET_PREFERENCES,
        payload : preferences
    }));  
}

export const getPreferences = (userToken) => dispatch => {
    console.log("actions")
    request ({
        url: "http://localhost:8080/user/preferences?userToken="+userToken,
        method: 'GET',
    }).then(preferences => dispatch({
        type : GET_PREFERENCES,
        payload : preferences
    }));  
}