package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
}