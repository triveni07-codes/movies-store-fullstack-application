import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';

import HomePage from './containers/HomePage';

import './App.css';

const App = () => {
    return (
        <Router>
            <Route
                path="/"
                component={HomePage} />
        </Router>
    );
}

export default App;
