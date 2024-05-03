package dev.erosende.pt.service.product;

import dev.erosende.pt.dto.PriceInfoDto;
import dev.erosende.pt.repository.jdbc.product.IJdbcProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IJdbcProductRepository productRepository;

    @Override
    public PriceInfoDto findPriceToApplyByDateAndProduct(LocalDateTime date, Integer productId, Short brandId) {
        return productRepository.findPriceToApplyByDateAndProduct(date, productId, brandId);
    }

}
