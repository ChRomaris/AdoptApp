import axios from 'axios';
import { BehaviorSubject } from 'rxjs';


const currentUserSubject = new BehaviorSubject (JSON.parse(localStorage.getItem('currentUser')))

export function handleResponse(response) {
    return response.text().then(text => {
        const data = text && JSON.parse(text);
        if (!response.ok) {
            if ([401, 403].indexOf(response.status) !== -1) {
                // auto logout if 401 Unauthorized or 403 Forbidden response returned from api
                userService.logout();
                window.location.reload(true);
            }

            const error = (data && data.message) || response.statusText;
            return Promise.reject(error);
        }

        return data;
    });
}
export const login = (loginData) => {   

    axios.post('http://localhost:8080/user/signIn',loginData)
    .then(handleResponse).then(user => {
        localStorage.setItem('currentUser', JSON.stringify(user));
        currentUserSubject.next(user);
        return user;
    })  
}

function logout() {
    sessionStorage.removeItem('serviceToken');
}

export const userService = {
    login,
    logout,
    currentUser: currentUserSubject.asObservable(),
    getCurrentUserValue () { return currentUserSubject.value}
};

export const signUp = (user) => {

    axios.post('http://localhost:8080/user/signIn',user)


}





