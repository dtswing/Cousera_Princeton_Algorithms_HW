public class Percolation {
	private int size;
	private int[][] grid;
	private WeightedQuickUnionUF grid_connectivity;

	// create N-by-N grid, with all sites blocked
   public Percolation(int N){

   	size = N;

   	if(size<=0){
   		throw new IllegalArgumentException("Invalid grid size"); 
   	}

   	grid = new int[N][N];
   	for (int i = 0; i < N ; i++){
   		for(int j = 0; j < N; j++){
   			grid[i][j] = 0;
   		}

   	}

	grid_connectivity = new WeightedQuickUnionUF(N*N+2);
   	}

   	private void checkIndex(int i, int j){
   		if (i < 1 || i > size){
   			throw new IndexOutOfBoundsException("row index i out of bounds");
   		}
   		if (j < 1 || j > size){
   			throw new IndexOutOfBoundsException("column index j out of bounds");
   		}
   	}


   // open site (row i, column j) if it is not open already           
   public void open(int i, int j) {
   	checkIndex(i,j);
   	grid[i-1][j-1] = 1;
   	if(i==1){
   		grid_connectivity.union(0,j);
   	}
   	if(i==size){
   		grid_connectivity.union((i-1)*i+j,i*i+1);
   	}
   	if(i >= 2){
   		if(grid[i-2][j-1] == 1)
   		grid_connectivity.union((i-1)*size+j, (i-2)*size+j);
   	}
   	if(i <= (size-1)){
   		if(grid[i][j-1] == 1)
   		grid_connectivity.union((i-1)*size+j,i*size+j);
   	}
   	if(j >= 2 ){
   		if(grid[i-1][j-2] == 1)
   		grid_connectivity.union((i-1)*size+j, (i-1)*size+j-1);
   	}
   	if(j <= (size-1)){
   		if(grid[i-1][j] == 1)
   		grid_connectivity.union((i-1)*size+j,(i-1)*size+j+1);
   	}
   }         
   // is site (row i, column j) open?
   public boolean isOpen(int i, int j) {
   	checkIndex(i,j);
   	if(grid[i-1][j-1] == 1){
   		return true;
   	}
   	return false;
   }    
   // is site (row i, column j) full?
   public boolean isFull(int i, int j) {
   	checkIndex(i,j);
   	if(grid_connectivity.connected(0,(i-1)*size+j)){
   		return true;
   	}
   	return false;
   }
   // does the system percolate?    
   public boolean percolates() {
   	if(grid_connectivity.connected(0,size*size+1)){
   		return true;
   	}
   	return false;
   }            

   public static void main(String[] args){
   int N = StdIn.readInt();
   Percolation test = new Percolation(N);
   test.open(1,1);
   test.open(1,2);
   test.open(2,2);
   test.open(2,3);
   test.open(2,4);
   test.open(3,4);
   test.open(4,4);
   test.open(4,5);
   test.open(5,3);
   StdOut.println(test.percolates());
   } 
}
