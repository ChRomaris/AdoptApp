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

export function getMessages (chatDTO) {
    return request ({
        url: "http://localhost:8080/chat/history",
        method: 'POST',
        payload: JSON.stringify(chatDTO)
    });
}

export function startChat (chatDTO) {
    console.log(chatDTO)
    return request ({
        url: "http://localhost:8080/chat/start",
        method: 'POST',
        body: JSON.stringify(chatDTO)
    });
}

export function getCurrentUserInfo (profileDTO) {
    console.log(profileDTO)
    return request ({
        url: "http://localhost:8080/profile/getInfo",
        method: 'POST',
        body: JSON.stringify(profileDTO)
    });
}

export function getUserChats (userToken){
    return request ({
        url: "http://localhost:8080/chat/active?token="+userToken,
        method: 'GET'
    });
}



