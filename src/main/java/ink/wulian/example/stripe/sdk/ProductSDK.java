package ink.wulian.example.stripe.sdk;

import cn.hutool.core.util.StrUtil;
import com.stripe.exception.StripeException;
import com.stripe.model.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://stripe.com/docs/billing/prices-guide
 * https://stripe.com/docs/api/products
 * <p>
 * 商品; 一个商品对应多个价格。
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductSDK extends AbstractStripeSDK {

    public static Product create(@NonNull String name,
                                 String description,
                                 String image) throws StripeException {
        Map<String, Object> params = new HashMap<>(16);
        params.put(Params.NAME, name);
        if (StrUtil.isNotEmpty(description)) {
            params.put(Params.DESCRIPTION, description);
        }
        if (StrUtil.isNotEmpty(image)) {
            params.put(Params.IMAGES, image);
        }
        return Product.create(params);
    }

    public static List<Product> list() throws StripeException {
        return Product.list(Collections.emptyMap()).getData();
    }

    public static Product retrieve(@NonNull String id) throws StripeException {
        return Product.retrieve(id);
    }

}
