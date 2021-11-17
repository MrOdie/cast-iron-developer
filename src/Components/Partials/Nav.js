import React from "react";
import styles from "../../Assets/Sass/Modules/Header.module.scss";
import { Link } from "react-router-dom";

const Nav = () => (
  <header className={styles.Header}>
    <div className={styles.InnerHeader}>
      <h1 className={styles.Heading}>Cast Iron Developer</h1>
      <nav className={styles.Nav}>
        <Link className={styles.NavLink} to="/">Home</Link>
        <Link className={styles.NavLink} to="/about">Test</Link>
      </nav>
    </div>
  </header>
);

export default Nav;
