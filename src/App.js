import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

// Partials
import Header from "./Components/Partials/Header";
import Footer from "./Components/Partials/Footer";

// Pages
import Home from "./Components/Pages/Home";
import About from "./Components/Pages/About";

import "./Assets/Sass/style.scss";
import "./Assets/Fonts/Typography.css";

const App = () => (
  <>
    <Router>
      <Header />
      <Link to="/">Home</Link>
      <Link to="/about">Test</Link>
      <Routes>
        <Route exact path="/" element={<Home />}></Route>
        <Route path="/about" element={<About />}></Route>
      </Routes>
      <Footer />
    </Router>
  </>
);

export default App;
