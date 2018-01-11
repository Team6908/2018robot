package org.usfirst.frc.team6908.robot.commands.vision;

import org.usfirst.frc.team6908.robot.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PixyVision{

public static void printPixyStuff(){
	byte[] pixyValues = new byte[64];
	pixyValues[0] = (byte) 0b01010101;
	pixyValues[1] = (byte) 0b10101010;

	RobotMap.pixyi2c.readOnly(pixyValues, 64);
	if (pixyValues != null) {
		int i = 0;
		while (!(pixyValues[i] == 85 && pixyValues[i + 1] == -86) && i < 50) {
			i++;
		}
		i++;
		if (i > 50)
			i = 49;
		while (!(pixyValues[i] == 85 && pixyValues[i + 1] == -86) && i < 50) {
			i++;
		}
		double xPosition = (char) (((pixyValues[i + 7] & 0xff) << 8) | (pixyValues[i + 6] & 0xff));
		double yPosition = (char) ((pixyValues[i + 9] & 0xff << 8) | pixyValues[i + 8] & 0xff);
		double width = (char) ((pixyValues[i + 11] & 0xff << 8) | pixyValues[i + 10] & 0xff);
		double height = (char) ((pixyValues[i + 13] & 0xff << 8) | pixyValues[i + 12] & 0xff);

		SmartDashboard.putNumber("xPosition", xPosition);
		SmartDashboard.putNumber("yPosition", yPosition);
		SmartDashboard.putNumber("width", width);
		SmartDashboard.putNumber("height", height);
		SmartDashboard.putNumber("Raw 5", pixyValues[5]);
		
		
		System.out.println(xPosition + " : X Position");

	}
	
}


}
