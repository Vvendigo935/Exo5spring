package org.example.exo5spring.controler;

import jakarta.validation.Valid;
import org.example.exo5spring.dao.FurnitureRepository;
import org.example.exo5spring.entity.Furniture;
import org.example.exo5spring.service.CartItemService;
import org.example.exo5spring.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FurnitureControler {

private final FurnitureService furnitureService;
private final CartItemService cartItemService;


    public FurnitureControler(FurnitureService furnitureService, CartItemService cartItemService) {
        this.furnitureService = furnitureService;
        this.cartItemService = cartItemService;
    }

    @GetMapping
    public String home(){
        return "home";
    }

@GetMapping("/list")
    public String list(Model model){
        model.addAttribute("furnitures",furnitureService.getAllFurniture());
        return "furnitureList";
}

@GetMapping("/addFuStart")
public String addFuStart(Model model){
        model.addAttribute("furniture", new Furniture());
        model.addAttribute("cartItems", cartItemService.getAllCartItems());
        return "addFurniture";
}

@GetMapping("/updateFu")
    public String updateFu(@RequestParam("id")Long id, Model model){
        Furniture furniture = furnitureService.getFurnitureById(id);
        model.addAttribute("furniture", furniture);
        model.addAttribute("cartItems", cartItemService.getAllCartItems());
        return "addFurniture";
}

@PostMapping("/addFu")
public String addFu(@Valid @ModelAttribute("furniture") Furniture furniture, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("cartItem", cartItemService.getAllCartItems()); // verifier si on se trompe pas ici
            return "addFurniture";
        }else {
            if (furniture.getId() != null) {
                furnitureService.updateFurniture(furniture);
            }else {
                furnitureService.createFurniture(furniture);
            }
            return "redirect:furnitureList";
        }
}

@GetMapping("/delete")
    public String delete(@RequestParam("id")Long id){
        furnitureService.delete(furnitureService.getFurnitureById(id));
        return "redirect:furnitureList";
}




}


//
//    @GetMapping("/delete")
//    public String delete(@RequestParam("id")Long id){
//        furnitureService.delete(id);
//        return "redirect:/furniture/list";
//    }