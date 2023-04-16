package GameManagingFiles;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            MapGenerator map = new MapGenerator(10, 10);
        }
    }
}