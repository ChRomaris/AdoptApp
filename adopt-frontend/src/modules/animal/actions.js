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

export function addAnimal (animalCreationRequest) {
    
    return request ({
        url: "http://localhost:8080/shelter/animal/add",
        method: 'POST',
        body: JSON.stringify(animalCreationRequest)
    });
}

export function editAnimal(params){
    return request ({
        url: "http://localhost:8080/shelter/animal/edit",
        method: 'POST',
        body: JSON.stringify(params)
    });
}
export function getAnimalInfo(params){
    return request ({
        url: "http://localhost:8080/animal/getInfo",
        method: 'POST',
        body: JSON.stringify(params)
    });
}
export function getAllAdoptionAnimals () {
    return request ({
        url: "http://localhost:8080/animal/getAll",
        method: 'GET'
    })
}

export function getNearbyAdoptionAnimals(params){
    return request ({
        url: "http://localhost:8080/animal/nearbyAdoptionAnimals",
        method: 'POST',
        body: JSON.stringify(params)
    });
}

