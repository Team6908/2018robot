package org.usfirst.frc.team6908.robot.commands.vision;

import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.commands.vision.PixyPacket;

public class VisionDrive {
	M_I2C i2c = new M_I2C();
	PixyPacket pkt = i2c.getPixy();

	public void centerOnObject(){
	if(pkt.x != -1){
		if(pkt.x < .48 || pkt.x > .52){
			while(pkt.x < .48 || pkt.x > .52){
				if(pkt.x < .48) {
					Robot.drivetrain.Drive(-.05, .1);
				}
				if(pkt.x > .52){
					Robot.drivetrain.Drive(.1, -0.5);
				}
				if(pkt.y == -1)
					break;
				pkt = i2c.getPixy();
				System.out.println("XPos: " + pkt.x);
			}

		}
}
}
}


