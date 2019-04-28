import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;

public class Test {

    public void testLargeTree(int cap) {
        System.out.println("LET'S TEST IT!");
        long started;
        long time = 0;
        long finished;
        BTree<Integer, Integer> tree = new BTree<Integer, Integer>();
        ArrayList<Integer> numbers = new ArrayList<Integer>(cap);
        for (int i = 0; i < cap; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < cap; i++) {
            tree.insert(numbers.get(i), numbers.get(i));
        }
        int k =(int)(Math.random()*100);
        System.out.println("size:"+cap);
        System.out.println("To add:"+k);
        started = System.nanoTime();
        tree.insert(k,k*1000);
        finished = System.nanoTime();
        time = finished - started;
        Result add = new Result("add", cap, time);
        writeResult(add);
        System.out.println("added");
        System.out.println("ADD_TIME:"+time);


        System.out.println("size:"+cap);
        System.out.println("To found:"+"l");
        started = System.nanoTime();
        tree.search(k);
        finished = System.nanoTime();
        time = finished - started;
        Result found = new Result("found", cap, time);
        writeResult(found);
        System.out.println("found");
        System.out.println("FTIME:"+time);


        System.out.println("size:"+cap);
        System.out.println("To delete:"+k);
        started = System.nanoTime();
        tree.delete(k);
        finished = System.nanoTime();
        time = finished - started;
        System.out.println("deleted");
        Result del = new Result("del",cap, time);
        writeResult(del);
        System.out.println("TIME:"+time);
        System.out.println(" ");
    }




    public static void writeResult(Result result) {
        try {
            String filename = result.name + ".csv";
            File file = new File(filename);
            String data = String.valueOf(result.size) + ";" + String.valueOf(result.time) + "\n";
            Files.write(file.toPath(), data.getBytes("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected static class Result {

        public String name;
        public int size;
        public long time;
        public double dispersion = 0.0;

        public Result(String name, int size, long time) {
            this(name, size, time, 0.0);
        }

        public Result(String name, int size, long time, double dispersion) {
            this.name = name;
            this.size = size;
            this.time = time;
            this.dispersion = dispersion;
        }

    }
}
