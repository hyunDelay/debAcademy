export default function MovieList(){

    const movie1 = {
        id: 1,
        title: 'Movie 1',
        genre: 'Drama',
        releaseDate: '2022-01-01',
    };
    const movie2 = {
        id: 2,
        title: 'Movie 2',
        genre: 'Action',
        releaseDate: '2022-02-01',
    };
    const movie3 = {
        id: 3,
        title: 'Movie 3',
        genre: 'Comedy',
        releaseDate: '2022-03-01',
    };
    const movieList = [movie1, movie2, movie3];

    return(<>
        <h2>Movies</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Genre</th>
                    <th>Release Date</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                {movieList.map((movie) => {
                    return <tr>
                        <td>{movie.id}</td>
                        <td>{movie.title}</td>
                        <td>{movie.genre}</td>
                        <td>{movie.releaseDate}</td>
                        <td><button>Delete</button></td>
                    </tr>
                })}
            </tbody>
        </table>
    </>);
}