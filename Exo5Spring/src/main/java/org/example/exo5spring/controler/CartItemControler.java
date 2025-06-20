package org.example.exo5spring.controler;

import jakarta.validation.Valid;
import org.example.exo5spring.entity.CartItem;
import org.example.exo5spring.entity.Furniture;
import org.example.exo5spring.service.CartItemService;
import org.example.exo5spring.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartItemControler {
    private final FurnitureService furnitureService;
    private final CartItemService cartItemService;

    public CartItemControler(FurnitureService furnitureService, CartItemService cartItemService) {
        this.furnitureService = furnitureService;
        this.cartItemService = cartItemService;
    }

    @GetMapping("/showCart")
    public String showCart(Model model){
        model.addAttribute("furnitures",furnitureService.getAllFurniture());
        return "cart";
    }

    @PostMapping("/addCa")
    public String addCu(@Valid @ModelAttribute("cartItem") CartItem cartItem, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("furniture",furnitureService.getAllFurniture());
            return "cart";
        }else {
            if (cartItem.getId() != null) {
                cartItemService.updateCartItem(cartItem);
            }else {
                cartItemService.addCartItem(cartItem);
            }
            return "redirect:cart";
        }
    }





}
// showCart