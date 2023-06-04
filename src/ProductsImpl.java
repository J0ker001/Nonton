import java.util.*;


public class ProductsImpl implements Products {


    private final Map<String, String> basket = new TreeMap<>();

    @Override
    public boolean addProduct(Product product) {
        if (product != null && !basket.containsKey(product.getId())) {
            basket.put(product.getId(), product.getName());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProduct(Product product) {
        if (product != null && basket.containsKey(product.getId())) {
            basket.remove(product.getId());
            return true;
        }
        return false;
    }

    @Override
    public String getName(String id) {
        if (id != null && basket.containsKey(id)) {
            return basket.get(id);
        }
        return "";
    }

    @Override
    public List<String> findByName(String name) {
        return basket.entrySet().stream().filter(n -> n.getValue().equals(name)).map(Map.Entry::getKey).toList();
    }
}
