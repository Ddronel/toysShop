package com.innopolis.toysshop.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ToyForm {
    private String description;
    private Integer cost;
    private String size;
}
