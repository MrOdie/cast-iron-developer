import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

// Partials
import Nav from "./Components/Partials/Nav";
import Footer from "./Components/Partials/Footer";

// Pages
import Home from "./Components/Pages/Home";
import About from "./Components/Pages/About";

import styles from "./Assets/Sass/Modules/App.module.scss";

import "./Assets/Sass/style.scss";
import "./Assets/Fonts/Typography.css";

const App = () => (
  <>
    <Router>
      <main className={styles.Main}>
        <section className={styles.Nav}>
          <Nav />
        </section>
        <section className={styles.Body}>
          <Routes>
            <Route exact path="/" element={<Home />}></Route>
            <Route path="/about" element={<About />}></Route>
          </Routes>
          <Footer />
        </section>
      </main>
    </Router>
  </>
);

export default App;
