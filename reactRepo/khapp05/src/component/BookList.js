export default function BookList(){
   
    const book1 = {
        title: '해리포터 : 마법사의 돌',
        writer: '홍길동'
    };
    const book2 = {
        title: '해리포터 : 비밀의방',
        writer: '홍길은'
    };
    const book3 = {
        title: '해리포터 : 불사조',
        writer: '홍길금'
    };
    const bookList = [book1, book2, book3];

    return (<>
        <div className="bookListWrap">
            <table>
                <thead>
                    <tr>
                        <th scope="">제목</th>
                        <th scope="">저자</th>
                    </tr>
                </thead>
                <tbody>
                    {bookList.map((book) => {
                        return <tr>
                            <td>{book.title}</td>
                            <td>{book.writer}</td>
                        </tr>;
                    })}
                </tbody>
            </table>
        </div>
    </>);
}