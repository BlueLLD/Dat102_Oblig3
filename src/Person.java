public class Person {
    String navn;
    MengdeADT<String> hobbyer;

    public Person(String navn, String ... hobbyer){
        this.navn = navn;
        this.hobbyer = new TabellMengde<>();
        for(String hobby : hobbyer){
            this.hobbyer.leggTil(hobby);
        }
    }


}
