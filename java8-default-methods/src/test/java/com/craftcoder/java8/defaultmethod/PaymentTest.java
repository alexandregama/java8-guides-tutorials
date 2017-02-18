package com.craftcoder.java8.defaultmethod;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class PaymentTest {

	@Test
	public void shouldCalculateTheOrderPriceWithPayPalService() throws Exception {
		PayPalPaymentService payment = new PayPalPaymentService();
		
		double orderPrice = payment.calculateOrder(100.0);
		
		assertThat(orderPrice, equalTo(100.0));
	}
	
	@Test
	public void shouldCalculateTheOrderPrice() throws Exception {
		PayPalPaymentService payment = new PayPalPaymentService();
		
		double orderPrice = payment.calculateOrder(100.0);
		
		assertThat(orderPrice, equalTo(100.0));
	}
	
}


interface PaymentService {
	
	double calculateOrder(double price);
	
}

class PayPalPaymentService implements PaymentService {

	@Override
	public double calculateOrder(double price) {
		return price;
	}
	
}

