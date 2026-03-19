public class Person {
    public JavaSetToMengde<String> hobbyer;
    public String navn;
    public Person(String navn, String ...hobbyer) {
        this.navn = navn;
        this.hobbyer = new JavaSetToMengde<>();
        this.hobbyer.leggTil(hobbyer);
    }

    static double match(Person a, Person b){

        double antallFelles = a.hobbyer.snitt(b.hobbyer).antallElementer();
        double antallKunA = a.hobbyer.minus(b.hobbyer).antallElementer();
        double antallKunB = b.hobbyer.minus(a.hobbyer).antallElementer();
        double antallTotalt = a.hobbyer.antallElementer() + b.hobbyer.antallElementer();

        return (antallFelles - (antallKunA + antallKunB) / antallTotalt);
    }
}