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
	public static Mat[] estimatePose() {
        System.loadLibrary("opencv_java347");
		List<Point3> objectPointsList = new ArrayList<Point3>();
		objectPointsList.add(new Point3(-19.625, 0, 0));
		objectPointsList.add(new Point3(19.625, 0, 0));
		objectPointsList.add(new Point3(9.82, 17, 0));
		objectPointsList.add(new Point3(-9.82, 17, 0));
		
		MatOfPoint3f objectPointsMat = new MatOfPoint3f();
        objectPointsMat.fromList(objectPointsList);
        		
        List<Point> imagePointsList = new ArrayList<Point>();
        double[][] data = Limelight.getVertices();
        if(data[0][0] == 0){    
            return null;
        }
        for(int i = 0; i < 4; i++){
          imagePointsList.add(new Point(data[0][i], data[1][i]));
        }
		
		MatOfPoint2f imagePointsMat = new MatOfPoint2f();
		imagePointsMat.fromList(imagePointsList);
			
        MatOfDouble cameraMatrix = new MatOfDouble(2.5751292067328632e+02, 0., 1.5971077914723165e+02, 0.,2.5635071715912881e+02, 1.1971433393615548e+02, 0., 0., 1.);
		MatOfDouble distCoeffs = new MatOfDouble(2.9684613693070039e-01, -1.4380252254747885e+00, -2.2098421479494509e-03, -3.3894563533907176e-03, 2.5344430354806740e+00);
		Mat rvec = new Mat();
		Mat tvec = new Mat();
		
		if(Calib3d.solvePnP(objectPointsMat, imagePointsMat, cameraMatrix, distCoeffs, rvec, tvec)){
            return new Mat[] {rvec, tvec};
        }
        return null;
    }
	
    public static double[] getXYZ(){
        Mat[] stuff = estimatePose();
        double[] xyz = new double[3];
        if(stuff != null){
            xyz[0] = stuff[1].get(0, 0)[0];
            xyz[1] = stuff[1].get(0, 0)[1];
            xyz[2] = stuff[1].get(0, 0)[2];
            System.out.println(xyz[0]+","+xyz[1]+","+xyz[2]);
        }
        return xyz;
    }
    
//    public MatOfPoint2f data(){
//        Calib3d.solvePnP(objPointsMat, this, camMatrix, distCoeffs, Rvec, Tvec);
//    }
    
    public static void main(String[] args) { // Test client
        // System.setProperty("java.library.path", "C:\\Users\\Eric Wang\\Documents\\GitHub\\DESTINY_CV2020\\libs");
        // System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary("opencv_java347");  
        getXYZ();
    }
}
