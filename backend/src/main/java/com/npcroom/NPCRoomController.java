package com.npcroom;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

@RestController
public class NPCRoomController {
    @RequestMapping
    public String index() { return "Default"; }
}

class Statements {
    private Map<String, String> statementMap;

    // consider adding a filter ArrayList

    public Map<String, String> populateMap() {
        statementMap.putIfAbsent("how are you", "I'm good, thanks for asking!");
        statementMap.putIfAbsent("i'm good", "That's good to hear!");
        statementMap.putIfAbsent("not good", "I'm sorry. Care to talk abt it");
        // above are starters, definitely add more

        return statementMap;
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