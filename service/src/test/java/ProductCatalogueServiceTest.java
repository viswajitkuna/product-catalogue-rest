import com.sample.dao.ProductDao;
import com.sample.dao.domain.Product;
import com.sample.service.dto.ProductDetails;
import com.sample.service.impl.ProductCatalogueServiceImpl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductCatalogueServiceTest {

    @InjectMocks
    private ProductCatalogueServiceImpl productCatalogueService;

    private Product product;

    @Mock
    private ProductDao productDao;

    @Before
    public void setUp() {
        product = new Product(1, "Samsung TV", 30);
        List<Product> products = new ArrayList<Product>();
        products.add(product);
        products.add(new Product(2, "Sony TV", 30));
        when(productDao.getAllProducts()).thenReturn(products);
        when(productDao.getProduct(1)).thenReturn(product);
        when(productDao.purchaseProduct(1, 2)).thenReturn(product);
    }

    @Test
    public void testGetAllProducts() {
        List<ProductDetails> productDetails = productCatalogueService.getAllProducts();
        ProductDetails currentProduct = productDetails.get(0);
        assertThat(currentProduct, notNullValue());
        assertThat(currentProduct.getName(), is("Samsung TV"));
    }

    @Test
    public void testProduct() {
        ProductDetails productDetails = productCatalogueService.getProduct(1);
        assertThat(productDetails, notNullValue());
        assertThat(productDetails.getName(), is("Samsung TV"));
    }

    @Test
    public void testPurchaseProduct() {
        ProductDetails productDetails = productCatalogueService.purchaseProduct(1, 2);
        assertThat(productDetails, notNullValue());
        assertThat(productDetails.getQuantity(), is(30));
    }
}
