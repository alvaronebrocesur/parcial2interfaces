package alvaro.parcial2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "items";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable int id, Model model) {
        Optional<Item> hotel = itemService.findItemById(id);
        if (hotel.isPresent()) {
            Item item = hotel.get();
            model.addAttribute("item", item);
            return "detalle";
        }
        return "redirect:/items";
    }
}
