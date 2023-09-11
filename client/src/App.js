import React from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import { createBrowserRouter, RouterProvider, Route, Outlet } from 'react-router-dom'
import Navbar from "./general/Navbar";
import SideBar from "./general/SideBar";
import ProjectPage from "./page/ProjectPage";
import CreateProjectPage from "./page/CreateProjectPage";
import CreateAreaPage from "./page/CreateAreaPage";
const Layout = () => {
  const test = null;
  return (
    <div className="container m-0 p-0">
      <div className="row">
        <div className="col">
          <Navbar />
        </div>
      </div>

      <div className="row ">
        <div className="col-4">
          <SideBar />
        </div>
        <div className="col m-4">
          <Outlet />
        </div>
      </div>
    </div>
  );
}

const router = createBrowserRouter(
  [{
    path: "/",
    element: <Layout />,
    children: [
      {
        path: "/",
        element: <ProjectPage />
      },
      {
        path: "/project/create",
        element: <CreateProjectPage />
      },
      {
        path: "/area/create",
        element: <CreateAreaPage />
      }
    ]
  }

  ]
);
function App() {
  return (
    <div className="App">
      <RouterProvider router={router} />
    </div>
  );
}

export default App;
