/*******************Brute Force Method************************/
import java.util.Arrays;
import java.util.Comparator;

public class Brute {
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

   Arrays.sort(PointsArray);

   StdDraw.setPenRadius(0.005);

   for(int a = 0; a < numPoints; a++){
   	for(int b = a+1; b< numPoints; b++){
   		for(int c  = b+1; c < numPoints; c++){
   			for (int d = c+1; d < numPoints; d++){

   				if (PointsArray[a].slopeTo(PointsArray[b]) == PointsArray[a].slopeTo(PointsArray[c]) &&
   				PointsArray[a].slopeTo(PointsArray[b]) == PointsArray[a].slopeTo(PointsArray[d]))
   					
          {
   				PointsArray[a].drawTo(PointsArray[d]);
   				StdDraw.show(0);  
   				
   				StdOut.println(PointsArray[a].toString()+"->"+PointsArray[b].toString()+"->"+PointsArray[c].toString()+"->"+PointsArray[d].toString());
        }
   			}
   		}
   	}
   }

	   	      
	}    
}



