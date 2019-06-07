import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {App} from './modules/app';
import {Provider} from 'react-redux';
import {IntlProvider} from 'react-intl';
import {initReactIntl} from './i18n';
import registerServiceWorker from './registerServiceWorker';
import {createStore, applyMiddleware, compose} from 'redux';
import thunk from 'redux-thunk';
import reducer from './reducer';



/* Configure store. */
const store = createStore(reducer,compose(applyMiddleware(thunk)));
const {locale, messages} = initReactIntl();

ReactDOM.render(
    <Provider store={store}>
        <IntlProvider locale={locale} messages={messages}>
            <App/>
        </IntlProvider>
    </Provider>, 
    document.getElementById('root'));
    
registerServiceWorker();
