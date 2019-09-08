
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

export function getUserInfo(userInfo){
    return request ({
        url: "http://localhost:8080/profile/getInfo",
        method: 'POST',
        body: JSON.stringify(userInfo)
    });
}


export function register (registerUpdateRequest) {
    
    return request ({
        url: "http://localhost:8080/profile/register",
        method: 'POST',
        body: JSON.stringify(registerUpdateRequest)
    });
}

export function login (loginData) {
    return request ({
        url: "http://localhost:8080/profile/login",
        method: 'POST',
        body: JSON.stringify(loginData)
    })
}

export function setLocation(locationParams){
    return request ({
        url: "http://localhost:8080/user/setLocation",
        method: 'POST',
        body: JSON.stringify(locationParams)
    })
}

export function updateUser(updateUserRequest){
    return request ({
        url: "http://localhost:8080/profile/update ",
        method: 'POST',
        body: JSON.stringify(updateUserRequest)
    });
}
