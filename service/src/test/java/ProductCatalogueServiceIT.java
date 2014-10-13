import com.sample.dao.ProductDao;
import com.sample.dao.domain.Product;
import com.sample.service.ProductCatalogueService;
import com.sample.service.dto.ProductDetails;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-beans.xml"})
public class ProductCatalogueServiceIT {

    @Autowired
    private ProductCatalogueService productCatalogueService;

    @Test
    public void testGetAllProducts() {
        List<ProductDetails> productDetails = productCatalogueService.getAllProducts();
        ProductDetails product = productDetails.get(0);
        MatcherAssert.assertThat(product, CoreMatchers.notNullValue());
        MatcherAssert.assertThat(product.getName(), CoreMatchers.is("SAMSUNG LED TV"));
    }

    @Test
    public void testGetProduct() {
        ProductDetails productDetails = productCatalogueService.getProduct(1);
        MatcherAssert.assertThat(productDetails, CoreMatchers.notNullValue());
        MatcherAssert.assertThat(productDetails.getName(), CoreMatchers.is("SAMSUNG LED TV"));
    }

    @Test
    public void testPurchaseProduct() {
        ProductDetails oldProductDetails = productCatalogueService.getProduct(1);
        int oldQuantity = oldProductDetails.getQuantity();
        ProductDetails productDetails = productCatalogueService.purchaseProduct(1, 2);
        MatcherAssert.assertThat(productDetails, CoreMatchers.notNullValue());
        MatcherAssert.assertThat(productDetails.getQuantity(), CoreMatchers.is(oldQuantity - 2));
    }
}
