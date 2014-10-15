import com.sample.rest.impl.ProductRestImpl;
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
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProductRestTest {

    @InjectMocks
    private ProductRestImpl productRest;

    @Mock
    private ProductCatalogueServiceImpl productCatalogueService;

    ProductDetails productDetails;

    private static final int INITIAL_QUANTITY = 30;

    @Before
    public void setUp() {
        productDetails = new ProductDetails(1, "SAMSUNG LED TV", INITIAL_QUANTITY);
        List<ProductDetails> productDetailsList = new ArrayList<ProductDetails>();
        productDetailsList.add(productDetails);
        productDetailsList.add(new ProductDetails(2, "SONY LED TV", INITIAL_QUANTITY));

        when(productRest.getProduct(1)).thenReturn(productDetails);
        when(productRest.purchaseProduct(1, 2)).thenReturn(productDetails);
        when(productRest.getAllProducts()).thenReturn(productDetailsList);
    }

    @Test
    public void testGetAllProducts() {
        List<ProductDetails> products = productRest.getAllProducts();
        assertThat(products, notNullValue());
        ProductDetails product = products.get(0);
        assertThat(product, notNullValue());
        assertThat(product.getName(), is("SAMSUNG LED TV"));
        assertThat(product.getQuantity(), is(INITIAL_QUANTITY));
    }

    @Test
    public void testGetProduct() {
        ProductDetails product = productRest.getProduct(1);
        assertThat(product, notNullValue());
        assertThat(product.getName(), is("SAMSUNG LED TV"));
        assertThat(product.getQuantity(), is(INITIAL_QUANTITY));
    }

    @Test
    public void testPurchaseProduct() {
        ProductDetails product = productRest.purchaseProduct(1, 2);
        assertThat(product, notNullValue());
        assertThat(product.getName(), is("SAMSUNG LED TV"));
        assertThat(product.getQuantity(), is(INITIAL_QUANTITY));
    }
}
