/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helicopter.simulator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jmdarling
 */
class Game extends JFrame implements KeyListener {

  /**
   * Starts the game.
   *
   */
  public void start() {
      JTextField keyText = new JTextField(80);
      JLabel keyLabel = new JLabel("Press any key");
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
   * Listens for a key being pressed.
   *
   * @param ke The key event being input.
   *
   */
  @Override
  public void keyPressed(KeyEvent ke) {
    int keyPressed = ke.getKeyCode();

    switch(keyPressed) {
      case 87: // W: Forward
        break;
      case 65: // A: Rotate Counter Clockwise
        break;
      case 83: // S: Rotate Clockwise
        break;
      case 68: // D: Backward
        break;
      case 81: // Q: Strafe Left
        break;
      case 69: // E: Strafe Right
        break;
      case 16: // Shift: Increase Altitude
        break;
      case 17: // Control: Decrease Altitude
        break;
      default:
        break;
    }
  }

  /**
   * Listens for a key being released.
   *
   * @param ke The key event being input.
   *
   */
  @Override
  public void keyReleased(KeyEvent ke) {
    int keyReleased = ke.getKeyCode();

    switch(keyReleased) {
      case 87: // W: Forward
        break;
      case 65: // A: Rotate Counter Clockwise
        break;
      case 83: // S: Rotate Clockwise
        break;
      case 68: // D: Backward
        break;
      case 81: // Q: Strafe Left
        break;
      case 69: // E: Strafe Right
        break;
      case 16: // Shift: Increase Altitude
        break;
      case 17: // Control: Decrease Altitude
        break;
      default:
        break;
    }
  }
}
