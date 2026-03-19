import java.util.HashSet;
import java.util.Arrays;
import java.util.Random;

void main() {

    HashSet<Integer> hs = new HashSet<Integer>();
    Integer[] tab = new Integer[100000];

    int tall = 376; // Her kan vi bruke eit vilkårleg tal
    for (int i = 0; i < 100000; i++){
        hs.add(tall);
        tab[i] = tall;
        // legg tall til i HashSet og tabell
        tall = (tall + 45713) % 1000000; // Sjå nedanfor om 45713
    }
    //Sorterer tabellen med innebygget sort
    Arrays.sort(tab);

    //Lager 10K tilfeldige søketall mellom 0 og 1 mill

    int[] sokeTall = new int[10000];

    Random random = new Random();
    for (int i = 0; i < 10000; i++){
        sokeTall[i] = random.nextInt(1000000);
    }
    //tar tiden før søk hs
    long startHs = System.nanoTime();

    int treffHs = 0;
    for (int i = 0; i < 10000; i++){
        //inneholder hashsetet søketall på plass i?
        if (hs.contains(sokeTall[i])){
            //teller treff for å sammenligne med binærsøktreff
            treffHs++;
        }
    }
    //Tar tiden etter søk og regner ut deltatid
    long tidHS = System.nanoTime() - startHs;

    //Gjør det samme med tabellen
    long startTab = System.nanoTime();

    int treffTab = 0;
    for (int i = 0; i < 10000; i++){
        //bruker innebygget binærsøk for array. positiv er treff, negativ er ikke treff.
        if (Arrays.binarySearch(tab, sokeTall[i])>=0){
            treffTab++;
        }
    }
    long tidTab = System.nanoTime() - startTab;

    System.out.println("Treff i hashSet: " + treffHs +". Treff i tabell: " + treffTab + ".");
    System.out.println("Tid for hashsøk: "+ tidHS+ " nanosekunder. Tid for binærsøk: " + tidTab + " nanosekunder.");
}