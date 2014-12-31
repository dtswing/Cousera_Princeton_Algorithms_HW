public class PercolationStats {
	private double[] p;
	private int size;
	private int rep;

   public PercolationStats(int N, int T)  {
   		if(N<=0){
   			throw new IllegalArgumentException("invalid input N");
   		}
   		if(T<=0){
   			throw new IllegalArgumentException("invalid input T");
   		}
   		p = new double[T];
   		size = N;
   		rep = T;

   		for(int i = 0; i < rep; i++){
   		Percolation perc = new Percolation(size);
   		int count = 0;
   		while(!perc.percolates()){
   			int row = StdRandom.uniform(1,size+1);
   			int col = StdRandom.uniform(1,size+1);
   			if(!perc.isOpen(row,col)){
   				perc.open(row,col);
   				count++;
   			}
   		}
   		p[i] = count*1.0/(size*size*1.0);
   		
   	}

   }   // perform T independent experiments on an N-by-N grid
   public double mean()  {
   	return StdStats.mean(p);
   }                    // sample mean of percolation threshold
   public double stddev()  {
   	return StdStats.stddev(p);
   }                  // sample standard deviation of percolation threshold
   public double confidenceLo()  {
   	return mean() - 1.96*stddev()/Math.sqrt(rep);
   }           // low  endpoint of 95% confidence interval
   public double confidenceHi()   {
   	return mean() + 1.96*stddev()/Math.sqrt(rep);
   }          // high endpoint of 95% confidence interval

   public static void main(String[] args) {
   	int N = StdIn.readInt();
   	int T = StdIn.readInt();
   	PercolationStats experiment = new PercolationStats(N,T);
   	StdOut.printf("mean = %f%n",experiment.mean());
   	StdOut.printf("standard error = %f%n",experiment.stddev());
   	StdOut.printf("confidence interval = %f , %f%n",experiment.confidenceLo(),experiment.confidenceHi());
   }   // test client (described below)
}
