package com.hackyeah.pkpService.controllers;

import com.hackyeah.pkpService.entities.LostItem;
import com.hackyeah.pkpService.services.LostItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lost-items")
public class LostItemController {

    private LostItemService lostItemService;

    public LostItemController(LostItemService lostItemService) {
        this.lostItemService = lostItemService;
    }

    @RequestMapping(value = "byUserId")
    public List<LostItem> findAllByUserId(@RequestParam String userId) {
        return lostItemService.findAllByUserId(userId);
    }
}
