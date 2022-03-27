package com.innopolis.toysshop.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerForm {
    private String first_name;
    private String last_name;
    private String email;
    private String address;
}
