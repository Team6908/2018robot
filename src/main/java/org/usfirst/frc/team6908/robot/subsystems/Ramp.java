package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotConstants;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Ramp extends Subsystem {

	SpeedController winch;
	
	//Sets the local winch motor controller to the inputed controller object
	public Ramp(SpeedController controller) {
		winch = controller;
	}
	
	//No default command
	@Override
	protected void initDefaultCommand() {\

	}
	
	//Sets the motors speed to the speed defined in RobotConstants.java
	public void ReelInWinch(){
		winch.set(RobotConstants.kWinchSpeed);
	}
	
	//Turns the motor off
	public void StopReeling(){
		winch.set(0.0);
	}

}
