public class App {
    public static void main(String[] args) {
        int laenge = 100;
        int nLaenge = 10;
        int werteBereich = 100;
        random100 array = new random100(laenge, werteBereich);
        int anzahlVergleiche = array.anzahlVergleiche(nLaenge, werteBereich);
        int Durchschnitt = anzahlVergleiche/nLaenge;
        System.out.println("Anzahl Vergleiche: " + anzahlVergleiche);
        System.out.println("Durchschnitt Vergleiche: " + Durchschnitt);
        int anzahlVersuche = 100;
        int Durchschnitt10 = 0;
        for (int i = 0; i < anzahlVersuche; i++) {
            int b = array.anzahlVergleiche(nLaenge, werteBereich)/nLaenge;
            System.out.print(b +" ");
            Durchschnitt10 = Durchschnitt10 + b;
            if (i==anzahlVersuche-1) {
                System.out.println("");
                System.out.println("Durchschnitt: "+ Durchschnitt10/anzahlVersuche );
            }
        }
        array.quicksort(0, laenge-1);
        array.printArray();
        System.out.println(array.indexBinaer(0, laenge-1, 60));
    }
}
