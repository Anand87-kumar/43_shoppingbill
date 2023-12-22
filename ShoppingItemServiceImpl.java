package com.anand.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.entity.ShoppingItem;
import com.anand.repository.ShoppingItemRepository;
import com.anand.service.ShoppingItemService;

@Service
public class ShoppingItemServiceImpl implements ShoppingItemService {

    @Autowired
    private ShoppingItemRepository shoppingItemRepository;

    @Override
    public ShoppingItem createShoppingItem(ShoppingItem shoppingItem) {
        return shoppingItemRepository.save(shoppingItem);
    }

    @Override
    public List<ShoppingItem> getAllShoppingItems() {
        return shoppingItemRepository.findAll();
    }
}