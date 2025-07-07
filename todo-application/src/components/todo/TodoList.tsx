import { useCallback, useContext, useEffect, useState } from "react";
import { deleteTodosById, getTodosByUsername } from "../../api/api";
import { useNavigate } from "react-router";
import AuthContext from "../../auth/AuthContext";

export default function TodoList() {

    const {username} = useContext(AuthContext);

    const navigate = useNavigate();

    const [todos, setTodos] = useState<{id: string, description: string, targetDate: Date, done: boolean}[]>([]);

    const getTodos = useCallback(() => {
        if(!username) return;
        getTodosByUsername(username)
            .then(response => setTodos(response.data))
            .catch(error => console.log(error))
            .finally(() => console.log("finally"))
    }, [username]);

    function deleteTodo(id: string) {
        if(!username || !id) return;
        deleteTodosById(username, id)
            .then(() => getTodos())
            .catch(error => console.log(error))
            .finally(() => console.log("finally"))
    }

    function updateTodo(id: string) {
        navigate(`/todos/${id}`);
    }

    useEffect(() => {
        getTodos();
    }, [username, getTodos]);

    return (
        <div className="container">
            <h1>TodoList</h1>
            <table className="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Done</th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    {todos.map(todo => (
                        <tr key={todo.id}>
                            <td>{todo.id}</td>
                            <td>{todo.description}</td>
                            <td>{todo.targetDate.toString()}</td>
                            <td>{todo.done ? "Done" : "Not Done"}</td>
                            <td><button className="btn btn-danger" onClick={() => deleteTodo(todo.id)} >Delete</button></td>
                            <td><button className="btn btn-primary" onClick={() => updateTodo(todo.id)} >Update</button></td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}