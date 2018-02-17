package org.usfirst.frc.team6908.robot.autoPID;

import org.usfirst.frc.team6908.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class DeltaEncoders implements PIDSource {

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		// TODO Auto-generated method stub

	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return PIDSourceType.kRate;
	}

	@Override
	public double pidGet() {
		// TODO Auto-generated method stub
		return DriveTrain.leftEncoder.getRate() + DriveTrain.rightEncoder.getRate();
	}

}
