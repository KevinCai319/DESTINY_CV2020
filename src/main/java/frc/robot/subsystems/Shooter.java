/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */
  private WPI_VictorSPX shooterMotor;
  public Shooter() {
    shooterMotor = new WPI_VictorSPX(RobotMap.Shooter.SHOOTER_MOTOR);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
