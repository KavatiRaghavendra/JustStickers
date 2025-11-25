import "./App.css";
import Home from "./components/Home.jsx";
import Header from "./components/Header.jsx";
import Footer from "./components/Footer.jsx";
import { Outlet, useNavigate, useNavigation } from "react-router-dom";
import { use } from "react";
import { StrictMode } from "react";
function App() {
  var navigataion = useNavigation();

  return (
    <>
      <Header />
      {navigataion.state === "loading" ? (
        <div className="min-h-[852px] flex items-center justify-center px-6 py-8 font-primary bg-normalbg dark:bg-darkbg">
          <div className="text-center">
            <div className="loader mb-4"></div>
            <p className="text-lg text-primary dark:text-light">
              Loading, please wait...
            </p>
          </div>
        </div>
      ) : (
        <Outlet />
      )}

      <Footer />
    </>
  );
}

export default App;
