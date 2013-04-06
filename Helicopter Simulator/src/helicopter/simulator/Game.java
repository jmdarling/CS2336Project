/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helicopter.simulator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author jmdarling
 */
class Game implements KeyListener {
  private Simulation simulation;

  private Timer timer;
  private boolean wStat, aStat, sStat, dStat, qStat, eStat, shiftStat, controlStat;
  /**
   * Starts the game.
   *
   */
  public void start() {
      simulation = new Simulation();
      simulation.start();

      timer = new Timer();
      timer.schedule(new UpdatePositionTask(), 30);



  }

  class UpdatePositionTask extends TimerTask {

    public void run() {
      
    }

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
        wStat = true;
        break;
      case 65: // A: Rotate Counter Clockwise
        aStat = true;
        break;
      case 83: // S: Rotate Clockwise
        sStat = true;
        break;
      case 68: // D: Backward
        dStat = true;
        break;
      case 81: // Q: Strafe Left
        qStat = true;
        break;
      case 69: // E: Strafe Right
        eStat = true;
        break;
      case 16: // Shift: Increase Altitude
        shiftStat = true;
        break;
      case 17: // Control: Decrease Altitude
        controlStat = true;
        break;
      default:
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
    int keyReleased = ke.getKeyCode();

    switch(keyReleased) {
      case 87: // W: Forward
        wStat = false;
        break;
      case 65: // A: Rotate Counter Clockwise
        aStat = false;
        break;
      case 83: // S: Rotate Clockwise
        sStat = false;
        break;
      case 68: // D: Backward
        dStat = false;
        break;
      case 81: // Q: Strafe Left
        qStat = false;
        break;
      case 69: // E: Strafe Right
        eStat = false;
        break;
      case 16: // Shift: Increase Altitude
        shiftStat = false;
        break;
      case 17: // Control: Decrease Altitude
        controlStat = false;
        break;
      default:
        break;
    }
  }
}

class Helicopter {
  private float xPos, yPos, height, direction;

  public Helicopter() {
    xPos = 0;
    yPos = 0;
    height = 0;
    direction = 0;
  }

  public Helicopter(float xPos, float yPos, float height, float direction) {
    this.xPos = xPos;
    this.yPos = yPos;
    this.height = height;
    this.direction = direction;
  }


}
