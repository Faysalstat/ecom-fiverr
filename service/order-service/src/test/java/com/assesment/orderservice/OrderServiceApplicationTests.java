package com.assesment.orderservice;

import com.assesment.orderservice.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class OrderServiceApplicationTests {

	@Autowired
	private OrderService orderService;

	@Test
	public void testCalculateProfit_WithPositiveValues() {
		// Arrange
		Double costPrice = 50.0;      // cost per item
		Double sellingPrice = 70.0;   // selling price per item
		int quantity = 100;      // number of items sold

		// Act
		Double profit = orderService.calculateProfit(costPrice, sellingPrice, quantity);

		// Assert
		assertEquals("Profit should be calculated correctly", 2000.0, profit);
	}

	@Test
	public void testCalculateProfit_WithZeroProfit() {
		// Arrange
		Double costPrice = 70.0;      // cost per item
		Double sellingPrice = 70.0;   // selling price per item
		int quantity = 100;      // number of items sold

		// Act
		Double profit = orderService.calculateProfit(costPrice, sellingPrice, quantity);

		// Assert
		assertEquals("Profit should be zero when selling price equals cost price", 0.0, profit);
	}

}
