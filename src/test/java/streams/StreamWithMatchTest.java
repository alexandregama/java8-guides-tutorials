package streams;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StreamWithMatchTest {

	@Test
	public void shouldCheckIfThereIsANumberGreaterThan4() throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		
		boolean anyNumberGreaterThan4 = numbers
			.stream()
			.anyMatch(number -> number > 4);
		
		assertThat(anyNumberGreaterThan4,  is(true));
	}
	
	@Test
	public void shouldCheckIfEachNumberIsPair() throws Exception {
		List<Integer> numbers = Arrays.asList(2, 4, 6);
		
		boolean eachNumberIsPair = numbers
				.stream()
				.allMatch(number -> number % 2 == 0);
		
		assertThat(eachNumberIsPair, is(true));
	}
	
	@Test
	public void shouldCheckIfEachNumberIsNotPair() throws Exception {
		List<Integer> numbers = Arrays.asList(3, 5, 7);
		
		boolean eachNumberIsNotPair = numbers
				.stream()
				.noneMatch(number -> number % 2 == 0);
		
		assertThat(eachNumberIsNotPair, is(true));
	}
	
}
