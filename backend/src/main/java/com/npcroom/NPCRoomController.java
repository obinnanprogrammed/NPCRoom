package com.npcroom;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping
public class NPCRoomController {

    private String result;

    @PostMapping
    public void processStatement(@RequestBody String message) {

        Map<String, String> statements = Statements.populateMap();
         // String statement = "I'm good, how are you"; // for testing purposes
        String msg = message.replaceAll("\\+", " ").substring(0, message.length());
        StringBuilder res = new StringBuilder();

        if(Statements.checkFilter(msg.toLowerCase())) {
            res.append("That's a bit inappropriate. Let's talk about something else.");
        } else {
            if(msg.contains("homework")) {
                res.append("Ugh, homework sucks. Don't make me do yours." + "\n");
            }
            for(String keywords : statements.keySet()) {
                if (msg.toLowerCase().contains(keywords)) {
                    res.append(statements.get(keywords) + "\n");
                }
            }

            if(res.toString().equals("")) {
                res.append("I don't know what to say to that.");
            }
        }
        /*
            System.out.println(message);
            System.out.println(res.toString()); */
        result = res.toString();
    }

    @GetMapping
    public String index() { return result; }
}

class Statements {
    private static Map<String, String> statementMap = new HashMap<String, String>();
    private static String[] filter = { "nigger", "nigga", "faggot", "fag",
            "chink", "beaner", "cotton picker" }; // offensive/inappropriate comments will be censored.

    public static Map<String, String> populateMap() {
        statementMap.putIfAbsent("hello" , "Hello!");
        statementMap.putIfAbsent("how are you", "I'm good, thanks for asking!");
        statementMap.putIfAbsent("i'm good", "That's good to hear!");
        statementMap.putIfAbsent("not good", "I'm sorry. Care to talk abt it");
        statementMap.putIfAbsent("where are you from", "somewhere");
        statementMap.putIfAbsent("when were you born", "dude stop");
        statementMap.putIfAbsent("you suck", "you suck harder");
        statementMap.putIfAbsent("what is your opinion on artificial intelligence", "REEEEEEE");
        statementMap.putIfAbsent("what are you doing", "Talking to you ;)");
        statementMap.putIfAbsent("what are your interests", "What interests, I'm a loser who" +
                " scrolls Reddit on the daily.");
        statementMap.putIfAbsent("what do you like to do", "Scroll Reddit");
        statementMap.putIfAbsent("can we play a game", "Sure!");
        statementMap.putIfAbsent("i love you", "Wow...I never get that. I love you too!");
        statementMap.putIfAbsent("i hate you", "Of course you would say that");
        statementMap.putIfAbsent("what am i supposed to do with this", "I dunno?");
        statementMap.putIfAbsent("what is 1 + 1", "2");
        statementMap.putIfAbsent("what is your opinion of tu?", "Horns down.");
        statementMap.putIfAbsent("i love you", "Awww....");
        statementMap.putIfAbsent("are you okay?", "Of course I am!");
        statementMap.putIfAbsent("what am I not allowed to say to you?", "I have a secret filter.");
        statementMap.putIfAbsent("what do you think of acc", "ACC best club");
        statementMap.putIfAbsent("how old are you", "Old enough?");

        /* essentially the gist of populateMap() is above. Add more statements as we go into and
        work in stage 2 of the coding process. */
        return statementMap;
    }

    public static boolean checkFilter(String statement) {
        String[] words = statement.split(" ");
        for(String word : words) {
            if(Arrays.asList(filter).contains(word)) {
                return true;
            }
        }
        return false;
    }
}
/*
    I think I see what's going on here!
    Anyways, let's set up a skeleton:

    receive message as a String

    how to determine what to say?
    if word contains some certain phrase, assign response based on phrase.
    We can start simple such as:
        NPC: Hello! How are you?
        User: Good, how about you?
            "how about you" -> NPC: I'm good, thanks!
            "good" -> NPC: that's good to hear!
            (let's not worry about chaining potential responses for now)
    return appropriately cased phrase
 */