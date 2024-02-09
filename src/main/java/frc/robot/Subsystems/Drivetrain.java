package frc.robot.Subsystems;

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Drivetrain extends SubsystemBase {
 

  private final CANSparkMax m_rightMotor = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax m_leftMotor = new CANSparkMax(3, MotorType.kBrushless);
  private final CANSparkMax m_rightMotorSlave = new CANSparkMax(2, MotorType.kBrushless);
  private final CANSparkMax m_leftMotorSlave = new CANSparkMax(4, MotorType.kBrushless);
  
  // Differential Drive
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_rightMotor, m_leftMotor);

  // Kinematics and odometry

  
  public Drivetrain() {
    m_leftMotorSlave.follow(m_leftMotor);
    m_rightMotorSlave.follow(m_rightMotor);
  }

  public void manualDrive(double move, double turn) {
    
    if (Math.abs(move) < 0.1) move = 0;
    if (Math.abs(turn) < 0.1) turn = 0;

    m_robotDrive.arcadeDrive(-move, -turn);
  } 
}