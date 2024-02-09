// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Climb

    // Drivetrain
    public static class OperatorConstants {
        public static final int kDriverControllerPort = 0;
        public static final int kOperatorStickPort = 1;
      }
    // Intake
    // CAN IDs for motor controllgiers
    public static int kHighIntakeID = 5; // Replace 4 with the actual value of kHighIntakeID
    public static int kLowIntakeID = 6; // Replace 5 with the actual value of kLowIntakeID
  
    public static final double kHighIntakeSpeed = -1; // Update this with your desired intake speed
    public static final double kLowIntakeSpeed = 1; // Did it thanks bro
    // Shooter
    public static int kRightShooterID = 7; // Replace 7 with the actual value of kRightShooterID
    public static int kLeftShooterID = 8;

    public static final double kShooterSpeed = 0.25; 
    // Controllers
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorControllerPort = 1;

    
}