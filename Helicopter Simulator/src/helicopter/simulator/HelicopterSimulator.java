/**
 * Helicopter Simulator.
 *
 * This application simulates a remote control helicopter. The helicopter can be
 * viewed from either the top or side. The application's user will be able to
 * move the helicopter using keyboard input.
 *
 */
package helicopter.simulator;

/**
 * Main class.
 */
public class HelicopterSimulator {

  /**
   * Begins program execution.
   *
   * @param args the command line arguments
   *
   */
  public static void main(String[] args) {
    Game game = new Game();
    game.start();
  }
}
