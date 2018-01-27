package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotMap;
import org.usfirst.frc.team6908.robot.commands.ArcadeDrive;
import org.usfirst.frc.team6908.robot.commands.ElevatorVariableControl;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

    public void extend(double speed) {
    		RobotMap.elevator.set(speed);
    }

    public void initDefaultCommand() {
    		setDefaultCommand(new ElevatorVariableControl());
    }
}

