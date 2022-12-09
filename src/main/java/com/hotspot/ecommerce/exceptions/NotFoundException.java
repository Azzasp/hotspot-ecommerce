package com.hotspot.ecommerce.exceptions;

import java.util.function.Supplier;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }
}
