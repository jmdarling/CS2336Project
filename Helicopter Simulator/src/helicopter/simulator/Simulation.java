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
	public static final int TURN_NONE=0;
	public static final int TURN_LEFT=1;
	public static final int TURN_RIGHT=2;

	// velocities in units per second
	private static final float LEFT_RIGHT_VELOCITY=10.0;
	private static final float UP_DOWN_VELOCITY=3.0;
	private static final float MAX_FORWARD_VELOCITY=20.0;
	private static final float MAX_BACKWARD_VELOCITY=2.0;
	// angular velocity in radians per second
	private static final float TURNING_ANGULAR_VELOCITY=30.0*Math.PI/180.0;
	// acceleration in units per second squared
	private static final float ACCELERATION=1.0;
	// height limits on the vehicle can achieve
	private static final float MIN_HEIGHT=10.0;
	private static final float MAX_HEIGHT=100.0;

	private float x,y; // x,y position of vehicle
	private float height; // height of vehicle
	private float vel; // magnitude of velocity of vehicle, in units per second
	private float dir; // direction of vehicle, in radians CW from N. Positive x is E, positive Y is N.
	private long lastUpdateTime; // time of last update in, using System.nanoTime()

	public Simulation()
	{
		// Initial position (0,0)
		x=0.0;
		y=0.0;
		// Initial height is in the middle
		height=(MIN_HEIGHT+MAX_HEIGHT)/2.0;
		// Initial velocity 0
		vel=0.0;
		// Initial direction North
		dir=0.0;
	}

	public float getX()
	{
		return x;
	}

	public float getY()
	{
		return y;
	}

	public float getHeight()
	{
		return height;
	}

	public float getDirection()
	{
		return dir;
	}

	// Must be called before any calls to update() method
	public void start()
	{
		lastUpdateTime=System.nanoTime();
	}

	// accel is one of ACCEL_* constants
	// moveLR is MOVE_NONE, MOVE_LEFT, or MOVE_RIGHT
	// moveUD is MOVE_NONE, MOVE_UP, or MOVE_DOWN
	// turn is TURN_NONE, TURN_LEFT, or TURN_RIGHT
	public void update(int accel,int moveLR,int moveUD,int turn)
	{
		float tmpa,tmpb;
		float acceleration;
		float vx,vy,vz,vangle;
		float cos_dir,sin_dir;
		long currentTime,deltaTime;

		switch(accel) {
		case ACCEL_FORWARD: acceleration=ACCELERATION; break;
		case ACCEL_BACK: acceleration=-ACCELERATION; break;
		default: acceleration=0.0; break;
		}

		switch(moveLR) {
		case MOVE_LEFT: vx=-LEFT_RIGHT_VELOCITY; break;
		case MOVE_RIGHT: vx=LEFT_RIGHT_VELOCITY; break;
		default: vx=0.0; break;
		}

		vy=0.0;

		switch(moveUD) {
		case MOVE_UP: vz=UP_DOWN_VELOCITY; break;
		case MOVE_DOWN: vz=-UP_DOWN_VELOCITY; break;
		default: vz=0.0; break;
		}

		switch(turn) {
		case TURN_LEFT: vangle=-TURNING_ANGULAR_VELOCITY; break;
		case TURN_RIGHT: vangle=TURNING_ANGULAR_VELOCITY; break;
		default: vangle=0.0; break;
		}

		currentTime=System.nanoTime();
		deltaTime=(currentTime-lastUpdateTime)/1000000.0; // convert nanoseconds to milliseconds
		lastUpdateTime=currentTime;
		
		dir+=vangle*deltaTime/1000.0; // update direction
		dir%=2.0*Math.PI;
		
		// Save sin, cos of direction
		cos_dir=Math.cos(dir);
		sin_dir=Math.sin(dir);
		
		// transform move left/right according to direction
		tmpa=vx; tmpb=vy;
		vx=tmpa*cos_dir + tmpb*sin_dir;
		vy=tmpb*cos_dir - tmpa*sin_dir;
		
		// update the forward/backward velocity of the helicopter according to the forward/back accel
		vel+=acceleration*deltatTime/1000.0;
		// keep velocity within limits
		if(vel>MAX_FORWARD_VELOCITY) vel=MAX_FORWARD_VELOCITY;
		else if(vel<-MAX_BACKWARD_VELOCITY) vel=-MAX_BACKWARD_VELOCITY;
		
		// add current velocity to vx,vy
		vx+=vel*sin_dir;
		vy+=vel*cos_dir;
		
		// update x,y position based on vx,vy
		x+=vx*deltaTime/1000.0;
		y+=vy*deltaTime/1000.0;
		
		// update height based on vz
		height+=vz*deltaTime/1000.0;
		// keep height within limits
		if(height<MIN_HEIGHT) height=MIN_HEIGHT;
		else if(height>MAX_HEIGHT) height=MAX_HEIGHT;
	}
}
