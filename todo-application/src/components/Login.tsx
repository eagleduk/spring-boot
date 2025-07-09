import { useContext, useState } from "react";
import AuthContext from "../auth/AuthContext";
import { useNavigate } from "react-router";

export default function Login() {

    const {loginJWT} = useContext(AuthContext);

    const [name, setName] = useState("");
    const [password, setPassword] = useState("");

    const navigate = useNavigate();

    async function handleSubmit() {
        const loginSuccess = await loginJWT(name, password);

        if(loginSuccess) {
            navigate(`/welcome/${name}`);
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