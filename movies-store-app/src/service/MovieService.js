import axios from 'axios';

const API_URL = 'http://localhost:8080/api/movies';

class MovieService {

    async requestToGetAllMovies() {
        return await axios.get(API_URL);
    }

    async requestToGetWatchedMovies() {
        return await axios.get(`${API_URL}/watched`);
    }

    async requestToMarkAsWatched(movieId) {
        const axiosInstance = axios.create({
            baseURL: `${API_URL}/${movieId}`,
            method: 'PUT',
            timeout: 1000,
            headers: { 'X-Custom-Header': 'custom header' }
        });

        await axiosInstance.request({ id: movieId });
    }


    async requestToAddMovie(title, description, image) {
        const axiosInstance = axios.create({
            url: '/movies',
            baseURL: 'http://localhost:8080/api',
            method: 'POST',
            timeout: 1000,
            headers: { 'X-Custom-Header': 'custom header' }
        });

        return await axiosInstance.request({
            data: {
                title: title,
                comment: description,
                imageUrl: image
            }
        });

    }

    async requestToRemoveWatchedMovie(movieId) {
        return await axios.delete(`${API_URL}/${movieId}`);
    }
}

export default new MovieService()