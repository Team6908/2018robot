package org.usfirst.frc.team6908.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RampDrop extends Subsystem {
	
	SpeedController motor;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public RampDrop(SpeedController controller, double speed) {
		motor = controller;
		controller.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void DeployRamp() {
    	motor.stopMotor();
    }
    
    public void start(double speed) {
    	motor.set(speed);
    }
}

