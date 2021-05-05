import React, { useState, useEffect } from 'react';

import { Route, Switch } from 'react-router-dom';
import movieService from '../service/MovieService';

import AddMovie from '../components/AddMovie';
import ErrorBoundary from '../components/ErrorBoundary';
import Header from '../components/Header';
import MovieList from '../components/MovieList';

import '../styles/HomePage.scss';

const HomePage = () => {
    const [allMovies, setAllMovies] = useState([]);
    const [alreadyWatched, setAlreadyWatched] = useState([]);

    async function fetchMovies() {
        let moviesResponse = [];
        await movieService.requestToGetAllMovies()
            .then(response => moviesResponse = response.data)
            .catch(error => Promise.reject(error));
        setAllMovies(moviesResponse);
    }

    async function fetchWatched() {
        let watchedMoviesResponse = [];
        await movieService.requestToGetWatchedMovies()
            .then(response => watchedMoviesResponse = response.data)
            .catch(error => Promise.reject(error));
        setAlreadyWatched(watchedMoviesResponse);
    }

    async function addToWatchList(movie) {
        let movieAlreadyWatched;
        if (alreadyWatched) {
            movieAlreadyWatched = alreadyWatched.find(watched => watched.title === movie.title);
        }
        if (!movieAlreadyWatched) {
            await movieService.requestToMarkAsWatched(movie.id)
                .then(response => {
                    const newWatchedList = [...alreadyWatched, movie];
                    setAlreadyWatched(newWatchedList);
                })
                .catch(error => Promise.reject(error));
        }
    };

    async function addNewMovie(title, comment, imageUrl) {
        let newMovie = {};
        await movieService.requestToAddMovie(title, comment, imageUrl)
            .then(response => {
                newMovie = response.data;
                const allMoviesPlusNewOne = [...allMovies, newMovie];
                setAllMovies(allMoviesPlusNewOne);
            }).catch(error => Promise.reject(error));
    };

    async function removeFromWatchList(movie) {
        await movieService.requestToRemoveWatchedMovie(movie.id)
            .then(response => {
                const updatedMoviesList = allMovies.filter((existingMovie) => existingMovie.title !== movie.title);
                const updatedWatchedList = alreadyWatched.filter((watched) => watched.title !== movie.title);
                setAlreadyWatched(updatedWatchedList);
                setAllMovies(updatedMoviesList);
            })
            .catch(error => Promise.reject(error));
    };

    useEffect(() => {
        fetchMovies();
        fetchWatched();
    }, []);


    return (
        <div className='container-fluid movie-app'>
            <Header />
            <Switch>
                <div id='content'>
                    <Route path='/' render={({ history }) => (
                        <ErrorBoundary >
                            <AddMovie addNewMovie={addNewMovie} />
                        </ErrorBoundary>
                    )} />
                    <Route path='/' render={({ history }) => (
                        <ErrorBoundary>
                            <MovieList
                                heading='Movies collection'
                                allMovies={allMovies}
                                addToWatchList={addToWatchList} />
                            <MovieList
                                heading='Already watched'
                                alreadyWatched={alreadyWatched}
                                removeFromWatchList={removeFromWatchList} />
                        </ErrorBoundary>
                    )} />
                </div>
            </Switch>
        </div>
    );
}

export default HomePage;