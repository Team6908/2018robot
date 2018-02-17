package org.usfirst.frc.team6908.robot.autocommands;

import edu.wpi.first.wpilibj.command.Command;

public class ASFR extends Selectables {
	
	static Command Left = new ASFRLeft();
	static Command Right = new ASFRRight();
	
    public ASFR(String gameData) {
        super(Left,Right,gameData);
    }
}
