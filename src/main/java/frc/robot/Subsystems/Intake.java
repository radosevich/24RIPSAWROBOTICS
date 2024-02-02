// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

//import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
    // Declare the SparkMax controller and motor
    private final CANSparkMax m_intakeMotor;

    // Constructor
    public Intake() {
      // Initialize the SparkMax with the motor ID and motor type
      m_intakeMotor = new CANSparkMax(Constants.kIntakeMotorID, MotorType.kBrushless);

      // Optional: Configure motor settings here (e.g., inverted, current limits)
    }

    // Method to run the intake
    public void runIntake() {
      m_intakeMotor.set(Constants.kIntakeSpeed); // Set motor speed (between -1.0 and 1.0)
    }

    // Method to stop the intake
    public void stopIntake() {
        m_intakeMotor.set(0); // Set motor speed to 0 to stop
    }
}