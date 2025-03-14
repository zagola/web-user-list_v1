package org.example;

import lombok.*;

@Data
//@Builder
public class UserEntry {
    private int userId;
    private String userName;
    private String roleName;
}