package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotConstants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RampRelease extends Subsystem {
	
	SpeedController motor;
	DigitalInput limitswitch;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public RampRelease(SpeedController controller, DigitalInput limit) {
		motor = controller;
		motor.set(0.0);
		limitswitch = limit;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void DropRamps() {
    	motor.set(RobotConstants.holdRamps);
    }
    
    public void stop() {
    	motor.stopMotor();
    }
    
    public boolean rampsLowered() {
    	return limitswitch.get();
    }
}

