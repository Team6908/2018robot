package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotConstants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Ramp extends Subsystem {

	SpeedController winch;
	DigitalInput limitswitch;
	
	//Sets the local winch motor controller to the inputed controller object
	public Ramp(SpeedController controller, DigitalInput limit) {
		winch = controller;
		limitswitch = limit;
	}
	
	//No default command
	@Override
	protected void initDefaultCommand() {

	}
	
	//Sets the motors speed to the speed defined in RobotConstants.java
	public void ReelInWinch(){
		winch.set(RobotConstants.kWinchSpeed);
	}
	
	public void ReelOutWinch() {
		winch.set(-RobotConstants.kWinchSpeed);
	}
	
	//Turns the motor off
	public void StopReeling(){
		winch.set(0.0);
	}
	
	public boolean isUp(){
		return limitswitch.get();
	}

}