/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.utl;
import java.util.ArrayList;
import java.util.List;

import org.opencv.calib3d.Calib3d;
import org.opencv.core.*;
/**
 * Add your docs here.
 */
public class CVFuncs {
	private static double[][] data;
	
	public void cvtLimelightToCV(){
		data = Limelight.getVertices();
	}
	
	public static boolean estimatePose() {
		data[0][0] = 6;
		List<Point3> objectPointsList = new ArrayList<Point3>();
		objectPointsList.add(new Point3(-19.625, 0, 0));
		objectPointsList.add(new Point3(19.625, 0, 0));
		objectPointsList.add(new Point3(9.82, 17, 0));
		objectPointsList.add(new Point3(-9.82, 17, 0));
		
		MatOfPoint3f objectPointsMat = new MatOfPoint3f();
		objectPointsMat.fromList(objectPointsList);		
		
		List<Point> imagePointsList = new ArrayList<Point>();
		imagePointsList.add(new Point(data[0][0], data[1][0]));
		imagePointsList.add(new Point(data[0][1], data[1][1]));
		imagePointsList.add(new Point(data[0][2], data[1][2]));
		imagePointsList.add(new Point(data[0][3], data[1][3]));
		
		MatOfPoint2f imagePointsMat = new MatOfPoint2f();
		imagePointsMat.fromList(imagePointsList);
			
		Mat cameraMatrix = new Mat();
		MatOfDouble distCoeffs = new MatOfDouble();
		Mat rvec = new Mat();
		Mat tvec = new Mat();
		
		return (Calib3d.solvePnP(objectPointsMat, imagePointsMat, cameraMatrix, distCoeffs, rvec, tvec));
	}
	
    public double[] getXYZ(Mat a){
        return new double[0];
    }
    
//    public MatOfPoint2f data(){
//        Calib3d.solvePnP(objPointsMat, this, camMatrix, distCoeffs, Rvec, Tvec);
//    }
    
    public static void main(String[] args) { // Test client
    	estimatePose();
    }
}
