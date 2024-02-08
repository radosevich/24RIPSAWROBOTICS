package frc.robot.Subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
   
  private boolean isIntakeOn = false; // Move this line to the top of the class
  private boolean isSpitOn = false;

  CANSparkMax m_highintake;
  CANSparkMax m_lowintake;

  /** Creates a new Drivetrain. */
  public Intake() {
    m_highintake = new CANSparkMax(Constants.kHighIntakeID, MotorType.kBrushless);
    m_lowintake = new CANSparkMax(Constants.kLowIntakeID, MotorType.kBrushless);
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
      m_highintake.set(0);
      m_lowintake.set(0);
    }
   
            public Command getIntakeCommand() {
              return new InstantCommand(() -> {
                System.out.println("Intake command");
                isIntakeOn = !isIntakeOn;
                if (isIntakeOn) {
                  System.out.println("Intake on");
                    sethighintake(Constants.kHighIntakeSpeed);
                    setlowintake(Constants.kLowIntakeSpeed);
                } else {
                    System.out.println("Intake off");
                }
              }, this);
           } // hi guys whats up
           public Command getSpitCommand() {
          return new InstantCommand(() -> {
            System.out.println("Intake command");
            isSpitOn = !isSpitOn;
            if (isSpitOn) {
              System.out.println("Intake on");
                sethighintake(Constants.kHighIntakeSpeed);
                setlowintake(Constants.kLowIntakeSpeed);
            } else {
                System.out.println("Intake off");
            }
          }, this);
        }
       } // Add this closing curly brace to complete the class body
   
