package org.usfirst.frc.team6908.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.RobotMap;


public class StaticHeightControl extends Command {
	
	private static double distance;
	
	public StaticHeightControl(double dist) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.elevator);
		StaticHeightControl.distance = dist * -1;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
		Robot.elevator.ePID.setSetpoint(distance);
		SmartDashboard.putNumber("Encoder", RobotMap.elevatorEncoder.getDistance());
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return (Robot.elevator.ePID.onTarget());
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.elevator.ePID.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}