package defaultmethod;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Ignore;
import org.junit.Test;

public class DefaultMethodTest {

	/**
	 * In this example, we don't need to use the default method send() from PaymentService interface 
	 */
	@Ignore
	@Test
	public void shouldRetrieveTheDefaultFees() throws Exception {
		PaymentService service = new PayPalPaymentService();
		
		double fees = service.retrieveDefaultFees();
		
		assertThat(fees, equalTo(10.9));
	}
	
	@Test
	public void shouldInvokeTheDefaultMethodFromPaymentService() throws Exception {
		PaymentService paymentService = new PayPalPaymentService();
		
		double valueSent = paymentService.send(20);
		
		assertThat(valueSent, equalTo(20.0));
	}
	
}


interface PaymentService {
	
	double retrieveDefaultFees();
	
	default double send(double value) {
		System.out.println("Sending the value: " + value);
		
		return value;
	}
	
}

class PayPalPaymentService implements PaymentService {

	@Override
	public double retrieveDefaultFees() {
		return 10.9;
	}
	
}