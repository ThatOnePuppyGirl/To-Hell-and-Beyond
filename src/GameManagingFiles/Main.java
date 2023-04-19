package GameManagingFiles;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            System.out.println(i);
            MapGenerator map = new MapGenerator(10, 10);
            int[] w = map.FindLongestConnections();
            System.out.println(w[0] + " x: " + w[1] + " y: " + w[2]);
        }
        long time2 = System.currentTimeMillis();
        long time3 = time2 - time;
        System.out.println(time3);
    }
}