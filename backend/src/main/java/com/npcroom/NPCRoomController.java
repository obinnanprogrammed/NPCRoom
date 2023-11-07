package com.npcroom;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

@RestController

public class NPCRoomController {

    @RequestMapping
    public String processStatement() {
        Map<String, String> statements = Statements.populateMap();
        String statement = "I'm good, how are you"; // for testing purposes

        if(Statements.checkFilter(statement.toLowerCase())) {
            return "That's a bit inappropriate. Let's talk about something else.";
        }

        StringBuilder res = new StringBuilder();

        for(String message : statements.keySet()) {
            if (statement.toLowerCase().contains(message)) {
                res.append(statements.get(message) + "\n");
            }
        }

        if(res.toString().equals("")) {
            return "I don't know what to say to that.";
        }
        return res.toString();
    }
}

class Statements {
    private static Map<String, String> statementMap = new HashMap<String, String>();
    private static String[] filter = {}; // offensive/inappropriate comments will be censored.

    public static Map<String, String> populateMap() {
        statementMap.putIfAbsent("how are you", "I'm good, thanks for asking!");
        statementMap.putIfAbsent("i'm good", "That's good to hear!");
        statementMap.putIfAbsent("not good", "I'm sorry. Care to talk abt it");
        statementMap.putIfAbsent("where are you from", "somewhere");
        statementMap.putIfAbsent("when were you born", "dude stop");
        statementMap.putIfAbsent("you suck", "you suck harder");
        statementMap.putIfAbsent("what is your opinion on artificial intelligence", "REEEEEEE");
        statementMap.putIfAbsent("what are you doing", "Talking to you ;)");
        statementMap.putIfAbsent("what are your interests", "What interests, I'm a loser who" +
                "scrolls Reddit on the daily.");
        statementMap.putIfAbsent("what do you like to do", "Scroll Reddit");
        statementMap.putIfAbsent("can we play a game", "Sure!");
        statementMap.putIfAbsent("i love you", "Wow...I never get that. I love you too!");
        statementMap.putIfAbsent("i hate you", "Of course you would say that");
        statementMap.putIfAbsent("what am i supposed to do with this", "I dunno?");

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