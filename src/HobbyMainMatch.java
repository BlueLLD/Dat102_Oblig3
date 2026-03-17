public class HobbyMainMatch {

    static double match(Person a, Person b) {

        //match = antallFelles – (antallKunHosDenEne + antallKunHosDenAndre) / antallTotalt
        //som beregner match-score for to personer a og b,
        //felles bobbyer gir bedre match
        double antallKunA = a.hobbyer.minus(b.hobbyer).antallElementer();
        double antallFelles = a.hobbyer.snitt(b.hobbyer).antallElementer();
        double antallKunB = b.hobbyer.minus(a.hobbyer).antallElementer();
        double antallTotalt = a.hobbyer.union(b.hobbyer).antallElementer();

    return ( antallFelles - (antallKunA + antallKunB)/antallTotalt);

    }




    public static void main(String[] args) {

        Person a = new Person("Vidar Dagsrevyen", "fotball", "rennefart", "tegne", "kappgang",
                "formskrift");
        Person b = new Person("Gro Tulipan", "rugby", "rompeldunk", "kappgang", "tegne",
                "romfart", "blindeskrift");
        Person c = new Person("Bob Europa", "kartlesing", "blindeskrift", "kappgang",
                "naruto");

        double maa = match(a,a);
        double mab = match(a,b);
        double mac = match(a,c);
        double mbc = match(b,c);

        double[] tab = new double[]

        IO.println("Match score mellom a og a er: ");
        IO.println(match(a,a));
        IO.println("Match score mellom a og b er: ");
        IO.println(match(a,b));
        IO.println(match(b,a));

        IO.println("Match score mellom a og c er: ");
        IO.println(match(a,c));
        IO.println(match(c,a));

        IO.println("Match score mellom b og c er: ");
        IO.println(match(b,c));
        IO.println(match(c,b));



    }

}


