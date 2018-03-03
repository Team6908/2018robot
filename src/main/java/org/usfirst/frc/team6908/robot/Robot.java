package org.usfirst.frc.team6908.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;
import java.util.Scanner;

import org.usfirst.frc.team6908.robot.autocommands.*;
import org.usfirst.frc.team6908.robot.commands.*;
import org.usfirst.frc.team6908.robot.selectables.A3FM;
import org.usfirst.frc.team6908.robot.selectables.ASFL;
import org.usfirst.frc.team6908.robot.selectables.ASFR;
import org.usfirst.frc.team6908.robot.subsystems.*;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static OI oi;
	public static DriveTrain drivetrain = new DriveTrain();
	public static CameraServer server;
	public static Fondle fondle = new Fondle();
	public static Elevator elevator = new Elevator();
	private static String gameData = "hello";

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	@Override
	public void robotInit() {
		while(gameData.equals("hello")) {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		}
		oi = new OI();
		
		
		chooser.addDefault("Default Auto", new BaselineDrive());
		chooser.addObject("A3FM", new A3FM(gameData));
		chooser.addObject("ASFR", new ASFR(gameData));
		chooser.addObject("ASFL", new ASFL(gameData));
		chooser.addObject("Baseline", new BaselineDrive());
		RobotMap.elevatorEncoder.reset();
//		CameraServer.getInstance().startAutomaticCapture();
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		//SmartDashboard.putString("Game Data", gameData);
//		System.out.println("Write the Direction");
//		gameData = scan.next();
//        if(gameData.charAt(0) == 'L')
//        {
//            new A3FMLeft();
//        } else {
//            new A3FMRight();
//        }
//		CameraServer.getInstance().startAutomaticCapture("Front Camera", 0);
//		CameraServer.getInstance().startAutomaticCapture("Back Camera", 1);
		
	}


	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
		
		
		autonomousCommand = chooser.getSelected();
		
		
		
		RobotMap.elevatorEncoder.reset();
    
		if (autonomousCommand != null)
			autonomousCommand.start();
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
        SmartDashboard.putNumber("Guyro Fieri", DriveTrain.gyro.getAngle());
//   	SmartDashboard.putNumber("Left Distance", RobotMap.leftEncoder.getDistance());
//    	SmartDashboard.putNumber("Right Distance", RobotMap.rightEncoder.getDistance());
//    	SmartDashboard.putNumber("Error", DriveTrain.driftfix.getError());
		SmartDashboard.putNumber("Elevator Encoder", RobotMap.elevatorEncoder.getDistance());
		SmartDashboard.putBoolean("Top Limit Switch",elevator.isAtTop());
		SmartDashboard.putBoolean("Bottom Limit Switch", elevator.isAtBottom());
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Elevator Encoder", RobotMap.elevatorEncoder.getDistance());
		SmartDashboard.putBoolean("Top Limit Switch",elevator.isAtTop());
		SmartDashboard.putBoolean("Bottom Limit Switch", elevator.isAtBottom());
		SmartDashboard.putNumber("Servo", RobotMap.servo.getAngle());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.setEnabled(true);
	}
}