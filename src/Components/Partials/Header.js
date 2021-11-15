import React from "react";
import styles from "../../Assets/Sass/Modules/Header.module.scss";

const Header = () => (
  <header className={styles.header}>
    <div className={styles.innerHeader}>
      <h1 className={styles.heading}>Cast Iron Developer</h1>
    </div>
  </header>
);

export default Header;
