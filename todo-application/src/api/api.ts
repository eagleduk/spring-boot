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

export function getTodosByUsername(username: string) {
    return https.get(`/users/${username}/todos`);
}

export function getTodoById(username: string, id: string) {
    return https.get(`/users/${username}/todos/${id}`);
}

export function deleteTodosById(username: string, id: string) {
    return https.delete(`/users/${username}/todos/${id}`);
}