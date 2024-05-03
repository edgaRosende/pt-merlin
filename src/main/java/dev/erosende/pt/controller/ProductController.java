package dev.erosende.pt.controller;

import dev.erosende.pt.dto.PriceInfoDto;
import dev.erosende.pt.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping("/prices")
    public ResponseEntity<PriceInfoDto> findPriceToApplyByDateAndProduct(@RequestParam LocalDateTime date, @RequestParam Integer productId, @RequestParam Short brandId) {
        ResponseEntity<PriceInfoDto> response;
        try {
            response = ResponseEntity.ok(productService.findPriceToApplyByDateAndProduct(date, productId, brandId));
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            log.error("An error has occurred while searching for the price to apply to a product [productId -> {}][brandId -> {}][date -> {}]",
                    productId, brandId, date, e);
        }
        return response;
    }

}
