package alvaro.parcial2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

/**
 * Controlador para manejar las solicitudes relacionadas con los "items".
 * Esta clase está mapeada para responder a las solicitudes bajo la ruta "/items".
 *
 * @author [Tu Nombre]
 * @version 1.0
 */
@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    /**
     * Constructor de la clase ItemController.
     * Se inyecta el servicio de items para acceder a las operaciones de negocio.
     *
     * @param itemService el servicio para gestionar los items
     */
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /**
     * Método que maneja las solicitudes GET a la ruta "/items".
     * Recupera todos los items y los agrega al modelo para ser mostrados en la vista.
     *
     * @param model el modelo que se pasa a la vista
     * @return el nombre de la vista a mostrar (en este caso, "items")
     */
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "items";
    }

    /**
     * Método que maneja las solicitudes GET a la ruta "/items/{id}".
     * Recupera un item por su ID y lo agrega al modelo para ser mostrado en la vista de detalle.
     * Si el item no se encuentra, redirige a la lista de items.
     *
     * @param id el identificador del item a mostrar
     * @param model el modelo que se pasa a la vista
     * @return el nombre de la vista a mostrar, o redirige a la lista de items si el item no es encontrado
     */
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
