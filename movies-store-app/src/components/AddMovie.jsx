import React from 'react';

import { Button, Card, TextField } from '@material-ui/core';

import '../styles/AddMovie.scss';

const AddMovie = (props) => {
    const { addNewMovie } = props;

    const handleAddMovie = (e) => {
        e.preventDefault();
        const { target } = e;
        const title = target.querySelector('#title').value;
        const comment = target.querySelector('#comment').value;
        const imageUrl = target.querySelector('#image').value;

        addNewMovie(title, comment, imageUrl);

        target.querySelector('#title').value = '';
        target.querySelector('#comment').value = '';
        target.querySelector('#image').value = '';

    }

    return (
        <div className='add-movie'>
            <Card className='add-form'>
                <form onSubmit={e => handleAddMovie(e)}>
                    <TextField
                        placeholder='Title'
                        id='title'
                        required
                        fullWidth
                    />
                    <br /><br />
                    <TextField
                        placeholder='Comment'
                        id='comment'
                        rows={2}
                        required
                        fullWidth
                    />
                    <br /><br />
                    <TextField
                        placeholder='Image url'
                        id='image'
                        rows={2}
                        required
                        fullWidth
                    />
                    <br /><br />
                    <Button id='form-button' variant='contained' type='submit' value='ADD MOVIE'>
                        ADD MOVIE
                    </Button>
                </form>
            </Card>
        </div>
    );
}

export default AddMovie;