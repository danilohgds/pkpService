package com.hackyeah.pkpService.services;

import com.hackyeah.pkpService.entities.LostItem;
import com.hackyeah.pkpService.repositories.LostItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LostItemService {

    private LostItemRepository lostItemRepository;

    @Autowired
    public LostItemService(LostItemRepository lostItemRepository) {
        this.lostItemRepository = lostItemRepository;
    }

    public LostItem create(LostItem lostItem) {
        return lostItemRepository.save(lostItem);
    }

    public List<LostItem> findAll() {
        return lostItemRepository.findAll();
    }

    public List<LostItem> findAllByUserId(String userId) {
        return lostItemRepository.findAllByUserId(userId);
    }

    public Optional<LostItem> findLostItem(String id) {
        return lostItemRepository.findById(id);
    }
}
