import { createContext, useState, type JSX } from "react";


const AuthContext = createContext({
    auth: false,
    login: () => {},
    logout: () => {}
});

export function AuthProvider({children}: {children: JSX.Element}) {

    const [auth, setAuth] = useState(false);

    function login() {
        setAuth(true);
    }

    function logout() {
        setAuth(false); 
    }

    return (
        <AuthContext.Provider value={ {auth, login, logout}}>
            {children}
        </AuthContext.Provider>
    )
}


export default AuthContext