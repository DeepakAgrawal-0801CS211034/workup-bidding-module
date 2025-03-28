package com.workup.biddingModule.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admin")
public class Admin {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private String role;  
}
