package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotConstants;
import org.usfirst.frc.team6908.robot.RobotMap;
import org.usfirst.frc.team6908.robot.commands.ElevatorVariableControl;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Fondle extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
       
    }
    
    public void fondleIn() {
    	RobotMap.leftFlywheel.set(RobotConstants.maxFlywheelThrottle); //Set intake spinning towards robot
   		RobotMap.rightFlywheel.set(RobotConstants.minFlywheelThrottle);
    }
    
    public void fondleOut() {
    	RobotMap.leftFlywheel.set(RobotConstants.minFlywheelThrottle);//Set intake spinning outward to push box out
   		RobotMap.rightFlywheel.set(RobotConstants.maxFlywheelThrottle);
    }
    
    public void stopFondle() { 	
    	RobotMap.leftFlywheel.set(0);//Stop intake
		RobotMap.rightFlywheel.set(0);
    	
    	
    }
   
    
   
}

