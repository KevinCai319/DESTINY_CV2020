/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.RampUp;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import frc.robot.utl.Limelight;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final Drivetrain m_drivetrain;
  public final Shooter shooter;
  public final Joystick controller;
  public final Joystick Operator; 


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_drivetrain = new Drivetrain();
    shooter = new Shooter();
    controller = new Joystick(0);
    Operator = new Joystick(1);
    configureButtonBindings();
  }
  
  public void setupShuffleboard(){
    SmartDashboard.putNumber("Angle_P", 0.2);
    SmartDashboard.putNumber("Angle_I", 0);
    SmartDashboard.putNumber("Angle_D", 0.1);
  }
  public double getForward(){
    double value = controller.getRawAxis(1);
    return -Math.signum(value)*Math.pow(value,2);
  }

  public double getTurn(){
    double value = controller.getRawAxis(4);
    return Math.signum(value)*Math.pow(value,2);
  }

  public double getCVTurn(){
    return Math.signum(Limelight.getTargetXAngle())*Math.sqrt(Math.abs(Limelight.getTargetXAngle()));
  }

  public Command getAutonomousCommand() {
    return null;
  }
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  public void configureButtonBindings() {
    new JoystickButton(Operator, 2).whileHeld(new RampUp(shooter));
  }

}
