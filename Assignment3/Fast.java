/*******************Sorting Method************************/
import java.util.Arrays;
import java.util.Comparator;

public class Fast {
   public static void main(String[] args){

   String filename = args[0];
   In in = new In(filename);

   int numPoints = in.readInt();

   Point[] PointsArray = new Point[numPoints];

   // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01);  // make the points a bit larger


   for (int i = 0; i < numPoints; i++){

   	int x = in.readInt();
   	int y = in.readInt();
   	PointsArray[i] = new Point(x,y);
   	PointsArray[i].draw();

   StdDraw.show(0);  
   }


   StdDraw.setPenRadius(0.005);


   for(int i = 0; i < numPoints; i++){
   	Arrays.sort(PointsArray,PointsArray[i].SLOPE_ORDER);

   	for(int j = 0; j < numPoints - 3; j++){
   		if (PointsArray[j].slopeTo(PointsArray[j+1]) == PointsArray[j].slopeTo(PointsArray[j+2]) &&
   			PointsArray[j].slopeTo(PointsArray[j+1]) == PointsArray[j].slopeTo(PointsArray[j+3]))

   		{
   				
   				Point[] result = new Point[4];
   				for (int k = 0; k < 4; k++){
   					result[k] = PointsArray[j+k];
   				}
   				Arrays.sort(result);
   				result[0].drawTo(result[3]);
   				StdDraw.show(0);  
   				
   				StdOut.println(PointsArray[j].toString()+"->"+PointsArray[j+1].toString()+"->"+PointsArray[j+2].toString()+"->"+PointsArray[j+3].toString());
        }
   	}

   }

	   	      
	}    
}