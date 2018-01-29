package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseRightRamp extends Command {

	public RaiseRightRamp() {
		// Use requires() here to declare subsystem dependencies
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.rightramp.ReelInWinch();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.rightramp.StopReeling();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
