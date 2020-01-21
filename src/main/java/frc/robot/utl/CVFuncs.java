/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.utl;
import org.opencv.core.*;
/**
 * Add your docs here.
 */
public class CVFuncs {
    public double[] getXYZ(Mat a){
        return new double[0];
    }
    public MatOfPoint2f data(){
        Calib3d.solvePnP(objPointsMat, this, camMatrix, distCoeffs, Rvec, Tvec);
    }
}
