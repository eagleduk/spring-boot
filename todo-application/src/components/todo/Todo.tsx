import { useEffect, useState } from "react";
import { useParams } from "react-router"
import { getTodoById } from "../../api/api";
import { useContext } from "react";
import AuthContext from "../../auth/AuthContext";
import { updateTodoById, createNewTodo } from "../../api/api";

export default function Todo() {

    const {username} = useContext(AuthContext);

    const {id} = useParams()

    const create = id === "0";

    const [todo, setTodo] = useState<{id: number, description: string, targetDate: string, done: boolean} | null>(null);

    const [message, setMessage] = useState<string | null>(null);

    useEffect(() => {
        if(!username || !id) return;
        getTodoById(username, id)
            .then(response => setTodo(response.data))
            .catch(error => console.log(error))
    }, [username, id]);

    function changeDescriptionHandler(event: React.ChangeEvent<HTMLInputElement>) {
        if(!todo) return;
        setTodo({...todo, description: event.target.value})
    } 
    function changeTargetDateHandler(event: React.ChangeEvent<HTMLInputElement>) {
        if(!todo) return;
        setTodo({...todo, targetDate: (event.currentTarget.value)})

    } 
    function changeDoneHandler(event: React.ChangeEvent<HTMLInputElement>) {
        if(!todo) return;
        setTodo({...todo, done: event.target.checked})
    }

    function createTodo() {
        if(!todo || !username) return;
        createNewTodo(username, todo)
            .then(() => setMessage("Create Successful"))
            .catch(error => console.log(error))
    }

    function updateTodo() {
        if(!todo || !username || !id) return;
        updateTodoById(username, id, todo)
            .then(() => setMessage("Update Successful"))
            .catch(error => console.log(error))
    }

    return (
        <div>
            <h1>Todo</h1>

            {
                message && (
                    <div className="alert alert-success">
                        {message}
                    </div>
                )
            }

            {
                todo && (
                    <div>
                        <p>
                            <label>Description</label>
                            <input type="text" value={todo.description} onChange={changeDescriptionHandler} />
                            </p>
                        <p>
                            <label>Target Date</label>
                            <input type="date" value={todo.targetDate.toString()} onChange={changeTargetDateHandler} />
                        </p>
                        <p>
                            <label>Done</label>
                            <input type="checkbox" checked={todo.done} onChange={changeDoneHandler}/>
                        </p>
                    </div>
                )
            }
            <button className="btn btn-primary" onClick={create ? createTodo : updateTodo}>{create ? "Create" : "Update"}</button>
        </div>
    )
}