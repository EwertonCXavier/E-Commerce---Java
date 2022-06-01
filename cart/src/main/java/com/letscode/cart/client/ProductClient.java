package com.letscode.cart.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "product")
public interface ProductClient {

}
