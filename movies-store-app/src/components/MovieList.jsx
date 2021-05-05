import React from 'react';

import { IsEmpty, Map } from 'react-lodash';

import MovieCard from './MovieCard';

import '../styles/MovieList.scss';

const MovieList = (props) => {
    const { heading, allMovies, alreadyWatched, addToWatchList, removeFromWatchList } = props;
    let movies;
    let onClickHandler;
    if (allMovies) {
        movies = allMovies;
        onClickHandler = addToWatchList;
    } else {
        movies = alreadyWatched;
        onClickHandler = removeFromWatchList;
    }

    return (
        <div className='movies-container'>
            <div className='row'>
                <div className='movie-header'>
                    <h4>{heading}</h4>
                </div>
            </div>
            <div className='row'>
                <IsEmpty
                    className='movie-list'
                    value={movies}
                    yes={() => (<></>)}
                    no={() => (
                        <Map collection={movies} iteratee={movie =>
                            <MovieCard
                                movie={movie}
                                onClickHandler={onClickHandler}
                            />}
                        />
                    )}
                />
            </div>
        </div>
    )
}

export default MovieList;