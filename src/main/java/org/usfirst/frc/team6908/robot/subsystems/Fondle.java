package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotConstants;
import org.usfirst.frc.team6908.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Fondle extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void fondleIn() {
    	RobotMap.leftFlywheel.set(RobotConstants.maxFlywheelThrottle);
   		RobotMap.rightFlywheel.set(RobotConstants.minFlywheelThrottle);
    }
    
    public void fondleOut() {
    	RobotMap.leftFlywheel.set(RobotConstants.minFlywheelThrottle);
   		RobotMap.rightFlywheel.set(RobotConstants.maxFlywheelThrottle);
    }
    
    public void stopFondle() { 	
    	RobotMap.leftFlywheel.set(0);
		RobotMap.rightFlywheel.set(0);
    	
    	
    }
   
    
   
}

