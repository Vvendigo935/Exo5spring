package org.example.exo5spring.controler;

import org.example.exo5spring.service.CartItemService;
import org.example.exo5spring.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartItemControler {
    private final FurnitureService furnitureService;
    private final CartItemService cartItemService;

    public CartItemControler(FurnitureService furnitureService, CartItemService cartItemService) {
        this.furnitureService = furnitureService;
        this.cartItemService = cartItemService;
    }

    @GetMapping("/cart")
    public String showCart(Model model){
        model.addAttribute("furnitures",furnitureService.getAllFurniture());
        return "cart";
    }



}
// showCart