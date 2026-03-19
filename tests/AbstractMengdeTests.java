import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


// Class for testing MengdeADT sub classes
abstract public class AbstractMengdeTests <T extends MengdeADT<Object>> {
	T empty;
	T mengde;
	T endaEnMengde;
	T delMengde;
	T diff;


	abstract T constructMengdeADT();

	@BeforeEach
	void BeforeEach(){
		empty = constructMengdeADT();

		mengde = constructMengdeADT();
		mengde.leggTil(22, 4, 302, 9001);

		delMengde = constructMengdeADT();
		delMengde.leggTil(22,4, 302);

		endaEnMengde = constructMengdeADT();
		endaEnMengde.leggTil(22, 4, 43, 11, 90);

		diff = constructMengdeADT();
		diff.leggTil(33, 5, 303, 9000);
	}

	@Test
	@DisplayName("Includes")
	void testIncludes(){
		assertFalse(empty.inneholder(32));
		assertFalse(empty.inneholder(null));
		assertFalse(mengde.inneholder(null));
		assertTrue(mengde.inneholder(9001));
	}

	@Test
	@DisplayName("Legg Till")
	void testAdd(){
		int original_length = mengde.antallElementer();
		mengde.leggTil(55);
		mengde.leggTil(34);
		assertTrue(mengde.inneholder(55));
		assertFalse(mengde.inneholder(42));
		assertEquals(original_length + 2, mengde.antallElementer());
	}

	@Test
	@DisplayName("Legg til flere fra")
	void testAddAll(){
		mengde.leggTilAlleFra(delMengde);
		empty.leggTilAlleFra(mengde);
		delMengde.leggTilAlleFra(mengde);
		diff.leggTilAlleFra(mengde);
		assertTrue(mengde.erLik(empty));
		assertTrue(mengde.erLik(delMengde));
		assertFalse(diff.erLik(mengde));
	}

	@Test
	@DisplayName("Remove")
	void testRemove(){
		mengde.fjern(9001);
		assertTrue(mengde.erLik(delMengde));
		delMengde.fjern(302);
		endaEnMengde.fjern(43);
		endaEnMengde.fjern(90);
		endaEnMengde.fjern(11);
		assertTrue(endaEnMengde.erLik(delMengde));
	}

	@Test
	@DisplayName("Is Empty")
	void testEmpty(){
		assertTrue(empty.erTom());
		assertFalse(mengde.erTom());
	}


	@Test
	@DisplayName("Partial Of")
	void testPartialOf(){
		assertTrue(delMengde.erDelmengdeAv(mengde));
		assertFalse(delMengde.erDelmengdeAv(endaEnMengde));
		assertTrue(empty.erDelmengdeAv(mengde));
		assertTrue(empty.erDelmengdeAv(empty));
	}

	@Test
	@DisplayName("Equals")
	void testEquals(){
		assertTrue(mengde.erLik(mengde));
		assertFalse(mengde.erLik(delMengde));
		assertFalse(mengde.erLik(endaEnMengde));
	}

	@Test
	@DisplayName("Disjunct")
	void testDisjunct(){
		assertTrue(diff.erDisjunkt(mengde));
		assertFalse(mengde.erDisjunkt(delMengde));
//		assertTrue(diff.erDisjunkt(mengde));
//		assertTrue(diff.erDisjunkt(mengde));
	}

	@Test
	@DisplayName("Snitt")
	void testSnitt() {
		assertTrue(mengde.snitt(delMengde).erLik(delMengde));
		assertTrue(delMengde.snitt(mengde).erLik(delMengde));
		assertFalse(delMengde.snitt(diff).erLik(mengde));
		assertTrue(delMengde.snitt(diff).erLik(empty));
	}

	@Test
	@DisplayName("Union")
	void testUnion(){
		MengdeADT<Object> extra = constructMengdeADT();
		extra.leggTil(9001);
		assertTrue(delMengde.union(extra).erLik(mengde));
		assertFalse(delMengde.union(diff).erLik(mengde));
	}

	@Test
	@DisplayName("Minus")
	void testMinus(){
		MengdeADT<Object> extra = constructMengdeADT();
		extra.leggTil(9001);
		assertTrue(mengde.minus(extra).erLik(delMengde));
		assertFalse(delMengde.minus(diff).erLik(mengde));
	}

	@Test
	@DisplayName("Antall")
	void testAntall(){
		assertEquals(4, mengde.antallElementer());
		mengde.fjern(22);
		assertEquals(3, mengde.antallElementer());
		assertEquals(0, empty.antallElementer());
	}

	@Test
	@DisplayName("To Array")
	void testToArray(){
		assertArrayEquals(new Integer[]{22, 4, 302, 9001}, mengde.tilTabell());
		assertArrayEquals(new Integer[]{}, empty.tilTabell());
	}
}