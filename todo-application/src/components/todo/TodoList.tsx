
export default function TodoList() {

    const todos = [
        {id: 1001, title: "Todo 1", done: false, targetDate: new Date()},
        {id: 1002, title: "Todo 2", done: false, targetDate: new Date()},
        {id: 1003, title: "Todo 3", done: false, targetDate: new Date()},
    ]

    return (
        <div className="container">
            <h1>TodoList</h1>
            <table className="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Title</th>
                        <th>Target Date</th>
                        <th>Done</th>
                    </tr>
                </thead>
                <tbody>
                    {todos.map(todo => (
                        <tr key={todo.id}>
                            <td>{todo.id}</td>
                            <td>{todo.title}</td>
                            <td>{Intl.DateTimeFormat("en-GB").format(todo.targetDate)}</td>
                            <td>{todo.done ? "Done" : "Not Done"}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}