package org.usfirst.frc.team6908.robot.autoPID;

import org.usfirst.frc.team6908.robot.Robot;

import edu.wpi.first.wpilibj.PIDOutput;

public class MoveForward implements PIDOutput {

	@Override
	public void pidWrite(double output) {
		Robot.drivetrain.Drive(-output, 0);

	}

}
