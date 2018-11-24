package com.hackyeah.pkpService.repositories;

import com.hackyeah.pkpService.entities.LostItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LostItemRepository extends MongoRepository<LostItem, String> {
    Optional<LostItem> findById(String id);
    Optional<LostItem> findByUserId(String userId);
}
