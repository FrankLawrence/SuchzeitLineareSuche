public class random100 {
    int[] array;
    int anzahl = 1;
    public random100(int aLaenge, int werteBereich){
        array = new int[aLaenge];
        for (int i = 0; i < array.length; i++) {
            double a = Math.random()*werteBereich;
            for(int j=0; j<anzahl;){
                if((int)a!=array[j]&&a!=0){
                    array[i] = (int) a;
                    anzahl++;
                    break;
                }
                else{
                    i--;
                    break;
                }
            }
        }
    }

    public int anzahlVergleiche(int nLaenge, int werteBereich){
        int[] numbers = new int[nLaenge];
        int anzahl = 1;
        int anzahlVergleiche = 0;
        for (int i = 0; i < numbers.length; i++) {
            double a = Math.random()*werteBereich;
            for(int j=0; j<anzahl;){
                if((int)a!=numbers[j]){
                    numbers[i] = (int) a;
                    anzahl++;
                    break;
                }
                else{
                    i--;
                    break;
                }
            }
        }
        // numbers Array mit 100 zufällig erzeugten Zahlen
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (numbers[i]==array[j]) {
                    anzahlVergleiche++;
                    break;
                }
                else{
                    anzahlVergleiche++;
                }
            }
            //System.out.println(anzahlVergleiche);
        }
        // durchlaufen von array und vergleich mit jeder Zahl in numbers
        return anzahlVergleiche;
    }

    public void printArray(){
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < 10; i++) {
                System.out.print(array[j]+" ");
                j++;
            }
            System.out.println("");
        }
        
    }

    public int gibIndex(int suchzahl){
        for (int i = 0; i < array.length; i++) {
            if (array[i]== suchzahl) {
                return i;
            }
        }
        return array.length;
    }
}
