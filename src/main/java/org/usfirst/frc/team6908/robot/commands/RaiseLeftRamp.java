package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseLeftRamp extends Command {

	public RaiseLeftRamp() {

	}

	//Nothing needs to happen here
	@Override
	protected void initialize() {
		
	}

	//Turns on winch
	@Override
	protected void execute() {
		Robot.leftramp.ReelInWinch();
	}

	//Command does not finished unless interrupted
	@Override
	protected boolean isFinished() {
		return false;
	}

	//When the command is over, set the winch back to 0
	@Override
	protected void end() {
		Robot.leftramp.StopReeling();
	}

	//When the command is interrupted, end it
	@Override
	protected void interrupted() {
		end();
	}
}
