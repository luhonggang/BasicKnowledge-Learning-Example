package com.example.strategicmodel.difficult;

import lombok.*;

/**
 * 模拟支付入参类
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/10 15:18
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaymentDto {
    private String payType;
    private String payNo;
    private String orderNo;
    private String customerId;
}
