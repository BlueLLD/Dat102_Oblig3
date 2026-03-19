import DataStructures.MengdeADT;
import DataStructures.TabellMengde;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Tabell Tests")
public class TabellMengdeTest extends AbstractMengdeTests<TabellMengde<Object>> {
	@Override
	@NonNull TabellMengde<Object> constructMengdeADT() {
		return new TabellMengde<>();
	}
}
