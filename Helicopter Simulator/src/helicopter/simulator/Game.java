/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helicopter.simulator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author jmdarling
 */
class Game implements KeyListener {
  Simulation simulation;
  /**
   * Starts the game.
   *
   */
  public void start() {
      simulation = new Simulation();
  }


  /**
   * Listener for a key being typed. Will not be used for the purposes of this
   * program.
   *
   * @param ke The key event being input.
   *
   */
  @Override
  public void keyTyped(KeyEvent ke) {
    // Unused
  }

  /**
   * Listens for a key being pressed. Sends the corresponding motion to update
   * the helicopter's position.
   *
   * @param ke The key event being input.
   *
   */
  @Override
  public void keyPressed(KeyEvent ke) {
    int keyPressed = ke.getKeyCode();

    switch(keyPressed) {
      case 87: // W: Forward
        simulation.update(Simulation.ACCEL_FORWARD,
                Simulation.MOVE_NONE,
                Simulation.MOVE_NONE,
                Simulation.TURN_NONE);
        break;
      case 65: // A: Rotate Counter Clockwise
        simulation.update(Simulation.ACCEL_NONE,
                Simulation.MOVE_NONE,
                Simulation.MOVE_NONE,
                Simulation.TURN_LEFT);
        break;
      case 83: // S: Rotate Clockwise
        simulation.update(Simulation.ACCEL_NONE,
                Simulation.MOVE_NONE,
                Simulation.MOVE_NONE,
                Simulation.TURN_RIGHT);
        break;
      case 68: // D: Backward
        simulation.update(Simulation.ACCEL_BACK,
                Simulation.MOVE_NONE,
                Simulation.MOVE_NONE,
                Simulation.TURN_NONE);
        break;
      case 81: // Q: Strafe Left
        simulation.update(Simulation.ACCEL_NONE,
                Simulation.MOVE_LEFT,
                Simulation.MOVE_NONE,
                Simulation.TURN_NONE);
        break;
      case 69: // E: Strafe Right
        simulation.update(Simulation.ACCEL_NONE,
                Simulation.MOVE_RIGHT,
                Simulation.MOVE_NONE,
                Simulation.TURN_NONE);
        break;
      case 16: // Shift: Increase Altitude
        simulation.update(Simulation.ACCEL_NONE,
                Simulation.MOVE_NONE,
                Simulation.MOVE_UP,
                Simulation.TURN_NONE);
        break;
      case 17: // Control: Decrease Altitude
        simulation.update(Simulation.ACCEL_NONE,
                Simulation.MOVE_NONE,
                Simulation.MOVE_DOWN,
                Simulation.TURN_NONE);
        break;
      default:
        simulation.update(Simulation.ACCEL_NONE,
                Simulation.MOVE_NONE,
                Simulation.MOVE_NONE,
                Simulation.TURN_NONE);
        break;
    }
  }

  /**
   * Listens for a key being released. Sends the corresponding motion to update
   * the helicopter's position.
   *
   * @param ke The key event being input.
   *
   */
  @Override
  public void keyReleased(KeyEvent ke) {
    simulation.update(Simulation.ACCEL_NONE,
                Simulation.MOVE_NONE,
                Simulation.MOVE_NONE,
                Simulation.TURN_NONE);
  }
}
