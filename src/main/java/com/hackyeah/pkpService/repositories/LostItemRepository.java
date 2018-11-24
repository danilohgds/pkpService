package com.hackyeah.pkpService.repositories;

import com.hackyeah.pkpService.entities.LostItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LostItemRepository extends MongoRepository<LostItem, String> {
    Optional<LostItem> findById(String id);
    List<LostItem> findAllByUserId(String userId);
    List<LostItem> findAllByTripId(String tripId);
}
