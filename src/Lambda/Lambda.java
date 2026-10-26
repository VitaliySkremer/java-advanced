package Lambda;

public class Lambda {
    static void main() {
        final int a = 0;

        Runner runner = new Runner((x, y) -> {
            System.out.println(x + y + a);
        });
    }
}
