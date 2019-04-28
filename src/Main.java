
public class Main {

    public static void main(String[] args) {
        int k = 100;
        Test test = new Test();
       for (int i = 0; i < 200; i++){
           test.testLargeTree(k);
           if (k < 10000) k+=50;
           else break;
       }
    }
}
