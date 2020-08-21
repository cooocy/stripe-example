This is a simple example for stripe.

### Notice
You must set your stripe api in `AbstractStripeSDK` and then you can run unit test.

### Stripe Model

#### Product
商品; 一个商品对应多个价格。
> https://stripe.com/docs/billing/prices-guide
> https://stripe.com/docs/api/products

#### Price
价格;
Price中有个字段"product";
> https://stripe.com/docs/billing/prices-guide
> https://stripe.com/docs/api/prices