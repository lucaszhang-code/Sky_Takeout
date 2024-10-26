package com.sky.dto;

import lombok.Data;

@Data
public class EmployeePasswordDTO {
    private Long EmpId;
    private String newPassword;
    private String oldPassword;

}
