package dev.erosende.pt.repository.jdbc.product;

import dev.erosende.pt.dto.PriceInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class JdbcProductRepository implements  IJdbcProductRepository {

    private final NamedParameterJdbcTemplate sqlTemplate;

    @Override
    public PriceInfoDto findPriceToApplyByDateAndProduct(LocalDateTime date, Integer productId, Short brandId) {
        final String PRICES_QUERY = "SELECT productId, brandId, priceList AS rateToApply, startDate, endDate, price AS priceToApply "
                                  + "FROM PRICE "
                                  + "WHERE brandId = :brandId AND productId = :productId AND (:date BETWEEN startDate AND endDate) "
                                  + "ORDER BY priority DESC "
                                  + "LIMIT 1";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("brandId", brandId)
                .addValue("productId", productId)
                .addValue("date", date);
        return sqlTemplate.queryForObject(PRICES_QUERY, params, new BeanPropertyRowMapper<>(PriceInfoDto.class));
    }

}
