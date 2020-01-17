package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;

/**
 * A command to drive the robot with joystick input (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes - actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.RunCommand}.
 */
public class DriveCommand extends CommandBase {

  /**
   * Creates a new DefaultDrive.
   *
   * @param subsystem The drive subsystem this command wil run on.
   * @param forward The control input for driving forwards/backwards
   * @param rotation The control input for turning
   */
  public DriveCommand() {
    addRequirements(Robot.m_robotContainer.m_drivetrain);
  }

  @Override
  public void execute() {
    Robot.m_robotContainer.m_drivetrain.arcadeDrive(
      Robot.m_robotContainer.getForward(),
      Robot.m_robotContainer.getCVTurn()
    );
  }
}