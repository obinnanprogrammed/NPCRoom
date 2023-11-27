import React from "react";
import {useState} from 'react';
import { useNavigate } from "react-router-dom";
import axios from "axios";
import './Chat.css'

const Chat = (props) => {
  const navigate = useNavigate();

  const [textInput, setTextInput] = useState('');
  const [response, setResponse] = useState('');

  const responseMaker = (e) => {
    e.preventDefault()
    Promise.resolve(axios.post("https://npcroom-processing.onrender.com", textInput)).then(() => {
      console.log("message has been sent")
      Promise.resolve(axios.get("https://npcroom-processing.onrender.com")).then((res) => {
        setResponse(response + "You: " + textInput + "\n" + "NPC: " + res.data);
      })
    }).catch((err) => {
      console.log("failed")
      console.log(err.message)
    })
  }
  
  return (
    <>
      <button class = 'btn' onClick={() => navigate(-1)}>Go Back</button>
      <div>
        <form class="form" onSubmit={responseMaker}>
          <textarea onChange={(e) => {setTextInput(e.target.value); }}></textarea>
          <input type="Submit" value="Send"></input>
        </form>
        <p className="body" style={{whiteSpace: "pre-line"}}>{response}</p>
      </div>
    </>
  );
};

export default Chat;