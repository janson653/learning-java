package com.janson653.nettydemo.netty.protocol;

import lombok.Data;

@Data
public class BaseDataDto {
    private long timestamp = System.currentTimeMillis();
    private int version = 1;
    private int dataType;
    private String data;
}
