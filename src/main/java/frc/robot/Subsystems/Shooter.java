// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

 package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants; // Import the Constants class
import edu.wpi.first.wpilibj.Timer; // Import the Timer class

public class Shooter extends SubsystemBase {

  private boolean isShooterOn = false;
  private boolean isArkhipovOn = false;

  Talon m_rightshooter = new Talon(7);
  Talon m_leftshooter = new Talon(8);
  /** Creates a new Shooter. */

  public void setrightshooter(double speed) {
  m_rightshooter.set(speed);
  }

  public void setleftshooter(double speed) {
  m_leftshooter.set(speed);
  }

  public void ShooterTest() {
       setrightshooter(-Constants.kShooterSpeed);
       setleftshooter(Constants.kShooterSpeed);
    }
  

  public void Arkhipov() {
    setrightshooter(Constants.kShooterSpeed);
    setleftshooter(-Constants.kShooterSpeed);
  }
  public void stop() {
    m_rightshooter.set(0);
   m_leftshooter.set(0);
  }

  public void ShooterStart() {
    long initTime = (long) Timer.getFPGATimestamp();
      int millisecondsToRun = 1000; // Replace 1000 with the desired value
      while (Timer.getFPGATimestamp() - initTime <= millisecondsToRun){
        setrightshooter(-Constants.kShooterSpeed);
        setleftshooter(Constants.kShooterSpeed);
     }
    } 
  public Command getShootCommand() {
      System.out.println("Shoot Command");
     return new InstantCommand(() -> {
      System.out.println("Shoot Command");
      isShooterOn = !isShooterOn;
      if (isShooterOn) {
      System.out.println("woosh");
     ShooterTest();
      } else {
     System.out.println("brrsht");
     m_rightshooter.set(0);
     m_leftshooter.set(0);
     }
  }, this);
 }
  public Command getArkhipovCommand() {
    return new InstantCommand(() -> {
      System.out.println("Arkhipov Command");
      isArkhipovOn = !isArkhipovOn;
      if (isArkhipovOn) {
        System.out.println("not woosh");
        Arkhipov();
      } else {
        System.out.println("not brrsht");
        m_rightshooter.set(0);
        m_leftshooter.set(0);
      }
    }, this);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
} 
