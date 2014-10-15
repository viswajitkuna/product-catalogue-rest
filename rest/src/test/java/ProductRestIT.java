import com.sample.rest.ProductRest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.client.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-beans.xml")
public class ProductRestIT {

    @Autowired
    private Client productRestClient;

    @Autowired
    private ProductRest productRest;
}
