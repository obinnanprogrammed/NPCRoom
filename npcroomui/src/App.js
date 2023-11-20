import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Home from "./Home";
import Chat from "./Chat";
import './App.css'
import './Home.css'
import './Chat.css'

const App = () => {
  return (

      <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/chat" element={<Chat />} />
        </Routes>
      </Router>
  );
};

export default App;

