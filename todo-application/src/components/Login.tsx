import { useContext, useState } from "react";
import { useNavigate } from "react-router-dom";
import AuthContext from "../auth/AuthContext";

export default function Login() {

    const {login} = useContext(AuthContext);

    const navigate = useNavigate();
    const [name, setName] = useState("");
    const [password, setPassword] = useState("");

    function handleSubmit() {
        if(name === "user" && password === "password"){
            login();
            navigate(`/welcome/${name}`)
        }
    }

    return (
        <div>
            <h1>Login</h1>

            <div className="container">
                <div>
                    <label>User Name:</label>
                    <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
                </div>
                <div>
                    <label>Password:</label>
                    <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
                </div>
                <div>
                    <button onClick={handleSubmit}>Login</button>
                </div>
            </div>
        </div>
    )
}