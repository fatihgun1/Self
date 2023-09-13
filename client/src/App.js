import React from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import { createBrowserRouter, RouterProvider, Route, Outlet } from 'react-router-dom'
import Navbar from "./general/Navbar";
import SideBar from "./general/SideBar";
import ProjectPage from "./page/ProjectPage";
import CreateProjectPage from "./page/CreateProjectPage";
import CreateAreaPage from "./page/CreateAreaPage";
import AreaPage from "./page/AreaPage";
import CreateStatusPage from "./page/CreateStatusPage";
import StatusManage from "./component/status/StatusManage";
import CreateCardPage from "./page/CreateCardPage";
import CardDetailPage from "./page/CardDetailPage";
const Layout = () => {
  const test = null;
  return (
    <div className="col m-0 p-0 ">
      <div className="row">
        <div className="col">
          <Navbar />
        </div>
      </div>

      <div className="row w-100">
        <div className="col-3">
          <SideBar />
        </div>
        <div className="col-8 m-4">
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
      },
      {
        path: "/area",
        element: <AreaPage />
      },
      {
        path: "/status/create",
        element: <CreateStatusPage />
      },
      {
        path: "/status/manage",
        element: <StatusManage />
      },      
      {
        path: "/card/create/:code",
        element: <CreateCardPage />
      },      
      {
        path: "/card/get/:code",
        element: <CardDetailPage />
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
