import DataStructures.LenketMengde;
import DataStructures.MengdeADT;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Lenket Test")
public class LenketTest extends AbstractMengdeTests<LenketMengde<Object>> {
	@Override
	@NonNull LenketMengde<Object> constructMengdeADT() {
		return new LenketMengde<>();
	}
}
