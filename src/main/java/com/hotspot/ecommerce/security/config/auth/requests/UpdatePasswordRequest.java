package com.hotspot.ecommerce.security.config.auth.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePasswordRequest {

    private String password;
    private String newPassword;
    private String email;

}
