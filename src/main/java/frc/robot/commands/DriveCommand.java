package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;
import frc.robot.utl.CVFuncs;
import frc.robot.utl.Limelight;
import frc.robot.utl.Limelight.LEDMode;

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
  PIDController turnController;
  PIDController moveController;
  public DriveCommand() {
    addRequirements(Robot.m_robotContainer.m_drivetrain);
  }
  @Override
  public void initialize() {
    super.initialize();
    turnController = new PIDController(SmartDashboard.getNumber("Angle_P", 0.022),
                                      SmartDashboard.getNumber("Angle_I", 0.00000),
                                      SmartDashboard.getNumber("Angle_D", 0.002));
    moveController = new PIDController(SmartDashboard.getNumber("Move_P", 0.1),
                                       SmartDashboard.getNumber("Move_I", 0),
                                       SmartDashboard.getNumber("Move_D", -0.02));
    moveController.setSetpoint(0);
    turnController.setTolerance(0.5);
    moveController.setTolerance(1);
    turnController.setSetpoint(0);
  }


  @Override
  public void execute() {
    Limelight.setLEDMode(LEDMode.FORCE_ON);
    if(Robot.m_robotContainer.controller.getRawButton(1)){
      // Limelight.setLEDMode(LEDMode.FORCE_OFF);
      Robot.m_robotContainer.m_drivetrain.arcadeDrive(
        Robot.m_robotContainer.getForward(),
        Robot.m_robotContainer.getTurn()
      );
    }else{
      double turn = -turnController.calculate(Limelight.getTargetXAngle());
      double move = moveController.calculate(CVFuncs.getDistanceToTarget());
    System.out.println(turn);
    System.out.println(turnController.getVelocityError());
    //System.out.println(move);
    if(Math.abs(turn) < 1 && Math.abs(turn) > 0.001 && !turnController.atSetpoint()){
      turn = Math.signum(turn) * Math.sqrt(Math.sqrt(Math.abs(turn)));
    }
      Robot.m_robotContainer.m_drivetrain.arcadeDrive(Robot.m_robotContainer.getForward(),turn);
    }
    Robot.m_robotContainer.m_drivetrain.cvtLimelightToCV();
  }
}