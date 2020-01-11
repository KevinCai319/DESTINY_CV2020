/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  private WPI_TalonSRX leftFrontMotor;
  private WPI_TalonSRX rightFrontMotor;
  private WPI_TalonSRX leftRearMotor;
  private WPI_TalonSRX rightRearMotor;
  private DifferentialDrive differentialDrive;
  private SpeedControllerGroup leftSpeedController;
  private SpeedControllerGroup rightSpeedController;
  public Drivetrain() {
    leftFrontMotor = new WPI_TalonSRX(RobotMap.Drivetrain.LEFT_FRONT_MOTOR);
    rightFrontMotor = new WPI_TalonSRX(RobotMap.Drivetrain.RIGHT_FRONT_MOTOR);
    leftRearMotor = new WPI_TalonSRX(RobotMap.Drivetrain.LEFT_REAR_MOTOR);
    rightRearMotor = new WPI_TalonSRX(RobotMap.Drivetrain.RIGHT_REAR_MOTOR);
    leftFrontMotor.setInverted(true);
    rightFrontMotor.setInverted(true);
    leftRearMotor.setInverted(true);
    rightRearMotor.setInverted(true);
    leftSpeedController = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
    rightSpeedController = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);
    differentialDrive = new DifferentialDrive(leftSpeedController, rightSpeedController);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
