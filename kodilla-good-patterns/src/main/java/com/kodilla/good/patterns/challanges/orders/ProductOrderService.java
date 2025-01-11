package com.kodilla.good.patterns.challanges.orders;

public class ProductOrderService {

    private UserBase userBase;
    private ProductBase productBase;
    private OrdersRepository ordersRepository;

    public ProductOrderService(final UserBase userBase, final ProductBase productBase, final OrdersRepository ordersRepository) {
        this.userBase = userBase;
        this.productBase = productBase;
        this.ordersRepository = ordersRepository;
    }

    public OrdersDto process (final OrderRequest orderRequest) {

        return null;
    }
}
