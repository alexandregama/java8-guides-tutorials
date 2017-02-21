package com.craftcoder.java8.lambda;

import org.junit.Test;

public class LambdaExpressionTest {

	@Test
	public void shouldRunUsingAnonymousClass() throws Exception {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("Yes, anonymous object here :(");
			}
		};

		runnable.run();
	}

}
