package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotMap;

import org.usfirst.frc.team6908.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class DriveTrain extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());
		RobotMap.frontRight.setInverted(true);
		RobotMap.backRight.setInverted(true);
		
		RobotMap.frontRight.setName("Drive Motors", "frontRight");
		RobotMap.frontLeft.setName("Drive Motors", "frontLeft");
		RobotMap.backRight.setName("Drive Motors", "backRight");
		RobotMap.backLeft.setName("Drive Motors", "backLeft");
		
		LiveWindow.add(RobotMap.frontRight);
		LiveWindow.add(RobotMap.frontLeft);
		LiveWindow.add(RobotMap.backRight);
		LiveWindow.add(RobotMap.backLeft);
		
	}
	
	public void Drive (double speedLeft, double speedRight) {
		
		RobotMap.frontRight.set(speedRight);
		RobotMap.backRight.set(speedRight);
		RobotMap.frontLeft.set(speedLeft);
		RobotMap.backLeft.set(speedLeft); 	
	}	

}