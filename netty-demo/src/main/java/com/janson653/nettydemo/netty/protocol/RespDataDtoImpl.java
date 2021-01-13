package com.janson653.nettydemo.netty.protocol;

import lombok.Data;
import lombok.ToString;

@ToString(callSuper = true)
@Data
public class RespDataDtoImpl extends BaseDataDto {
    public static int PONG = 1;

}
