import logo from "./logo.svg";
import "./App.css";

import { BrowserRouter, Route, Routes } from "react-router-dom";
import Navbar from "./component/Navbar";

import "react-toastify/dist/ReactToastify.css";
import { Footer } from "./component/Footer";

function App() {
  return (
    <div>
      <body>
        <BrowserRouter>
          <Navbar></Navbar>
          <Footer></Footer>
        </BrowserRouter>
      </body>
    </div>
  );
}

export default App;
