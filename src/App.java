public class App {
    public static void main(String[] args) {
        System.out.println("");
        int laenge = 60; //laenge des ersten Arrays
        int nLaenge = 100; //laenge des zweiten Arrays
        int werteBereich = 100; //Wertebereich der Zahlen
        Array array = new Array(laenge, werteBereich); //neues Array mit obigen Werten
        long anzahlVergleiche = array.anzahlVergleiche(nLaenge, werteBereich, true); 
        long zeitVergleiche = array.anzahlVergleiche(nLaenge, werteBereich, false);
        long Durchschnitt = anzahlVergleiche/nLaenge; //zeigt Anzahl Vergleiche der nLaenge Zahlen
        System.out.println("Anzahl Vergleiche Linearsuche: " + anzahlVergleiche); 
        System.out.println("Zeit Vergleiche Linearsuche: " + zeitVergleiche);
        System.out.println("Durchschnitt Vergleiche Linearsuche pro Zahl: " + Durchschnitt); //zeigt Anzahl Vergleiche pro Zahl
        int anzahlVersuche = 1;
        long Durchschnitt10 = 0;
        for (int i = 0; i < anzahlVersuche; i++) { //zeigt Anzahl Vergleiche pro Zahl (anzahlVersuche) mal aus, und rechnet genaueren Durchschnitt pro Zahl aus
            long b = array.anzahlVergleiche(nLaenge, werteBereich, true)/nLaenge;
            //System.out.print(b +" ");
            Durchschnitt10 = Durchschnitt10 + b;
            if (i==anzahlVersuche-1) {
                //System.out.println("");
                System.out.println("Durchschnitt Linearsuche genau: "+ Durchschnitt10/anzahlVersuche );
            }
        }
        int index = 600;
        array.quicksort(0, laenge-1); //sortiert Array
        array.printArray();
        if (array.indexBinaer(0, laenge-1, index)==laenge) {
            System.out.println(index+" in Array nicht vorhanden");
        }else{
            System.out.println("Index von "+index+": " + array.indexBinaer(0, laenge-1, index)); //rechnet index von Nummer mit Binearsuche aus
        }
        //System.out.println("Anzahl Vergleiche Binearsuche: " + array.suchzeitBinaer(0, laenge-1, index)); // rechnet Anzahl der Vergleiche um Nummer zu finden
        array.suchzeitBinearDurchschnitt(nLaenge, werteBereich, false);
        System.out.println("");
    }
}
