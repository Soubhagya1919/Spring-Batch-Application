package com.batch.example.bootBatchExample.config;

import com.batch.example.bootBatchExample.model.Product;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product item) {
//        data transformation logic
//        calculation of discounted price
//        original  price
//        discount

        try {
//            put the percentage logic
            System.out.println(item.getDescription());
            int discountPer = Integer.parseInt(item.getDiscount().trim());
            double originalPrice = Double.parseDouble(item.getPrice().trim());
            double discount = ((double) discountPer / 100) * originalPrice;
            double finalPrice = originalPrice - discount;
            item.setDiscountedPrice(String.valueOf(finalPrice));
        } catch (
                NumberFormatException ex
        ) {
            ex.printStackTrace();
        }

        return item;
    }
}
