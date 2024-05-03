package dev.erosende.pt.controller;


import dev.erosende.pt.PtApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = PtApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class ProductControllerTest {

    private static final String PRICES_PATH = "/products/prices";

    @Autowired
    private MockMvc mockMvc;

    // Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    public void testShouldReturnThirtyFivePointFive() throws Exception {
        mockMvc.perform(get(PRICES_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("date", "2020-06-14T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(content().json("{'productId':35455,'brandId':1,'rateToApply':1,'startDate':'2020-06-14 00:00:00','endDate':'2020-12-31 23:59:59','priceToApply':35.5}"));
    }

    // Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    public void testShouldReturnTwentyFivePointFortyFive() throws Exception {
        mockMvc.perform(get(PRICES_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .param("date", "2020-06-14T16:00:00")
                .param("productId", "35455")
                .param("brandId", "1"))
                .andExpect(content().json("{'productId':35455,'brandId':1,'rateToApply':2,'startDate':'2020-06-14 15:00:00','endDate':'2020-06-14 18:30:00','priceToApply':25.45}"));
    }

    // Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    public void testShouldReturnThirtyFivePointFiveV2() throws Exception {
        mockMvc.perform(get(PRICES_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("date", "2020-06-14T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(content().json("{'productId':35455,'brandId':1,'rateToApply':1, 'startDate':'2020-06-14 00:00:00','endDate':'2020-12-31 23:59:59','priceToApply':35.5}"));
    }

    // Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
    @Test
    public void testShouldReturnThirtyPointFive() throws Exception {
        mockMvc.perform(get(PRICES_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("date", "2020-06-15T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(content().json("{'productId':35455,'brandId':1,'rateToApply':3,'startDate':'2020-06-15 00:00:00','endDate':'2020-06-15 11:00:00','priceToApply':30.5}"));
    }

    // Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
    @Test
    public void testShouldReturnThirtyEightPointNinetyFive() throws Exception {
        mockMvc.perform(get(PRICES_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("date", "2020-06-16T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(content().json("{'productId':35455,'brandId':1,'rateToApply':4,'startDate':'2020-06-15 16:00:00','endDate':'2020-12-31 23:59:59','priceToApply':38.95}"));
    }

}
