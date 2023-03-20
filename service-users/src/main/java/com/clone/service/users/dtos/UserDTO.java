package com.clone.service.users.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class UserDTO {
    private Long id;
    private String email;
    private String username;
    private String password;
    private String photo;
}
