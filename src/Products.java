import java.util.List;

public interface Products {

    boolean addProduct(Product product);

    boolean deleteProduct(Product product);

    String getName(String id);

    List<String> findByName(String name);
}
