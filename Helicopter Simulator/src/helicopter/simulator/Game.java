package helicopter.simulator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Game.
 * Main class that controls program flow.
 *
 */
class Game implements KeyListener {
  private boolean
          wStat,
          aStat,
          sStat,
          dStat,
          qStat,
          eStat,
          shiftStat,
          controlStat;
//private Renderer renderer;
  private Simulation simulation;
  private Timer timer;

  /**
   * start().
   * Starts the game.
   *
   */
  public void start() {
      simulation = new Simulation();
      simulation.start();

      //renderer = new Renderer();
      //renderer.start();

      System.out.println("Welcome to the helicopter simulator");

      timer = new Timer();
      timer.schedule(new UpdatePositionTask(), 0, 100);
  }

  /**
   * Will send the button press data to the simulation class and send the
   * calculated coordinates from the simulation class to the rendering class.
   *
   */
  class UpdatePositionTask extends TimerTask {

    public void run() {

      int accel = Simulation.ACCEL_NONE;
      int moveLR = Simulation.MOVE_NONE;
      int moveUD = Simulation.MOVE_NONE;
      int turn = Simulation.TURN_NONE;

      // Check for forward and backward movement.
      if (wStat && sStat) { // These cancel each other out.
        accel = Simulation.ACCEL_NONE;
      } else if (wStat) {
        accel = Simulation.ACCEL_FORWARD;
      } else if (sStat) {
        accel = Simulation.ACCEL_BACK;
      }

      // Check for left and right movement.
      if (qStat && eStat) {
        moveLR = Simulation.MOVE_NONE;
      } else if (qStat) {
        moveLR = Simulation.MOVE_LEFT;
      } else if (eStat) {
        moveLR = Simulation.MOVE_RIGHT;
      }

      // Check for up and down movement.
      if (controlStat && shiftStat) {
        moveUD = Simulation.MOVE_NONE;
      } else if (controlStat) {
        moveUD = Simulation.MOVE_DOWN;
      } else if (shiftStat) {
        moveUD = Simulation.MOVE_UP;
      }

      // Check for left and right turning.
      if (aStat && dStat) {
        turn = Simulation.TURN_NONE;
      } else if (aStat) {
        turn = Simulation.TURN_LEFT;
      } else if (dStat) {
        turn = Simulation.TURN_RIGHT;
      }

      // Send the data to the physics simulator.
      simulation.update(accel, moveLR, moveUD, turn);


      // Recieve the updated coordinates from the physics simulator.
      //renderer.setPosition(new Position(simulation.getX(), simulation.getY(), simulation.getHeight(), simulation.getDirection()));
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
      case 27: // Escape: Terminate Program
        System.exit(0);
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

/**
 * Holds helicopter position data.
 *
 */
class Position {
  private float xPos, yPos, height, direction;

  /**
   * No-arg constructor.
   *
   */
  public Position() {
    xPos = 0;
    yPos = 0;
    height = 0;
    direction = 0;
  }

  /**
   * Constructor.
   *
   * @param xPos The helicopters x-position.
   * @param yPos The helicopters y-position.
   * @param height The helicopters height (z-position).
   * @param direction The direction the helicopter is facing (in radians).
   *
   */
  public Position(float xPos, float yPos, float height, float direction) {
    this.xPos = xPos;
    this.yPos = yPos;
    this.height = height;
    this.direction = direction;
  }

  /**
   * Sets the helicopters x-position.
   *
   * @param xPos The helicopters x-position.
   *
   */
  public void setXPos(float xPos) {
    this.xPos = xPos;
  }

  /**
   * Sets the helicopters y-position.
   *
   * @param yPos The helicopters y-position.
   *
   */
  public void setYPos(float yPos) {
    this.yPos = yPos;
  }

  /**
   * Sets the helicopters height (z-position).
   *
   * @param height The helicopters height (z-position).
   *
   */
  public void setHeight(float height) {
    this.height = height;
  }

  /**
   * Sets the helicopters direction (in radians).
   *
   * @param direction The direction the helicopter is facing (in radians).
   *
   */
  public void setDirection(float direction) {
    this.direction = direction;
  }

  /**
   * Returns the helicopters x-position.
   *
   * @return The helicopters x-position.
   */
  public float getXPos() {
    return xPos;
  }

  /**
   * Returns the helicopters y-position.
   *
   * @return The helicopters y-position.
   */
  public float getYPos() {
    return yPos;
  }

  /**
   * Returns the helicopters height (z-position).
   *
   * @return The helicopters height (z-position).
   */
  public float getHeight() {
    return height;
  }

  /**
   * Returns the helicopters direction (in radians).
   *
   * @return The helicopters direction (in radians).
   */
  public float getDirection() {
    return direction;
  }

  public String toString() {
    return "X-Pos: " + xPos +
           "\nY-Pos: " + yPos +
           "\nZ-Pos: " + height +
           "\ndirection: " + direction;
  }
}
