import axios from 'axios';
export const signUp = (user) => {

    axios.post('http://localhost:8080/user/signIn',user)


}