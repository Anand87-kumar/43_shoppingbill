package com.anand.service;

import java.util.List;

import com.anand.entity.ShoppingItem;

public interface ShoppingItemService {
    ShoppingItem createShoppingItem(ShoppingItem shoppingItem);
    List<ShoppingItem> getAllShoppingItems();
}
