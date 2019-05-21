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

export function addShelter (shelterData) {
    
    return request ({
        url: "http://localhost:8080/shelter/add",
        method: 'POST',
        body: JSON.stringify(shelterData)
    });
}