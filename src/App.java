public class App {
    public static void main(String[] args) {
        int laenge = 100; //laenge des ersten Arrays
        int nLaenge = 10; //laenge des zweiten Arrays
        int werteBereich = 100; //Wertebereich der Zahlen
        random100 array = new random100(laenge, werteBereich); //neues Array mit obigen Werten
        int anzahlVergleiche = array.anzahlVergleiche(nLaenge, werteBereich); 
        int Durchschnitt = anzahlVergleiche/nLaenge; //zeigt Anzahl Vergleiche der nLaenge Zahlen
        System.out.println("Anzahl Vergleiche: " + anzahlVergleiche); 
        System.out.println("Durchschnitt Vergleiche: " + Durchschnitt); //zeigt Anzahl Vergleiche pro Zahl
        int anzahlVersuche = 100;
        int Durchschnitt10 = 0;
        for (int i = 0; i < anzahlVersuche; i++) { //zeigt Anzahl Vergleiche pro Zahl (anzahlVersuche) mal aus, und rechnet genaueren Durchschnitt pro Zahl aus
            int b = array.anzahlVergleiche(nLaenge, werteBereich)/nLaenge;
            System.out.print(b +" ");
            Durchschnitt10 = Durchschnitt10 + b;
            if (i==anzahlVersuche-1) {
                System.out.println("");
                System.out.println("Durchschnitt: "+ Durchschnitt10/anzahlVersuche );
            }
        }
        array.quicksort(0, laenge-1); //sortiert Array
        array.printArray();
        System.out.println(array.indexBinaer(0, laenge-1, 60)); //rechnet index von Nummer mit Binearsuche aus
        System.out.println("Anzahl Vergleiche: " + array.suchzeitBinaer(0, laenge-1, 60)); // rechnet Anzahl der Vergleiche um Nummer zu finden
    }
}
