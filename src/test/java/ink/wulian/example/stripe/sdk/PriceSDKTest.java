package ink.wulian.example.stripe.sdk;

import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.Product;
import ink.wulian.example.stripe.result.ResultEnum;
import ink.wulian.example.stripe.result.ServiceException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PriceSDKTest {

    /**
     * list success;
     *
     * @throws StripeException ;
     */
    @Test
    public void listA() throws StripeException {
        List<Price> prices = PriceSDK.list();
        Assert.assertNotNull(prices);
    }

    /**
     * id not exists;
     */
    @Test
    public void retrieveByProductA() {
        try {
            PriceSDK.retrieveByProductId("id not exists");
        } catch (StripeException se) {
            Assert.assertEquals(se.getCode(), "resource_missing");
        }
    }

    /**
     * retrieve success;
     *
     * @throws StripeException ;
     */
    @Test
    public void retrieveByProductB() throws StripeException {
        Product product = ProductSDK.create("test name", null, null);
        PriceSDK.create(RecurringInterval.month, 1990, Currency.hkd, product.getId());
        List<Price> prices = PriceSDK.retrieveByProductId(product.getId());
        Assert.assertNotNull(prices);
    }

    /**
     * projectId is null;
     *
     * @throws StripeException ;
     */
    @Test
    public void createA() throws StripeException {
        try {
            PriceSDK.create(RecurringInterval.month, 0, Currency.hkd, null);
        } catch (NullPointerException ne) {
            Assert.assertEquals(ne.getMessage(), "productId is marked non-null but is null");
        }
    }

    /**
     * unitAmount too little;
     *
     * @throws StripeException ;
     */
    @Test
    public void createB() throws StripeException {
        try {
            Product product = ProductSDK.create("test name", null, null);
            PriceSDK.create(RecurringInterval.month, 0, Currency.hkd, product.getId());
        } catch (ServiceException se) {
            Assert.assertEquals(se.getResultEnum(), ResultEnum.accountLtOne);
        }
    }

    /**
     * create success;
     *
     * @throws StripeException ;
     */
    @Test
    public void createC() throws StripeException {
        Product product = ProductSDK.create("test name", null, null);
        Price price = PriceSDK.create(RecurringInterval.month, 1990, Currency.hkd, product.getId());
        Assert.assertNotNull(price);
    }

}
