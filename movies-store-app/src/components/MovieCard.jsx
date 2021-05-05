import React from 'react';

import '../styles/MovieCard.scss';

const MovieCard = (props) => {
    const { movie, onClickHandler } = props;
    return (
        <div className='movie-card' onClick={() => onClickHandler(movie)}>
            <img alt='movie' className='movie-poster'
                src={movie.imageUrl} ></img>
            <div id='title'>
                <span>{movie.title}</span>
            </div>
            <div className='overlay' id='comment'>
                <span>{movie.comment}</span>
            </div>
        </div >
    )
}

export default MovieCard;