export default function MovieAdd(){
    return (<>
        <h2>Create Movie</h2>
        <table>
            <tbody>
                <tr>
                    <td><input type="text" placeholder="Input movie id"/></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="Input movie title"/></td>
                </tr>
                <tr>
                    <td><input type="text" placeholder="Input movie genre"/></td>
                </tr>
                <tr>
                    <td>출시일 : <input type="date"/></td>
                </tr>
                <tr>
                    <td><button>Add Movie</button></td>
                </tr>
            </tbody>
        </table>
    </>);
}