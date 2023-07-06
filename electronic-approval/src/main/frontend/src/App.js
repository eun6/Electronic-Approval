import React from 'react';
import './App.css'
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "./pages/Home";
import Read from "./pages/Read";
import Write from "./pages/Write";

function App() {
  return (
      <div>
          <BrowserRouter>
              <Routes>
                  <Route path={"/"} element={<Home />}></Route>
                  <Route path={"/document/get"} element={<Read />}></Route>
                  <Route path={"/document/post"} element={<Write />}></Route>
              </Routes>
          </BrowserRouter>
      </div>
  );
}
export default App;