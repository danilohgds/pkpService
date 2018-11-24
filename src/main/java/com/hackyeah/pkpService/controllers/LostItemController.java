package com.hackyeah.pkpService.controllers;

import com.hackyeah.pkpService.entities.LostItem;
import com.hackyeah.pkpService.services.LostItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lost-items")
public class LostItemController {

    private LostItemService lostItemService;

    public LostItemController(LostItemService lostItemService) {
        this.lostItemService = lostItemService;
    }

    @RequestMapping(value = "byUserId", method = RequestMethod.GET)
    public List<LostItem> findAllByUserId(@RequestParam String userId) {
        return lostItemService.findAllByUserId(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public LostItem create(@RequestBody LostItem lostItem) {
        return lostItemService.create(lostItem);
    }
}
