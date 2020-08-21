package ink.wulian.example.stripe.sdk;

import com.stripe.Stripe;
import ink.wulian.example.stripe.result.ResultEnum;
import ink.wulian.example.stripe.result.ServiceException;
import lombok.NonNull;

public abstract class AbstractStripeSDK {

    static {
        Stripe.apiKey = "set your aki key here";
    }

    /**
     * different currency has different minimum value of amount;
     *
     * @param amount   ;
     * @param currency ;
     */
    static void checkAmount(long amount, @NonNull Currency currency) {
        if (amount < 1) {
            throw new ServiceException(ResultEnum.accountLtOne);
        }
        // todo check with currency;
    }

    interface Params {

        String CARD_PAYMENTS = "card_payments";

        String TRANSFERS = "transfers";

        String REQUESTED_CAPABILITIES = "requested_capabilities";

        String TYPE = "type";

        String EMAIL = "email";

        String AMOUNT = "amount";

        String CURRENCY = "currency";

        String PRICE = "price";

        String QUANTITY = "quantity";

        String SUCCESS_URL = "success_url";

        String CANCEL_URL = "cancel_url";

        String PAYMENT_METHOD_TYPES = "payment_method_types";

        String LINE_ITEMS = "line_items";

        String MODE = "mode";

        String CUSTOMER = "customer";

        String INTERVAL = "interval";

        String UNIT_AMOUNT = "unit_amount";

        String RECURRING = "recurring";

        String PRODUCT = "product";

        String COUPON = "coupon";

        String DURATION = "duration";

        String NAME = "name";

        String AMOUNT_OFF = "amount_off";

    }

}
