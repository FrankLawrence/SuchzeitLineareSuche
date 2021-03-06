public class Array {
    int[] array;
    int[] sortedArray;
    boolean exists;
    int anzahlVBinear = 0;
    int[] numbers;
    int exist;
    private long laufzeit = 0;
    public Array(int aLaenge, int werteBereich, boolean random){
        array = new int[aLaenge];
        sortedArray = new int[werteBereich];
        if (!random) {
            for (int i = 0; i < aLaenge; i++) {
                double a = Math.random()*werteBereich;
                if (sortedArray[(int)a] == (int)a) {
                    i--;
                }else{
                    array[i] = (int) a;
                    sortedArray[(int)a] = (int) a;
                }
            }
        }else{
            for (int i = 0; i < aLaenge; i++) {
                double a = Math.random()*werteBereich;
                array[i] = (int) a;
            }
        }
    }

    public long anzahlVergleiche(int nLaenge, int werteBereich, boolean vergleiche){
        long startzeit = System.currentTimeMillis();
        numbers = new int[nLaenge];
        int anzahlVLinear = 1;
        int anzahlVergleiche = 0;
        for (int i = 0; i < numbers.length; i++) {
            double a = Math.random()*werteBereich;
            for(int j=0; j<anzahlVLinear;){
                if((int)a!=numbers[j]){
                    numbers[i] = (int) a;
                    anzahlVLinear++;
                    break;
                }
                else{
                    i--;
                    break;
                }
            }
        }
        // numbers Array mit nLaenge zufällig erzeugten Zahlen
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
        if (vergleiche) {
            return anzahlVergleiche;
        }else{
            return laufzeit = (System.currentTimeMillis() - startzeit);
        }
    }

    public void printArray(){
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < 10; i++) {
                System.out.print(array[j]+"\t");
                j++;
                if (j==array.length) {
                    break;
                }
            }
            System.out.println("");
        }
        
    }

    public int indexLinear(int suchzahl){
        for (int i = 0; i < array.length; i++) {
            if (array[i]== suchzahl) {
                return i;
            }
        }
        return array.length;
    }

    private void tauscheElementeAnPositionen(int first, int second) {
        int placeholder = array[first];
        array[first] = array[second];
        array[second] = placeholder;
    }

    private int teile(int anfang, int ende){
        int left= anfang;
        int right = ende-1;
        int pivot = array[ende];
        while (left<right){
            while (left< ende && array[left] <= pivot){
                left++;
            }
            while (right > anfang && array[right] > pivot){
                right--;
            }
            if (left< right){
                tauscheElementeAnPositionen(left,right);
            }
        }
        if (array[left] > pivot){
            tauscheElementeAnPositionen(left,ende);
        }
        return left;
    }

    public void quicksort (int anfang, int ende){
        if (anfang<ende){
            int teiler = teile(anfang,ende);
            quicksort(anfang,teiler-1);
            quicksort(teiler+1,ende);
        }
    }

    public int indexBinaer(int left, int right, int suchzahl){
        int median = teilen(left, right);
        if (suchzahl!=array[median]) {
         if (suchzahl<array[median] && left-median != 1 && right-median != 1) {
             return indexBinaer(left, median-1, suchzahl);
             
         }if (suchzahl>array[median] && left-median != 1 && right-median != 1) {
             return indexBinaer(median+1, right, suchzahl);
             
         }else{
             return array.length;
         }
        }else{
            return median;
        }
    }

    public int suchzeitBinaer(int left, int right, int suchzahl){
        anzahlVBinear++;
        int median = teilen(left, right);
        if (suchzahl!=array[median]) {
         if (suchzahl<array[median] && left-median != 1 && right-median != 1) {
             return suchzeitBinaer(left, median, suchzahl);
             
         }if (suchzahl>array[median] && left-median != 1 && right-median != 1) {
             return suchzeitBinaer(median, right, suchzahl);
             
         }else{
             return anzahlVBinear;
         }
        }else{
            return anzahlVBinear;
        }
    }

    private int teilen(int left, int right){
        return (right-left)/2+left;
    }

    public void suchzeitBinearDurchschnitt(int nLaenge, int werteBereich, Boolean showAll){
        numbers = new int[nLaenge];
        int anzahlVLinear = 1;
        for (int i = 0; i < numbers.length; i++) {
            double a = Math.random()*werteBereich;
            for(int j=0; j<anzahlVLinear;){
                if((int)a!=numbers[j]){
                    numbers[i] = (int) a;
                    anzahlVLinear++;
                    break;
                }
                else{
                    i--;
                    break;
                }
            }
        }
        if (showAll) {
            System.out.print("Anzahl Verglieche Binearsuche: ");
        }
        for (int i = 0; i < numbers.length; i++) {
            int subractVergleiche = anzahlVBinear;
            int vergleich1 = suchzeitBinaer(0, array.length, numbers[i]);
            if (showAll){
                System.out.print(vergleich1-subractVergleiche+" ");
            }
        }      
        System.out.println("");
        System.out.println("Durchschnitt Vergleiche Binearsuche: " + anzahlVBinear/numbers.length);
    }

    public int indexInterpolation(int werteBereich, int suchzahl){
        int einstieg = suchzahl/(werteBereich/array.length);
        if (array[einstieg]>suchzahl) {
            for (int i=einstieg; i > 0; i--){
              if (array[i]==suchzahl)
              {
                  exist = i;
                  break;
              }
              else if (array[i] > suchzahl)
              {
                exist = array.length;
                break;
              }
            }
        }if (array[einstieg]<suchzahl) {
            for (int i=einstieg; i < array.length; i++)
              if (array[i]==suchzahl)
              {
                 exist = i;
                 break;
              }
              else if (array[i] > suchzahl)
              {
                 exist = array.length;
                 break;
              }
        }
        if (exist == array.length) {
            return array.length;
        }else{
            return exist;
        }
    }

    public int indexInterpolationQuicksort(int werteBereich, int suchzahl){
        int einstieg = suchzahl/(werteBereich/array.length);
        if (einstieg>=array.length) {
            return array.length;
        }if (array[einstieg]>suchzahl) {
            return indexBinaer(0, einstieg, suchzahl);
        }if (array[einstieg]<suchzahl) {
            return indexBinaer(einstieg, array.length-1, suchzahl);
        }else{
            return einstieg;
        }
    }
}
