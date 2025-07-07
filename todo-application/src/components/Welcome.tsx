import { Link, useParams } from "react-router"
import { callHelloWorldPathVariable } from "../api/api";
import { useState } from "react";

export default function Welcome() {

   const {name} = useParams()

   const [message ,setMessage] = useState<string | null>(null);

   function handleClick() {
    if(!name) return;

    callHelloWorldPathVariable(name)
        .then(response => setMessage(response.data.message))
        .catch(error => console.log(error))
        .finally(() => console.log("finally"))
   }

    return (
        <div>
            <h1>Welcome {name}</h1>
            <Link to="/todos">Todos</Link>
            <br />

            <button className="btn btn-success m-5" onClick={handleClick}>
                Hello World !!
            </button>
            <h2>{message}</h2>
        </div>
    )
}