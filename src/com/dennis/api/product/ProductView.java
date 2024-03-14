package com.dennis.api.product;

import com.dennis.api.common.UtilService;
import com.dennis.api.common.UtilServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductView {
    public static void main() {
        List<Product> product = new ArrayList<>();
        UtilService utilService = UtilServiceImpl.getInstance();

        for (int i = 1; i < 5; i++) {
            product.add(
                    Product.builder()
                            .pno(i)
                            .name(utilService.createRandomName())
                            .company(utilService.createRandomCompany())
                            .price(utilService.createRandomInteger(0, 10000))
                            .build()
            );
        }

        product.forEach(i ->
                System.out.println(i.toString() ));
        System.out.println();
    }
}
