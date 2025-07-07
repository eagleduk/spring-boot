import { useEffect, useState } from "react";
import { useParams } from "react-router"
import { getTodoById } from "../../api/api";
import { useContext } from "react";
import AuthContext from "../../auth/AuthContext";

export default function Todo() {

    const {username} = useContext(AuthContext);

    const {id} = useParams()

    const [todo, setTodo] = useState<{id: number, description: string, targetDate: Date, done: boolean} | null>(null);

    useEffect(() => {
        if(!username || !id) return;
        getTodoById(username, id)
            .then(response => setTodo(response.data))
            .catch(error => console.log(error))
            .finally(() => console.log("finally"))
    }, [username, id]);

    return (
        <div>
            <h1>Todo</h1>
            {
                todo && (
                    <div>
                        <h2>{todo.description}</h2>
                        <p>{todo.targetDate.toString()}</p>
                        <p>{todo.done ? "Done" : "Not Done"}</p>
                    </div>
                )
            }
        </div>
    )
}