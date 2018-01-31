package org.usfirst.frc.team6908.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6908.robot.Robot;


public class StaticHeightControl extends Command {
	
	private static double distance;
	
	public StaticHeightControl(double dist) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.elevator);
		StaticHeightControl.distance = (dist * (2*Math.PI) / 255);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.elevator.elevatorEncoder.reset();
		Robot.elevator.ePID.setAbsoluteTolerance(1);
		Robot.elevator.ePID.enable();
		Robot.elevator.ePID.setOutputRange(-.5, .5);
		Robot.elevator.ePID.setSetpoint(distance);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if(Robot.elevator.ePID.onTarget()) {
			return true;
		}else {
			return false;
		}
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
	}
}
