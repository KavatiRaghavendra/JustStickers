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
import ProductDetail from "./components/ProductDetail.jsx";
import Register, { registerAction } from "./components/Register.jsx";
//import { CartProvider } from "./store/cart-context.jsx";

import Profile, {
  profileLoader,
  profileAction,
} from "./components/Profile.jsx";
import ProtectedRoute from "./components/ProtectedRoute.jsx";
import { loginAction } from "./components/Login.jsx";
import { AuthProvider } from "./store/auth-context.jsx";
import "react-toastify/dist/ReactToastify.css";
import { use, useContext } from "react";
import Cart from "./components/cart.jsx";
import { contactLoader } from "./components/Contact.jsx";
import CheckoutForm from "./components/CheckoutForm.jsx";
import { checkoutAction } from "./components/CheckoutForm.jsx";
import OrderSuccess from "./components/OrderSuccess.jsx";
import { checkoutprofileLoader } from "./components/CheckoutForm.jsx";
import Orders, { ordersLoader } from "./components/Orders.jsx";
import { Provider } from "react-redux";
import Messages, { messagesLoader } from "./components/admin/Messages.jsx";
import AdminOrders, {
  adminOrdersLoader,
} from "./components/admin/AdminOrders.jsx";
import store from "./store/store.js";
const routeDefinitions = createRoutesFromElements(
  <Route path="/" element={<App />} errorElement={<ErrorPage />}>
    <Route index element={<Home />} loader={productsLoader} />
    <Route path="home" element={<Home />} loader={productsLoader} />
    <Route path="about" element={<About />} />
    <Route
      path="contact"
      element={<Contact />}
      action={contactAction}
      loader={contactLoader}
    />
    <Route path="login" element={<Login />} action={loginAction} />
    <Route path="/products/:productId" element={<ProductDetail />} />
    <Route path="register" element={<Register />} action={registerAction} />
    <Route path="cart" element={<Cart />} />

    <Route element={<ProtectedRoute />}>
      <Route path="OrderSuccess" element={<OrderSuccess />} />
      <Route
        path="/profile"
        element={<Profile />}
        loader={profileLoader}
        action={profileAction}
        shouldRevalidate={({ actionResult }) => {
          return !actionResult?.success;
        }}
      />
      <Route path="/orders" element={<Orders />} loader={ordersLoader} />
      <Route
        path="/checkout"
        element={<CheckoutForm />}
        action={checkoutAction}
        loader={checkoutprofileLoader}
      />
      <Route
        path="/admin/orders"
        element={<AdminOrders />}
        loader={adminOrdersLoader}
      />
      <Route
        path="/admin/messages"
        element={<Messages />}
        loader={messagesLoader}
      />
    </Route>
  </Route>
);

const appRouter = createBrowserRouter(routeDefinitions);

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <AuthProvider>
      {/* //  <CartProvider> */}
      <Provider store={store}>
        <RouterProvider router={appRouter} />
      </Provider>
      {/* </CartProvider> */}
    </AuthProvider>
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
