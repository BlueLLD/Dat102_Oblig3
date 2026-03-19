import org.junit.jupiter.api.DisplayName;

@DisplayName("Tabell Tests")
public class TabellMengdeTest extends AbstractMengdeTests<TabellMengde<Object>> {
	@Override
	TabellMengde<Object> constructMengdeADT() {
		return new TabellMengde<>();
	}
}
