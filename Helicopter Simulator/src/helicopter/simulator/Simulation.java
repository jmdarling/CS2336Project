package helicopter.simulator;

final class Simulation
{
	public static final int ACCEL_NONE=0;
	public static final int ACCEL_FORWARD=1;
	public static final int ACCEL_BACK=2;
	public static final int MOVE_NONE=0;
	public static final int MOVE_LEFT=1;
	public static final int MOVE_RIGHT=2;
	public static final int MOVE_UP=3;
	public static final int MOVE_DOWN=4;

	private static final float LEFT_RIGHT_VELOCITY=10.0;
	private static final float UP_DOWN_VELOCITY=3.0;

	private float x,y; // x,y position of vehicle
	private float height; // height of vehicle
	private float vel; // magnitude of velocity of vehicle
	private float dir; // direction of vehicle, in radians CW from N

	public Simulation()
	{
		// Initial position (0,0)
		x=0.0;
		y=0.0;
		// Initial height is 10.0
		height=10.0;
		// Initial velocity 0
		vel=0.0;
		// Initial direction North
		dir=0.0;
	}

	// Must be called before any calls to update() method
	public void start()
	{
	}

	// accel is one of ACCEL_* constants
	// moveLR is MOVE_NONE, MOVE_LEFT, or MOVE_RIGHT
	// moveUD is MOVE_NONE, MOVE_UP, or MOVE_DOWN
	public void update(int accel,int moveLR,int moveUD)
	{
	}
}
