// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

 package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants; // Import the Constants class

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Timer; // Import the Timer class

public class Shooter extends SubsystemBase {

  private boolean isShooterOn = false;
  private boolean isArkhipovOn = false;

  TalonSRX m_rightshooter = new TalonSRX(7);
  TalonSRX m_leftshooter = new TalonSRX(8);
  CANSparkMax m_highintake;
  CANSparkMax m_lowintake;
  public Shooter() {
    // m_highintake = new CANSparkMax(Constants.kHighIntakeID, MotorType.kBrushless);
    // m_lowintake = new CANSparkMax(Constants.kLowIntakeID, MotorType.kBrushless);
  }
  /** Creates a new Shooter. */

  public void setrightshooter(double speed) {
  m_rightshooter.set(ControlMode.PercentOutput, -.6);
  }

  public void setleftshooter(double speed) {
  m_leftshooter.set(ControlMode.PercentOutput, .6);
  }
  public void sethighintake(double speed) {
    System.out.println("setHighintake");
  m_highintake.set(speed);
  }

  public void setlowintake(double speed) {
  System.out.println("setLowintake");
  m_lowintake.set(speed);
  }
 public void stop() {
  m_rightshooter.set(ControlMode.PercentOutput, 0);
  m_leftshooter.set(ControlMode.PercentOutput, 0);
 }
  public void ShooterTest() {
       setrightshooter(-Constants.kShooterSpeed);
       setleftshooter(Constants.kShooterSpeed);
    }
  public void Arkhipov() {
    setrightshooter(Constants.kShooterSpeed);
    setleftshooter(-Constants.kShooterSpeed);
  }
  public void ShooterStart() {
    long initTime = (long) Timer.getFPGATimestamp();
    int millisecondsToRun = 100;
    while (Timer.getFPGATimestamp() - initTime <= millisecondsToRun) {
      setrightshooter(-Constants.kShooterSpeed);
      setleftshooter(Constants.kShooterSpeed);
    }
    Timer.delay(0.6); // Delay for 600 milliseconds

    initTime = (long) Timer.getFPGATimestamp();
    millisecondsToRun = 1000;
    while (Timer.getFPGATimestamp() - initTime <= millisecondsToRun) {
      sethighintake(Constants.kHighIntakeSpeed);
      setlowintake(Constants.kLowIntakeSpeed);
    

    stop();
    } // Stop the shooter motors
  }
    
  public Command getShootCommand() {
     return new InstantCommand(() -> {
      System.out.println("Shoot Command");
      isShooterOn = !isShooterOn;
      if (isShooterOn) {
      System.out.println("woosh");
      ShooterStart();
      } else {
     System.out.println("brrsht");
     m_rightshooter.set(ControlMode.PercentOutput, 0);
     m_leftshooter.set(ControlMode.PercentOutput, 0);
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
        m_rightshooter.set(ControlMode.PercentOutput, 0);
        m_leftshooter.set(ControlMode.PercentOutput, 0);
      }
    }, this);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
} 
