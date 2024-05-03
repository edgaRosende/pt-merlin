package dev.erosende.pt.dto;

import lombok.Data;

@Data
public class PriceInfoDto {

    private Integer productId;
    private Short brandId;
    private Short rateToApply;
    private String startDate;
    private String endDate;
    private Float priceToApply;

}
