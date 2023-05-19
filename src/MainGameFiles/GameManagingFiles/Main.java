package MainGameFiles.GameManagingFiles;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            System.out.println(i);
            MapGenerator map = new MapGenerator(10, 10);
        }
        long time2 = System.currentTimeMillis();
        long time3 = time2 - time;
        System.out.println(time3);
    }
}