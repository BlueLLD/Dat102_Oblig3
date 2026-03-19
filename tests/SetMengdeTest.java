import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Set Test")
public class SetMengdeTest extends AbstractMengdeTests<JavaSetToMengde<Object>> {

	@Override
	JavaSetToMengde<Object> constructMengdeADT() {
		return new JavaSetToMengde<>();
	}
	@Test
	@DisplayName("To Array")
	@Override
	void testToArray(){
		ArrayList<Object> content = new ArrayList<>(List.of(new Object[]{22, 4, 302, 9001}));
		for(Object element : mengde.tilTabell()){
			assertTrue(content.contains(element));
		}
		assertArrayEquals(new Integer[]{}, empty.tilTabell());
	}
}