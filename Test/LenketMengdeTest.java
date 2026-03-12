public class LenketMengdeTest extends MengdeTest{

    @Override
    protected MengdeADT<String> lagNyMengde(){
        return new LenketMengde<>();
    }
}
