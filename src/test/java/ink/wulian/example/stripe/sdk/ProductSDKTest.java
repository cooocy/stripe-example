package ink.wulian.example.stripe.sdk;

import com.stripe.exception.StripeException;
import com.stripe.model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProductSDKTest {

    /**
     * list success;
     *
     * @throws StripeException ;
     */
    @Test
    public void listA() throws StripeException {
        List<Product> products = ProductSDK.list();
        Assert.assertNotNull(products);
    }

    /**
     * create success;
     *
     * @throws StripeException ;
     */
    @Test
    public void createA() throws StripeException {
        Product product = ProductSDK.create("test name 1", null, null);
        Assert.assertNotNull(product);
    }

    /**
     * id not exists;
     */
    @Test
    public void retrieveA() {
        try {
            ProductSDK.retrieve("id not exists");
        } catch (StripeException se) {
            Assert.assertEquals(se.getCode(), "resource_missing");
        }
    }

    /**
     * create and then retrieve it;
     *
     * @throws StripeException ;
     */
    @Test
    public void retrieveB() throws StripeException {
        Product product = ProductSDK.create("test name 2", null, null);
        product = ProductSDK.retrieve(product.getId());
        Assert.assertNotNull(product);
    }

}
