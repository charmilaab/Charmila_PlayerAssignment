import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Home from "./pages/Home";
import Players from "./pages/Players";
import AddPlayer from "./pages/AddPlayer";
import EditPlayer from "./pages/EditPlayer";
function App() {
  return (
    <Router>
      <Navbar />
      <div className="container mt-4">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/players" element={<Players />} />
          <Route path="/add" element={<AddPlayer />} />
          <Route path="/edit/:id" element={<EditPlayer />} />
        </Routes>
      </div>
    </Router>
  );
}
export default App;

