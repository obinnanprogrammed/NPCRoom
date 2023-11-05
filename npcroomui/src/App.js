import './App.css';


function App() {
  return (
    <div className="App">
      <header className="App-header">
      <h3 className="title">Welcome to the NPCRoom!</h3>
        <img src="https://upload.wikimedia.org/wikipedia/en/1/1b/NPC_wojak_meme.png" className = "image" alt="NPC logo"></img>
        <p className="body">The NPCRoom is a NPC chatroom that allows
          users to type in the chat and get a pre-populated
          response from an NPC.
        </p>
        <button className="btn">Get started</button>
      </header>
    </div>
  );
}

export default App;
