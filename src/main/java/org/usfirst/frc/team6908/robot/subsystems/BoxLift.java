package org.usfirst.frc.team6908.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BoxLift extends Subsystem {

	public static Talon leftRoller = new Talon(0);
	public static Talon rightRoller = new Talon(0);
	public static Talon liftPulley = new Talon(0);
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public static void setLRSpeed(double speed){
		leftRoller.setSpeed(speed);
	}
	
	public static void setRRSpeed(double speed){
		rightRoller.setSpeed(speed);
	}
	
	public static void setPulleySpeed(double speed){
		liftPulley.setSpeed(speed);
	}

}
