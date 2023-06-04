import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductsImplTest {

    private final ProductsImpl products = new ProductsImpl();
    Product milk = new Product("one", "milk");
    Product bread = new Product("two", "bread");
    Product chocolate = new Product("three", "chocolate");

    @BeforeEach
    public void initEach() {
        products.addProduct(milk);
        products.addProduct(bread);
    }


    @Test
    void shouldReturnTrueWhenAdded() {
        assertTrue(products.addProduct(chocolate));
    }

    @Test
    void shouldReturnFalseWhenAddedTwice() {
        assertFalse(products.addProduct(milk));
    }

    @Test
    void shouldReturnTrueWhenDeletedProduct() {
        assertTrue(products.deleteProduct(milk));
    }

    @Test
    void shouldReturnFalseWhenNotFoundProduct() {
        products.deleteProduct(milk);
        assertFalse(products.deleteProduct(milk));
    }

    @Test
    void shouldReturnMilkWhenIdEqualsOne() {
        assertEquals(products.getName("one"), "milk");
    }

    @Test
    void shouldReturnEmptyLineWhenIdIncorrect() {
        assertEquals(products.getName("three"), "");
    }

    @Test
    void shouldReturnOneValueWhenLookingForMilk() {
        List<String> ids = products.findByName("milk");
        assertEquals(1, ids.size());
        List<String> expectList = new ArrayList<>();
        expectList.add("one");
        assertEquals(expectList, ids);
    }
}