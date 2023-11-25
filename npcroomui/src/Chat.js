import React from "react";
import {useState} from 'react';
import { useNavigate } from "react-router-dom";
import axios from "axios";
import './Chat.css'

const Chat = (props) => {
  const navigate = useNavigate();

  const [textInput, setTextInput] = useState('');
  const [response, setResponse] = useState('');

  /*const handleTextInputChange = event => {
    setTextInput(event.target.value);
  };*/

  const responseMaker = (e) => {
    e.preventDefault()
    Promise.resolve(axios.post("http://localhost:8080", textInput)).then(() => {
      console.log("message has been sent")
      Promise.resolve(axios.get("http://localhost:8080")).then((res) => {
        setResponse(response + res.data);
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
        <form onSubmit={responseMaker}>
          <textarea onChange={(e) => {setTextInput(e.target.value); }}></textarea>
          <input type="Submit" value="Send"></input>
        </form>
        <p className="body">{response}</p>
      </div>
    </>
  );
};

export default Chat;