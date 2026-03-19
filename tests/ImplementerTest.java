import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * THIS IS NOT PART OF THE ASSIGNMENT
 */
public class ImplementerTest extends  AbstractMengdeTests<Implementer<Object>>{
	@Override
	Implementer<Object> constructMengdeADT() {
		return new Implementer<>();
	}
	@Override
	void testToArray(){
		ArrayList<Object> content = new ArrayList<>(List.of(new Object[]{22, 4, 302, 9001}));
		for(Object element : mengde.tilTabell()){
			assertTrue(content.contains(element));
		}
		assertArrayEquals(new Integer[]{}, empty.tilTabell());
	}
}
