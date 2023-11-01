package com.npcroom;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class NPCRoomController {
    @RequestMapping
    public String index() { return "Default"; }
}
