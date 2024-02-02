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

    // Intake
    // CAN IDs for motor controllers
    // Example IDs and values
    public static final int kIntakeMotorID = 5; // Update this with your motor's CAN ID
    public static final double kIntakeSpeed = 0.5; // Update this with your desired intake speed

    // Shooter

    // Controllers
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorControllerPort = 1;
}