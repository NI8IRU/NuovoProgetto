package com.example.demo.dto.secretary;

import com.example.demo.entity.Office;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;

public class CreateSecretaryDto {

    private Long officeId;
    private String name;
    private String phone;
    private String email;

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
