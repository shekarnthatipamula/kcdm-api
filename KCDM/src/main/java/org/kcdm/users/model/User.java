package org.kcdm.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kcdm.Model;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class User implements Model {
    private String username;
    private String password;
    private String role;
    private String fullName;
    private String country;
    private short enabled;
}
