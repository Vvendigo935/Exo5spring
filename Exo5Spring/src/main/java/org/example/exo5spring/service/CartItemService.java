package org.example.exo5spring.service;

import org.example.exo5spring.dao.CartItemRepository;
import org.example.exo5spring.entity.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

private final CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public CartItem addCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }
    public CartItem updateCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }
    public void deleteOneCartItem(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }
    public void clearCart(List<CartItem> cartItems) {
        cartItemRepository.deleteAll(cartItems);
    }
    public CartItem getCartItemById(Long id) {
        return cartItemRepository.findById(id).orElse(null);
    }
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }
}