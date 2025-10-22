package com.gsc.enrichment.Items;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ItemRepository extends JpaRepository<Item, Long>{

    List<Item> findByIsAvailable(boolean isAvailable);

    List<Item> findByName(String name);
    
}
