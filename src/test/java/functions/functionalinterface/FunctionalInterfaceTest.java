package functions.functionalinterface;

import org.junit.Test;

public class FunctionalInterfaceTest {

	@Test
	public void shouldUseRealFunctionalInterface() throws Exception {
		RealFunctionalInterface functionalInterface = new RealFunctionalInterface() {

			@Override
			public void doSomething() {
				System.out.println("Doing Something");
			}
		};

		functionalInterface.doSomething();
	}

	@Test
	public void shouldUseRealFunctionalInterfaceWithJava8LambdaExpression() throws Exception {
		RealFunctionalInterface functionalInterface = () -> System.out.println("Doing Something");

		functionalInterface.doSomething();
	}

	@Test
	public void shouldToBypassTheLambdaExpressionRule() throws Exception {
//		AnotherFakeFunctionalInterface fake = () -> {}; Compilation error
	}

}
