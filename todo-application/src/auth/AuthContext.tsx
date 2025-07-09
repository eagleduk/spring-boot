import { createContext, useState, type JSX } from "react";
import { https, loginService } from "../api/api";

const AuthContext = createContext<{
        auth: boolean;
        username: string | null;
        login: (name: string, password: string) => Promise<boolean>;
        logout: () => void;
}>({
    auth: false,
    username: null,
    login: () => Promise.resolve(false),
    logout: () => {},
});

export function AuthProvider({children}: {children: JSX.Element}) {

    const [auth, setAuth] = useState(false);
    const [username, setUsername] = useState<string | null>(null);

    async function login(name: string, password: string) {
        
        const baseToken = btoa(name + ":" + password);
        try {
            const response = await loginService(baseToken);

            if(response.status === 200) {
                setAuth(true);
                setUsername(name);

                https.interceptors.request.use(
                    (config) => {
                        config.headers["Authorization"] = `Basic ${baseToken}`;
                        return config;
                    }
                )

                return true;
            }
            logout();
            return false;

        } catch {logout();
            return false;
        }
    }

    function logout() {
        setAuth(false); 
        setUsername(null);
        https.interceptors.request.clear();
    }

    return (
        <AuthContext.Provider value={ {auth, login, logout, username }}>
            {children}
        </AuthContext.Provider>
    )
}


export default AuthContext