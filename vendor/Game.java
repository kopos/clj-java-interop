import core.lib.rng;

public class Game {
  public int n;

  public Game() {
    this.n = rng.randInt(14);
  }

  public boolean doAction(int level) {
    int v = rng.randInt(14);
    if (level == -1 && n < this.n) {
      return true;
    } else if (level == 0 && n == this.n) {
      return true;
    } else if (level == 1 && n > this.n) {
      return true;
    }

    return false;
  }

  public static void main(String[] args) {
    Game g = new Game();
    System.out.println("Bet Number:" + Integer.toString(g.n));
    int[] levels = {-1, 0, 1};
    int level = levels[rng.randInt(3)];
    System.out.println("Made Bet: " + Integer.toString(level));
    System.out.println("Result: " + Boolean.toString(g.doAction(level)));
  }
}