package streams;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class StreamWithFilterTest {

	@Test
	public void shouldFilterAllNumbersGreaterThan5ByUsingStreamAndFilter() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		Predicate<Integer> greaterThan5 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer number) {
				return number > 5;
			}
		};
		
		List<Integer> numbersGreaterThan5 = numbers
			.stream()
			.filter(greaterThan5)
			.collect(Collectors.toList());
		
		assertThat(numbersGreaterThan5, CoreMatchers.hasItems(6, 7, 8, 9));
	}
	
	@Test
	public void shouldFilterAllNumbersGreaterThan5ByUsingStreamAndFilterWithLambda() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		Predicate<Integer> greaterThan5 = number -> number > 5;
		
		List<Integer> numbersGreaterThan5 = numbers
				.stream()
				.filter(greaterThan5)
				.collect(Collectors.toList());
		
		assertThat(numbersGreaterThan5, CoreMatchers.hasItems(6, 7, 8, 9));
	}
	
	@Test
	public void shouldFilterAllNumbersGreaterThan5ByUsingInlineFilter() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		List<Integer> numbersGreaterThan5 = numbers
				.stream()
				.filter(number -> number > 5)
				.collect(Collectors.toList());
		
		assertThat(numbersGreaterThan5, CoreMatchers.hasItems(6, 7, 8, 9));
	}
	
	@Test
	public void shouldFilterAllNumbersGreaterThan5AndDividedBy2() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		List<Integer> numbersGreaterThan5 = numbers
				.stream()
				.filter(number -> number > 5)
				.filter(number -> number % 2 == 0)
				.collect(Collectors.toList());
		
		assertThat(numbersGreaterThan5, CoreMatchers.hasItems(6, 8));
	}
	
}

