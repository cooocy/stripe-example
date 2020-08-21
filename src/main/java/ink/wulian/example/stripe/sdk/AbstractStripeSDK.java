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

    static class Params {

        static final String CARD_PAYMENTS = "card_payments";

        static final String TRANSFERS = "transfers";

        static final String REQUESTED_CAPABILITIES = "requested_capabilities";

        static final String TYPE = "type";

        static final String EMAIL = "email";

        static final String AMOUNT = "amount";

        static final String CURRENCY = "currency";

        static final String PRICE = "price";

        static final String QUANTITY = "quantity";

        static final String SUCCESS_URL = "success_url";

        static final String CANCEL_URL = "cancel_url";

        static final String PAYMENT_METHOD_TYPES = "payment_method_types";

        static final String LINE_ITEMS = "line_items";

        static final String MODE = "mode";

        static final String CUSTOMER = "customer";

        static final String INTERVAL = "interval";

        static final String UNIT_AMOUNT = "unit_amount";

        static final String RECURRING = "recurring";

        static final String PRODUCT = "product";

        static final String COUPON = "coupon";

        static final String DURATION = "duration";

        static final String NAME = "name";

        static final String DESCRIPTION = "description";

        static final String IMAGES = "images";

        static final String AMOUNT_OFF = "amount_off";

        static final String PERCENT_OFF = "percent_off";

    }

}
