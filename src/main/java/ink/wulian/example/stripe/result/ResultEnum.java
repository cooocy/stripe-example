package ink.wulian.example.stripe.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {

    // about PaymentIntent model;
    accountLtOne(false, "stripe-20010", "account must be greater than or equal to 1;"),

    // about customer model;
    balanceVolatilityEqZero(false, "stripe-21010", "balance volatility can not eq 0L;"),
    customerNotExist(false, "stripe-21012", "customer not exist;");

    private final Boolean success;

    private final String code;

    private final String message;

}
