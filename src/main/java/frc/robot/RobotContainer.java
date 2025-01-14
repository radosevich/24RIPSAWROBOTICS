// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.Commands.AutoDoNothing;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Subsystems.Climb;
import frc.robot.Subsystems.Drivetrain;
import frc.robot.Subsystems.Intake;
import frc.robot.Subsystems.Shooter;


public class RobotContainer {
  // The robot's subsystems
  public final Drivetrain m_driveSubsystem = new Drivetrain();
  private final Intake m_intake = new Intake();
  private final Shooter m_shooter = new Shooter();
  private final Climb m_climb = new Climb();

  // The robot's controllers
  private final CommandXboxController m_driverController = new CommandXboxController(Constants.kDriverControllerPort);
  private final Joystick m_operatorstick = new Joystick(OperatorConstants.kOperatorStickPort);

  /*
  private final Joystick m_operatorController = 
    new Joystick(Constants.kOperatorControllerPort);
  /* */
  // The robot's autonomous commands
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser;

  // Representation of game field
  public final Field2d m_field = new Field2d();

  public RobotContainer() {
    configureBindings();

    // Teleop default command
    // Control the drive with split-stick arcade controls
    m_driveSubsystem.setDefaultCommand(
      new RunCommand(() -> m_driveSubsystem.manualDrive(-m_driverController.getLeftY(), -m_driverController.getRightX()), m_driveSubsystem));
    // Setup autonomous select commands
    m_chooser = new SendableChooser<>();
    m_chooser.setDefaultOption("Do nothing", new AutoDoNothing());
    //m_chooser.addOption("Autonomous Distance", new AutonomousDistance(m_drivetrain, m_Tebo));
    SmartDashboard.putData(m_chooser);

    if (RobotBase.isReal()) {
      System.out.println("Running in a real environment");
    } else {
      System.out.println("Running in a simulated environment");
      SmartDashboard.putData("Field", m_field);
    }
  }

  private void configureBindings() {
    // Declare and initialize the m_operatorController variable
    Joystick m_operatorController = new Joystick(Constants.kOperatorControllerPort);

    // Configure the button bindings
    // Move the arm to 2 radians above horizontal when the 'A' button is pressed.
    m_driverController.rightBumper()
    .whileTrue(new RunCommand(() -> m_intake.IntakeStart()))
    .onFalse(new RunCommand(() -> m_intake.stop()));

    m_driverController.leftBumper()
    .whileTrue(new RunCommand(() -> m_intake.sethighintake(-Constants.kHighIntakeSpeed)))
    .whileTrue(new RunCommand(() -> m_intake.setlowintake(-Constants.kLowIntakeSpeed)))
    .onFalse(new RunCommand(() -> m_intake.stop()));

    m_driverController.a()
    .whileTrue(new RunCommand(() -> m_shooter.ShooterStart()))
    .onFalse(new RunCommand(() -> m_shooter.stop()));

    m_driverController.b()
    .whileTrue(new RunCommand(() -> m_shooter.Arkhipov()))
    .onFalse(new RunCommand(() -> m_shooter.stop()));
  }

  public Command getAutonomousCommand() {
    // The selected chooser command will run in autonomous
    m_autonomousCommand = m_chooser.getSelected();
    return m_autonomousCommand;
  }
}
