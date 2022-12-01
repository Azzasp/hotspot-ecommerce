package com.hotspot.ecommerce.models.users.cliente.registrar;

import java.util.function.Predicate;

public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        // TODO: REGEX para validar email
        return true;
    }
}
