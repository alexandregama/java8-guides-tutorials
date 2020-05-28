package streams;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class StreamWithMapTest {

	@Test
	public void shouldMultiplyEachElementBy2() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		Function<Integer, Integer> multiplyBy2 = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer number) {
				return number * 2;
			}
		};
		
		List<Integer> multipliedNumbers = numbers
			.stream()
			.map(multiplyBy2)
			.collect(Collectors.toList());
		
		assertThat(multipliedNumbers, CoreMatchers.hasItems(2, 4, 6, 8, 10));
	}
	
	@Test
	public void shouldMultiplyEachElementBy2UsingLambdaExpression() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		Function<Integer, Integer> multiplyBy2 = number -> number * 2; 
		
		List<Integer> multipliedNumbers = numbers
				.stream()
				.map(multiplyBy2)
				.collect(Collectors.toList());
		
		assertThat(multipliedNumbers, CoreMatchers.hasItems(2, 4, 6, 8, 10));
	}
	
	@Test
	public void shouldMultiplyAndTransformIntoStringEachElement() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		Function<Integer, Integer> multiplyBy2 = number -> number * 2; 
		Function<Integer, String> transformIntoString = number -> String.valueOf(number); 
		
		List<String> multipliedNumbersAsString = numbers
				.stream()
				.map(multiplyBy2)
				.map(transformIntoString)
				.collect(Collectors.toList());
		
		assertThat(multipliedNumbersAsString, CoreMatchers.hasItems("2", "4", "6", "8", "10"));
	}
	
}
