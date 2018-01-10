package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {
	
	public TankDrive() {
		//put dependencies of the subsystem here
		requires(Robot.drivetrain); //requires the drivetrain object instantiated in Robot.java
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		double leftSideSpeed = Robot.oi.Joystick1.getY();
		double rightSideSpeed = Robot.oi.Joystick2.getY();
		double acceleration = Robot.oi.Joystick1.getThrottle();
        acceleration = (((-0.8 * (acceleration +1)) / 2) + 1); 
        System.out.println(acceleration);
        
        Robot.drivetrain.Drive((leftSideSpeed*acceleration), (rightSideSpeed*acceleration));	
        		
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
