import { createContext, useState, type JSX } from "react";

const AuthContext = createContext<{
        auth: boolean;
        username: string | null;
        login: (name: string) => void;
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

    function login(name: string) {
        setAuth(true);
        setUsername(name);
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