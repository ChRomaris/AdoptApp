import React from 'react';
import { Route, Redirect } from 'react-router-dom';

import  { userService } from '../../../backend/userService';

export const PrivateRoute = ({component: Component, ...rest}) => (
    <Route {...rest} render = {props => {
        const currentUser = userService. currentUserValue;
        if(!currentUser) {
            return <Redirect to={{ pathname: '/', state: {from: props.location} }}/>
        }

        return <Component {...props } />
    }} />
)