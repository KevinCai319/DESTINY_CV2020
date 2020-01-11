/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public interface RobotMap {
    /*
        DRIVETRAIN PORTS
    */
    interface Drivetrain{
        int LEFT_FRONT_MOTOR = 1;
        int RIGHT_FRONT_MOTOR = 3;
        int LEFT_REAR_MOTOR = 4;
        int RIGHT_REAR_MOTOR = 2;
    }
    interface Shooter{
        int SHOOTER_MOTOR = 13;
    }
    interface CV{
        //TODO: Tune these constants
        double DRIFT_P = 0.0;
        double DRIFT_I = 0.0;
        double DRIFT_D = 0.0;
    }
    
}
