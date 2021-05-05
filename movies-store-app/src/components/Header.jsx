import React, { Component } from 'react';

import moviesLogo from '../assets/images/codest.png';

export default class Header extends Component {
    render() {
        return (
            <div className='header'>
                <img className='header-logo' src={moviesLogo}
                    alt='Movies Start' />
            </div>
        );
    }
}
