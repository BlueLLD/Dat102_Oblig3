import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class JavaSetToMengdeTest {

    JavaSetToMengde<String> mengde;
    JavaSetToMengde<String> annenMengde;

    @BeforeEach
    void setup(){
        mengde = new JavaSetToMengde<>();
        mengde.leggTil("a");
        mengde.leggTil("b");
        mengde.leggTil("c");

        annenMengde = new JavaSetToMengde<>();
        annenMengde.leggTil("b");
        annenMengde.leggTil("c");
        annenMengde.leggTil("d");
    }

    @Test
    void testAntallErTom(){
        JavaSetToMengde<String> tomtabell = new JavaSetToMengde<>();
        assertTrue(tomtabell.erTom());
        assertFalse(annenMengde.erTom());
    }

    @Test
    void testInneholder(){
        assertTrue(annenMengde.inneholder("c"));
    }

    @Test
    void testErDelmengdeAv(){
        JavaSetToMengde<String> c = new JavaSetToMengde<>();
        c.leggTil("c");
        assertTrue(c.erDelmengdeAv(annenMengde));
    }

    @Test
    void testErlik(){
        JavaSetToMengde<String> c = new JavaSetToMengde<>();
        c.leggTil("c");
        JavaSetToMengde<String> d = new JavaSetToMengde<>();
        d.leggTil("c");
        assertTrue(c.erLik(d));
    }

    @Test
    void testErDisjunkt(){
        JavaSetToMengde<String> c = new JavaSetToMengde<>();
        c.leggTil("c");
        JavaSetToMengde<String> d = new JavaSetToMengde<>();
        d.leggTil("c");
        assertFalse(c.erDisjunkt(d));
    }

    @Test
    void testSnitt(){
        //Finner snittet av to mengder og asserter det som er med og ikke
        MengdeADT<String> resultat = mengde.snitt(annenMengde);
        assertTrue(resultat.inneholder("b"));
        assertTrue(resultat.inneholder("c"));
        assertFalse(resultat.inneholder("a"));
        assertFalse(resultat.inneholder("d"));

    }

    @Test
    void testUnion(){
        MengdeADT<String> resultat = mengde.union(annenMengde);
        assertTrue(resultat.inneholder("a"));
        assertTrue(resultat.inneholder("b"));
        assertTrue(resultat.inneholder("c"));
        assertTrue(resultat.inneholder("d"));

        assertFalse(resultat.inneholder("e"));

    }

    @Test
    void testMinus(){
        MengdeADT<String> resultat = mengde.minus(annenMengde);
        assertTrue(resultat.inneholder("a"));
        assertFalse(resultat.inneholder("b"));
    }

    @Test
    void testLeggTil(){
        mengde.leggTil("a");
        assertEquals(3,mengde.antallElementer());

        mengde.leggTil("d");
        assertTrue(mengde.inneholder("d"));

        assertEquals(4,mengde.antallElementer());
    }

    @Test
    void testLeggTilAlleFra(){
        assertEquals(3, mengde.antallElementer());
        assertFalse(mengde.inneholder("d"));
        mengde.leggTilAlleFra(annenMengde);
        assertEquals(4, mengde.antallElementer());
        assertTrue(mengde.inneholder("d"));
    }

    @Test
    void testFjern(){
        assertEquals(3, mengde.antallElementer());
        assertTrue(mengde.inneholder("a"));
        mengde.fjern("a");
        assertFalse(mengde.inneholder("a"));
    }

    @Test
    void testTilTabell(){
        //Fant ingen mer elegant måte å gjøre det på
        Object[] tabell = mengde.tilTabell();
        Object[] forventet = {"a", "b", "c"};
        Arrays.sort(tabell);
        Arrays.sort(forventet);
        assertArrayEquals(forventet, tabell);

    }

    @Test
    void testAntallElementer(){
        assertEquals(3, mengde.antallElementer());
        mengde.leggTilAlleFra(annenMengde);
        assertEquals(4, mengde.antallElementer());
    }

}

