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
                System.out.print(array[j]+"\t");
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

    public void suchzeitBinaer(int left, int right, int suchzahl){
        int median = teilen(left, right, suchzahl);
        if (suchzahl!=array[median]) {
         if (suchzahl<array[median] && left-median != 1 && right-median != 1) {
             suchzeitBinaer(left, median, suchzahl);
         }if (suchzahl>array[median] && left-median != 1 && right-median != 1) {
             suchzeitBinaer(median, right, suchzahl);
         }else{
             System.out.println("Nicht vorhanden");
         }
        }else{
            System.out.println(median);
        }
    }

    public int teilen(int left, int right, int suchzahl){
        return (right-left)/2+left;
    }
}
