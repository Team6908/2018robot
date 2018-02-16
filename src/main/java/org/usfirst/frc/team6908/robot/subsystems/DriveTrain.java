package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotMap;

import org.usfirst.frc.team6908.robot.commands.ArcadeDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

@SuppressWarnings("unused")
public class DriveTrain extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
		RobotMap.frontRightT.setInverted(true);
		RobotMap.backRightT.setInverted(true);		
	}
	
	public void setLeftMotors (double speed) {
		RobotMap.frontLeftT.set(speed);
		RobotMap.backLeftT.set(speed); 
		SmartDashboard.putNumber("speed", speed);
	}
	
	public void setRightMotors (double speed) {
		RobotMap.frontRightT.set(speed);
		RobotMap.backRightT.set(speed);
	}

}
