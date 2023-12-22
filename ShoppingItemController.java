package com.anand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anand.entity.ShoppingItem;
import com.anand.service.ShoppingItemService;

@RestController
@RequestMapping("/api/shopping-items")
public class ShoppingItemController {

 @Autowired
 private ShoppingItemService shoppingItemService;

 @PostMapping
 public ResponseEntity<ShoppingItem> addShoppingItem(@RequestBody ShoppingItem shoppingItem) {
     double totalPriceWithGST = shoppingItem.calculateTotalPriceWithGST();
     shoppingItem.setTotalPriceWithGST(totalPriceWithGST);

     ShoppingItem newItem = shoppingItemService.createShoppingItem(shoppingItem);
     return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
 }

 @GetMapping
 public List<ShoppingItem> getAllShoppingItems() {
     return shoppingItemService.getAllShoppingItems();
 }
}

