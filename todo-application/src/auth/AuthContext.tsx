import { createContext, useState, type JSX } from "react";
import { loginService } from "../api/api";

const AuthContext = createContext<{
        auth: boolean;
        username: string | null;
        login: (name: string, password: string) => void;
        logout: () => void;
}>({
    auth: false,
    username: null,
    login: () => {},
    logout: () => {}
});

export function AuthProvider({children}: {children: JSX.Element}) {

    const [auth, setAuth] = useState(false);
    const [username, setUsername] = useState<string | null>(null);

    function login(name: string, password: string) {
        
        const baseToken = btoa(name + ":" + password);

        loginService(baseToken)
            .then(() => {
                setAuth(true);
                setUsername(name);
            })
            .catch(error => console.log(error))
            .finally(() => console.log("finally"))

    }

    function logout() {
        setAuth(false); 
        setUsername(null);
    }

    return (
        <AuthContext.Provider value={ {auth, login, logout, username }}>
            {children}
        </AuthContext.Provider>
    )
}


export default AuthContext