import './App.css'
import { BrowserRouter, Routes, Route } from "react-router";
import Header from "./components/Header";
import Login from "./components/Login";
import Welcome from "./components/Welcome";
import TodoList from "./components/todo/TodoList";

function App() {

  return (
    <div className="App">
      <BrowserRouter>
        <Header />
        <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/login" element={<Login />} />
            <Route path="/welcome/:name" element={<Welcome />} />
            <Route path="/todos" element={<TodoList />} />
        </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App
