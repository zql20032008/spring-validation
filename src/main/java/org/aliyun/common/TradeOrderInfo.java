/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2025 All Rights Reserved.
 */
package org.aliyun.common;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 订单上下文
 *
 * @author bruce.zql
 * @version 
 */
@Getter
@Setter
@ToString
public class TradeOrderInfo implements Serializable {
    private static final long serialVersionUID = 843465955307669294L;

    /**
     * 外部业务编号（主订单编号）
     */
    @NotNull
    private String tradeOrderId;

    /**
     * 买家ID
     */
    private String buyerId;

    /**
     * 主订单需要支付的金额
     */
    private Long totalAmount;
    /**
     * 运费金额（暂时不使用）
     */
    private Long shippingAmount;

    /**
     * 币种
     */
    private String currency;

   
    public Long getTotalAmount() {
        return totalAmount == null ? 0L : totalAmount;
    }

    public String getCurrency() {
        return StringUtils.isBlank(currency) ? "CNY" : currency;
    }
}
