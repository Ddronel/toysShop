package com.innopolis.toysshop.forms;

import com.innopolis.toysshop.models.Storage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerForm {
    private String first_last_name;
    private Integer age;
    private String phone_number;
}
