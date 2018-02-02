package org.usfirst.frc.team6908.robot.autoCommands;

import org.usfirst.frc.team6908.robot.autoCommands.Selectables;

import edu.wpi.first.wpilibj.command.Command;

public class A3FM extends Selectables {
	static Command Left = new A3FMLeft();
	static Command Right = new A3FMRight();
	
	public A3FM(String GameData) { 
		super(Left, Right, GameData);
	}
}
