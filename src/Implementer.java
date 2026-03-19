import java.util.HashSet;

/**
 * THIS IS NOT PART OF THE ASSIGNMENT
 * An implementation of the AbstractMengde
 * @param <T> Containing type
 */
public class Implementer<T> extends AbstractMengde<T, Implementer<T>> {
	HashSet<T> elements = new HashSet<>();
	@Override
	@SuppressWarnings("unchecked")
	Implementer<T> construct() {
		return new Implementer<>();
	}

	@Override
	public void leggTil(T element) {
		elements.add(element);
	}

	@Override
	public T fjern(T element) {
		elements.remove(element);
		return element;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T[] tilTabell() {
		return (T[]) elements.toArray();
	}

	@Override
	public int antallElementer() {
		return elements.size();
	}
}
