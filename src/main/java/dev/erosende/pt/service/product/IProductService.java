package dev.erosende.pt.service.product;

import dev.erosende.pt.dto.PriceInfoDto;

import java.time.LocalDateTime;

public interface IProductService {

    PriceInfoDto findPriceToApplyByDateAndProduct(LocalDateTime date, Integer productId, Short brandId);

}
