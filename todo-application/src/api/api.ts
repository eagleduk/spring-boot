import axios from "axios";

const https = axios.create({
    baseURL: "http://localhost:8080",
    headers: {
        "Content-Type": "application/json",
    }
});

export function callHelloWorldPathVariable(name: string) {
    return https.get(`/hello-world/path-variable/${name}`);
}