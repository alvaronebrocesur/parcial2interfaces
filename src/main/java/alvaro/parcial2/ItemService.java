package alvaro.parcial2;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de elementos (Items).
 * Proporciona métodos para realizar operaciones CRUD sobre los elementos.
 */
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    /**
     * Constructor de ItemService.
     *
     * @param itemRepository Repositorio de elementos para la gestión de datos.
     */
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /**
     * Recupera todos los elementos disponibles.
     *
     * @return Lista de todos los elementos.
     */
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    /**
     * Busca un elemento por su ID.
     *
     * @param id Identificador del elemento a buscar.
     * @return Un Optional que contiene el elemento si se encuentra.
     */
    public Optional<Item> findItemById(int id) {
        return itemRepository.findById(id);
    }
}
