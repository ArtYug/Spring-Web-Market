package com.geekbrains.web_market.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
}
