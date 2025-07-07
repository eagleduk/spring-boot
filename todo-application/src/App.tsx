import './App.css'
import { BrowserRouter, Routes, Route, Navigate } from "react-router";
import Header from "./components/Header";
import Login from "./components/Login";
import Welcome from "./components/Welcome";
import TodoList from "./components/todo/TodoList";
import AuthContext, { AuthProvider } from "./auth/AuthContext";
import { useContext, type JSX } from 'react';
import NotFound from './NotFound';
import Todo from './components/todo/Todo';

function AuthProviderWrapper({children}: {children: JSX.Element}) {
    const {auth} = useContext(AuthContext);
    if(auth) {
        return children;
    }
    return <Navigate to="/login" />
}

function App() {

  return (
    <div className="App">
      <AuthProvider>
        <BrowserRouter>
          <Header />
          <Routes>
              <Route path="/" element={
                <AuthProviderWrapper><Login /></AuthProviderWrapper>} />
              <Route path="/login" element={<Login />} />
              <Route path="/welcome/:name" element={<AuthProviderWrapper><Welcome /></AuthProviderWrapper>} />
              <Route path="/todos" element={<AuthProviderWrapper><TodoList /></AuthProviderWrapper>} />
              <Route path="/todos/:id" element={<AuthProviderWrapper><Todo /></AuthProviderWrapper>} />

              <Route path="/*" element={<NotFound />} />
          </Routes>
        </BrowserRouter> 
      </AuthProvider>
    </div>
  )
}

export default App
