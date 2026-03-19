import org.junit.jupiter.api.DisplayName;

@DisplayName("Lenket Test")
public class LenketTest extends AbstractMengdeTests<LenketMengde<Object>> {
	@Override
	LenketMengde<Object> constructMengdeADT() {
		return new LenketMengde<>();
	}
}
