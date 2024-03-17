import React from "react";
import { useNavigate } from "react-router-dom";
import './Home.css'
import Button from '@mui/material/Button';
import { Box, Typography } from "@mui/material";
import NPCLogo from './NPCLogo.png';



const Home = (props) => {
  const navigate = useNavigate();

  return (

    <Box className="Home-header" >
      <Box sx={{
        display: 'flex',    // Enables Flexbox
        alignItems: 'center', // Vertically aligns items in the center
        justifyContent: 'center', // Horizontally aligns items at the start
        gap: '20px',       // Optional: adds space between items
        // Other styling as needed
      }}>
        <Typography variant="h2" sx={{
          padding: '20px', // Add padding on top
          margin: '20px',  // Push downward 
        }}
          className="Home_title">Welcome to the NPCRoom!


        </Typography>

        <img src={NPCLogo} alt="NPC Logo" className="logoImage"></img>

      </Box>

      
      {<img src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimg.freepik.com%2Fvetores-premium%2Femoji-de-cara-de-nerd-emoticon-inteligente-com-oculos-geek-ou-estudante_3482-1193.jpg%3Fw%3D2000&f=1&nofb=1&ipt=971bb67d62d087ec24216eed694f454099147496f70757a7b4f19ba7f1affbd2&ipo=images" className="image" alt="NPC"></img>}
      <Typography variant="h6" className="body" color={"black"}
        sx={{
          margin: '10px',
          padding: '25px',
        }
        }>The NPCRoom is a NPC chatroom that allows
        users to type in the chat and get a pre-populated
        response from an NPC.
      </Typography>

      <Button
        variant="outlined"
        color="secondary"
        sx={{
          padding: '10px 20px', // Custom padding
          border: 2,
          transition: 'all 0.2s ease',
          '&:hover': {
            opacity: '70%',
            boxShadow: 3,
            border: 2,

          },


        }}

        onClick={() => navigate("/login")}
      >
        Get Started
      </Button>

    </Box>

  );
};

export default Home;