
public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        game.intro();
    }

    public void intro() {
        Thread t = new Thread(() -> {
            printtype(
                    "Welcome to the infinity fortress! The game that manifests abominations beyond your imaginations",
                    50);
        });
        t.start();
    }

    public void printtype(String s, long duration) {
        // A new thread that detects if the enter key is pressed is included here!

        // Might have to use keyboard event listerner library

        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
    }
}
