package dev.erosende.pt.repository.jdbc.product;

import dev.erosende.pt.dto.PriceInfoDto;

import java.time.LocalDateTime;

public interface IJdbcProductRepository {

    PriceInfoDto findPriceToApplyByDateAndProduct(LocalDateTime date, Integer productId, Short brandId);

}
