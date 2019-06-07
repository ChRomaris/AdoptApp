import { brotliDecompressSync } from "zlib";

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

export function getAllAdoptionAnimals () {
    return request ({
        url: "http://localhost:8080/animal/getAll",
        method: 'GET'
    })
}