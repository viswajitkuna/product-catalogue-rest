import com.sample.dao.domain.Product;
import com.sample.dao.impl.ProductDaoImpl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProductDaoTest {

    @InjectMocks
    private ProductDaoImpl productDao;

    @Mock
    private EntityManager entityManager;

    @Mock
    private Query query;

    private List<Product> products;

    private Product product;

    private static final int INITIAL_QUANTITY = 30;

    @Before
    public void setUp() {
        products = new ArrayList<Product>();
        product = new Product(1, "Samsung TV", INITIAL_QUANTITY);
        products.add(product);
        products.add(new Product(2, "Sony TV", INITIAL_QUANTITY));
        when(entityManager.createQuery(anyString())).thenReturn(query);
        when(query.getResultList()).thenReturn(products);
        when(query.getSingleResult()).thenReturn(product);
        when(query.executeUpdate()).thenReturn(1);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> productList = productDao.getAllProducts();
        assertThat(productList, notNullValue());
        assertThat(productList.size(), is(2));
    }

    @Test
    public void testGetProduct() {
        Product currentProduct = productDao.getProduct(1);
        assertThat(currentProduct, notNullValue());
        assertThat(currentProduct.getName(), is("Samsung TV"));
    }

    @Test
    public void testPurchaseProduct() {
        Product currentProduct = productDao.purchaseProduct(1, 2);
        assertThat(currentProduct, notNullValue());
        assertThat(currentProduct.getName(), is(product.getName()));
        assertThat(currentProduct.getQuantity(), is(INITIAL_QUANTITY - 2));
    }
}
