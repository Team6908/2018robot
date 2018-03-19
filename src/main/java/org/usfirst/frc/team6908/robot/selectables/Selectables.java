package org.usfirst.frc.team6908.robot.selectables;

import org.usfirst.frc.team6908.robot.autocommands.*;
import org.usfirst.frc.team6908.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;

public class Selectables extends Command {

	Command LeftCommand;
	Command RightCommand;
	String Data;
	
	public Selectables(Command LeftOption, Command RightOption) {
		LeftCommand = LeftOption;
		RightCommand = RightOption;
		
	}
	
	public void execute() {
		System.out.println("Data="+Robot.gameData);
		switch(Robot.gameData.charAt(0)) {
		case 'L':
			LeftCommand.start();
			break;
		case 'R':
			RightCommand.start();
			break;
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
