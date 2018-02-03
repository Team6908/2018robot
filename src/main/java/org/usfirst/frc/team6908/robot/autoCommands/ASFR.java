package org.usfirst.frc.team6908.robot.autoCommands;

import edu.wpi.first.wpilibj.command.Command;

public class ASFR extends Selectables {
	
	static Command Left = new ASFRLeft();
	static Command Right = new ASFRRight();
	
    public ASFR(String gameData) {
        super(Left,Right,gameData);
    }
}
