import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => (
  <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
    <div className="container-fluid">
      <Link className="navbar-brand" to="/">Cricket Team</Link>
      <div>
        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
        <li className="nav-item">
            <Link className="nav-link" to="/players">Players</Link>
            
        </li>
        <li className="nav-item">
            <Link className="nav-link" to="/add">Add Player</Link>
        </li>
        </ul>
        </div>
      </div>
      </nav>
);
export default Navbar;

