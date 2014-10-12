import com.sample.dao.ProductDao;
import com.sample.dao.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-ds-context.xml")
@Transactional
public class ProductDaoIT {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testGetAllProducts() {
        List<Product> products = productDao.getAllProducts();
        assertThat(products, notNullValue());
        Product product = products.get(0);
        assertThat(product, notNullValue());
        assertThat(product.getName(), is("SAMSUNG LED TV"));
        assertThat(product.getDescription(), is("SAMSUNG LED TV 5410 40\""));
    }

    @Test
    public void testGetProduct() {
        Product product = productDao.getProduct(1);
        assertThat(product, notNullValue());
        assertThat(product.getName(), is("SAMSUNG LED TV"));
        assertThat(product.getDescription(), is("SAMSUNG LED TV 5410 40\""));
    }

    @Test
    public void testPurchaseProduct() {
        int oldQuantity = 0;
        Product product = productDao.getProduct(1);
        oldQuantity = product.getQuantity();
        Product updatedProduct = productDao.purchaseProduct(1, 2);
        assertThat(updatedProduct, notNullValue());
        assertThat(updatedProduct.getQuantity(), is(oldQuantity - 2));
    }
}
