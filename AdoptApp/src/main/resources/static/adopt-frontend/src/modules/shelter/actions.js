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

export function findShelterByUser (userToken){
    return request({
        url: "http://localhost:8080/shelter/findByUser",
        method: 'POST',
        body: JSON.stringify(userToken)
    });
}

export function getShelterAnimals (param){
    return request({
        url: "http://localhost:8080/shelter/list",
        method: 'POST',
        body: JSON.stringify(param)
    }); 
}

export function deleteShelterAnimal (param){
    return request({
        url: "http://localhost:8080/shelter/animal/delete",
        method: 'POST',
        body: JSON.stringify(param)
    });
}

    export function updateShelter(updateShelterRequest){
        return request ({
            url: "http://localhost:8080/profile/update ",
            method: 'POST',
            body: JSON.stringify(updateShelterRequest)
        });
    }

        export function getShelterInfo(shelterInfo){
            return request ({
                url: "http://localhost:8080/profile/getInfo",
                method: 'POST',
                body: JSON.stringify(shelterInfo)
            });
        }
        