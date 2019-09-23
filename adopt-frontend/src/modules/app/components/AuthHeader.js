import { userService } from '../../../backend/userService';

export function authHeader () {
    const currentUser = userService.currentUser;
    if(currentUser &&  currentUser.token) {
        return { Authorization: 'Bearer ${currentUser.token}'};

    }else{
        return {}
    }
}