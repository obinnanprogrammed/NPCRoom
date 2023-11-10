import React from "react";
import { useNavigate } from "react-router-dom";
import './Chat.css'

const Chat = (props) => {
  const navigate = useNavigate();
  return (
    <>
      <h1 class = 'title'>Chat</h1>
      <br />
      <button class = 'btn' onClick={() => navigate(-1)}>Go Back</button>
    </>

   
  );
};

export default Chat;