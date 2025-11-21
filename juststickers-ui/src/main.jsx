import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App.jsx";
import {
  createBrowserRouter,
  RouterProvider,
  createRoutesFromElements,
  Route,
} from "react-router-dom";
import { ToastContainer, Bounce } from "react-toastify";
import Home from "./components/Home.jsx";
import ErrorPage from "./components/ErrorPage.jsx";
import About from "./components/About.jsx";
import React from "react";
import { productsLoader } from "./components/Home.jsx";
import Contact from "./components/Contact.jsx";
import { contactAction } from "./components/Contact.jsx";
import Login from "./components/Login.jsx";

const routeDefinitions = createRoutesFromElements(
  <Route path="/" element={<App />} errorElement={<ErrorPage />}>
    <Route index element={<Home />} loader={productsLoader} />
    <Route path="home" element={<Home />} loader={productsLoader} />
    <Route path="about" element={<About />} />
    <Route path="contact" element={<Contact />} action={contactAction} />
    <Route path="login" element={<Login />} />
  </Route>
);

const appRouter = createBrowserRouter(routeDefinitions);

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <RouterProvider router={appRouter} />
    <ToastContainer
      position="top-center"
      autoClose={5000}
      hideProgressBar={false}
      newestOnTop={false}
      closeOnClick={false}
      rtl={false}
      pauseOnFocusLoss
      draggable
      pauseOnHover
      theme={localStorage.getItem("theme") === "dark" ? "dark" : "light"}
      transition={Bounce}
    />
  </StrictMode>
);
