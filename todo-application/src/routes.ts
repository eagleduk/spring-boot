import {
  type RouteConfig,
  route,
  index,
} from "@react-router/dev/routes";

// export default createBrowserRouter([
//   {
//     path: "/",
//     children: [
//       {
//         index: true,
//         Component: Login,
//       },
//       {
//         path: "login",
//         Component: Login,
//       },
//       {
//         path: "welcome/:name",
//         Component: Welcome,
//       },
//       {
//         path: "todos",
//         Component: TodoList,
//       },
//     ],
//   },
// ]);

export default [
  index("./components/Login"),
  route("login", "./components/Login"),
  route("welcome/:name", "./components/Welcome"),
  route("todos", "./components/todo/TodoList"),
] satisfies RouteConfig;