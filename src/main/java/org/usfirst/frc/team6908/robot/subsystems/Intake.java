package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void startIntake(double speed1, double speed2) {
    		RobotMap.leftFlywheel.set(speed1);
    		RobotMap.rightFlywheel.set(speed2);
    }
    
    public void stopIntake() {
    	
    	RobotMap.leftFlywheel.set(0);
		RobotMap.rightFlywheel.set(0);
    	
    	
    }
   
    
   
}

