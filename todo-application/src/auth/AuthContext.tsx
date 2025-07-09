import { createContext, useState, type JSX } from "react";
import { https, loginJWTService, loginService } from "../api/api";

const AuthContext = createContext<{
        auth: boolean;
        username: string | null;
        login: (name: string, password: string) => Promise<boolean>;
        logout: () => void;
        loginJWT: (name: string, password: string) => Promise<boolean>;
}>({
    auth: false,
    username: null,
    login: () => Promise.resolve(false),
    logout: () => {},
    loginJWT: () => Promise.resolve(false)
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
    async function loginJWT(name: string, password: string) {
        
        try {
            const response = await loginJWTService(name, password);

            if(response.status === 200) {

                const token = response.data.token;

                setAuth(true);
                setUsername(name);

                https.interceptors.request.use(
                    (config) => {
                        config.headers["Authorization"] = `Bearer ${token}`;
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
        <AuthContext.Provider value={ {auth, login, logout, loginJWT, username }}>
            {children}
        </AuthContext.Provider>
    )
}


export default AuthContext