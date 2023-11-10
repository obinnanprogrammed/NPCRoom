import React from "react";
import { useNavigate } from "react-router-dom";
import './Home.css'

const Home = (props) => {
  const navigate = useNavigate();

  return (
    <>
    <header className="Home-header">
    <h3 className="title">Welcome to the NPCRoom!</h3>
      <img src="https://upload.wikimedia.org/wikipedia/en/1/1b/NPC_wojak_meme.png" className = "image" alt="NPC logo"></img>
      <p className="body">The NPCRoom is a NPC chatroom that allows
          users to type in the chat and get a pre-populated
          response from an NPC.
      </p>
      <p>
        <button className = "btn" onClick={() => navigate("/chat")}>Get started</button>
      </p>
    </header>
    </>
  );
};

export default Home;