package org.usfirst.frc.team6908.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6908.robot.autoCommands.*;
import org.usfirst.frc.team6908.robot.commands.*;
import org.usfirst.frc.team6908.robot.subsystems.*;
import org.usfirst.frc.team6908.robot.selectables.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static DriveTrain drivetrain = new DriveTrain();
	public static CameraServer server;
	public static Fondle fondle = new Fondle();
	public static String gameData;
//	private static Scanner scan = new Scanner(System.in);

	Command autoCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		oi = new OI();
		chooser.addDefault("Default Auto", new ExampleCommand());
		chooser.addObject("A3FM", new A3FM(gameData));
		chooser.addObject("ASFR", new ASFR(gameData));
		chooser.addObject("ASFL", new ASFL(gameData));
		chooser.addObject("Baseline", new BaselineDrive());
		
		CameraServer.getInstance().startAutomaticCapture();
		CameraServer.getInstance().startAutomaticCapture("Front Camera", 0);
		CameraServer.getInstance().startAutomaticCapture("Back Camera", 1);
		
		SmartDashboard.putData("Auto mode", chooser);
		SmartDashboard.putString("Game Data", gameData);
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
		autoCommand = chooser.getSelected();
		
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autoCommand != null)
			autoCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
        SmartDashboard.putNumber("Guyro Fieri", Robot.drivetrain.getGyroAngle());
    	SmartDashboard.putNumber("Left Distance", RobotMap.leftEncoder.getDistance());
    	SmartDashboard.putNumber("Right Distance", RobotMap.rightEncoder.getDistance());

	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autoCommand != null)
			autoCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
//		LiveWindow.disableAllTelemetry();
		LiveWindow.setEnabled(true);
		LiveWindow.add(RobotMap.leftEncoder);
	}
}
