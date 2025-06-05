/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2025 All Rights Reserved.
 */
package org.aliyun.common;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "外部业务编号（主订单编号）", example = "91884870")
    private String tradeOrderId;

    /**
     * 买家ID
     */
    @Schema(description = "买家ID", example = "U121234567812345678")
    private String buyerId;

    /**
     * 主订单需要支付的金额
     */
    @Schema(description = "主订单需要支付的金额", example = "100")
    private Long totalAmount;
    /**
     * 运费金额（暂时不使用）
     */
    @Schema(description = "运费金额（暂时不使用）", example = "10")
    private Long shippingAmount;

    /**
     * 币种
     */
    @Schema(description = "币种", example = "CNY")
    private String currency;

    /**
     * 商品信息列表，与paySubject一同描述本次支付的标的物信息
     */
    @NotNull
    @Schema(description = "商品信息列表，与paySubject一同描述本次支付的标的物信息", example = "")
    private List<TradeOrderItemInfo> tradeOrderItemInfos;

    public Long getTotalAmount() {
        return totalAmount == null ? 0L : totalAmount;
    }

    public String getCurrency() {
        return StringUtils.isBlank(currency) ? "CNY" : currency;
    }
}
