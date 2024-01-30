// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  public Drivetrain() {
    
  }

  public void arcadeDriveCommand(double move, double turn) {
    if (Math.abs(move) < 0.1) move = 0;
    if (Math.abs(turn) < 0.1) turn = 0;
    // Do something with the move and turn values
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
