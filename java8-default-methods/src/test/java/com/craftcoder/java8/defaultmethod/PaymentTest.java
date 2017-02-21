package com.craftcoder.java8.defaultmethod;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class PaymentTest {

	@Test
	public void shouldCalculateTheOrderPriceUsingPayPalService() throws Exception {
		PaymentService payment = new PayPalPaymentService();
		
		double orderPrice = 100.0;
		double finalPrice = payment.calculeOrder(orderPrice);
		
		assertThat(finalPrice, equalTo(80.0));
	}
	
	@Test
	public void shouldCalculateTheOrderPriceUsingMoipService() throws Exception {
		PaymentService payment = new MoipPaymentService();
		
		double orderPrice = 100.0;
		double finalPrice = payment.calculeOrder(orderPrice);
		
		assertThat(finalPrice, equalTo(90.0));
	}
	
}


interface PaymentService {
	
	double discount();
	
	default double calculeOrder(double orderPrice) {
		return orderPrice - (orderPrice * discount());
	}
	
}

class PayPalPaymentService implements PaymentService {

	@Override
	public double discount() {
		return 0.20;
	}
	
}

class MoipPaymentService implements PaymentService {

	@Override
	public double discount() {
		return 0.10;
	}
	
}