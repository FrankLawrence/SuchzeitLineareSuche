public class randomNumber {
    int[] numberArray;
    public randomNumber(){
        numberArray = new int[32];
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = (int) Math.random()*100;
        }
    }

    public void suchen(){
        
    }
}
