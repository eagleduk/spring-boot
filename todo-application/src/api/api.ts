import axios from "axios";

export const https = axios.create({
    baseURL: "http://localhost:8080",
    headers: {
        "Content-Type": "application/json",
    }
});

export function loginService(token: string) {
    return https.get(`/login`, {
        headers: {
            "Authorization": `Basic ${token}`
        }
    })
}

export function loginJWTService(username: string, password: string) {
    return https.post(`/authenticate`, {username, password})
}

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

export function updateTodoById(username: string, id: string, todo: {id: number, description: string, targetDate: string, done: boolean}) {
    return https.put(`/users/${username}/todos/${id}`, todo);   
}

export function createNewTodo(username: string, todo: {id: number, description: string, targetDate: string, done: boolean}) {
    return https.post(`/users/${username}/todos`, todo);   
}