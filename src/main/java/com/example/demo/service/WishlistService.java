package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.Wishlist;
import com.example.demo.repository.WishlistRepository;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishListRepository;

    public List<Wishlist> getAllItems() {
        return wishListRepository.findAll();
    }

    public Wishlist addItem(Wishlist item) {
        return wishListRepository.save(item);
    }

    public Wishlist updateItem(Long id, Wishlist updatedItem) {
        Wishlist existingItem = wishListRepository.findById(id).orElse(null);
        if (existingItem != null) {
            existingItem.setItemName(updatedItem.getItemName());
            existingItem.setPrice(updatedItem.getPrice());
            existingItem.setDiscount(updatedItem.getDiscount());
            existingItem.setRating(updatedItem.getRating());
            existingItem.setBrand(updatedItem.getBrand());
            return wishListRepository.save(existingItem);
        }
        return null;
    }

    public void deleteItem(Long id) {
        wishListRepository.deleteById(id);
    }
}