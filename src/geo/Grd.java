package geo;

public class Grd {
	public String name;
	public double[][] data;
	public int n,m;
	public double [] cordinates;
	
	public Grd(int n,int m,double[][] data,String name,double[] cordinates){
		this.n = n;
		this.m = m;
		this.name = name;
		this.data = data;
		this.cordinates = cordinates;
	}
}
