package com.workintech.manytomany.manytomany.exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HollywoodErrorResponse {

    private int status;
    private String message;
    private long timestamp;
}
