package ink.wulian.example.stripe.sdk;

import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://stripe.com/docs/billing/prices-guide
 * https://stripe.com/docs/api/prices
 * <p>
 * 价格;
 * <strong>? Price中有个字段"product";</strong>
 * </p>
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PriceSDK extends AbstractStripeSDK {

    public static List<Price> list() throws StripeException {
        return Price.list(Collections.emptyMap()).getData();
    }

    public static List<Price> retrieveByProductId(@NonNull String projectId) throws StripeException {
        Map<String, Object> params = new HashMap<>(1);
        params.put(Params.PRODUCT, projectId);
        return Price.list(params).getData();
    }

    public static Price create(@NonNull RecurringInterval recurringInterval,
                               @NonNull long unitAmount,
                               @NonNull Currency currency,
                               @NonNull String productId) throws StripeException {
        checkAmount(unitAmount, currency);
        Map<String, Object> recurring = new HashMap<>(1);
        recurring.put(Params.INTERVAL, recurringInterval);
        Map<String, Object> params = new HashMap<>(4);
        params.put(Params.UNIT_AMOUNT, unitAmount);
        params.put(Params.CURRENCY, currency);
        params.put(Params.RECURRING, recurring);
        params.put(Params.PRODUCT, productId);
        return Price.create(params);
    }

}
