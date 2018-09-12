import React from 'react';
import ReactDOM from 'react-dom';
import './Assets/Css/bulma.min.css';
import App from './Pages/App';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<App />, document.getElementById('root'));
registerServiceWorker();
