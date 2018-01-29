package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotConstants;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Ramp extends Subsystem {

	SpeedController winch;
	
	public Ramp(SpeedController controller) {
		winch = controller;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void ReelInWinch(){
		winch.set(RobotConstants.kWinchSpeed);
	}
	
	public void StopReeling(){
		winch.set(0.0);
	}

}
