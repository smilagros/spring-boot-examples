package com.testing.unittesting.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testing.unittesting.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
