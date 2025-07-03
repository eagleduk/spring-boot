import { Link, useParams } from "react-router"

export default function Welcome() {

   const {name} = useParams()

    return (
        <div>
            <h1>Welcome {name}</h1>
            <Link to="/todos">Todos</Link>
        </div>
    )
}