package geo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GrdReader {
	
	public static Grd readGrdFile(String filename) throws FileNotFoundException, IOException{
		Grd grd = null;
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        StringBuilder buildCordinates = new StringBuilder();
	        int i = 0;
	        int n = 0,m = 0;
	        double [] cordinates;
	        String name = null;
	        double[][] data;
	        while (line != null) {
	        	if(i == 0){
	        		name = line;
	        	}
	        	else if(i == 1){
	        		String[] split = line.split(" ");
	        		n = Integer.valueOf(split[0]);
	        		m = Integer.valueOf(split[1]);
	        	}
	        	else if(i > 1 && i < 5){
	        		buildCordinates.append(line).append(" ");
	        	}
	        	else{
	        		if(line != ""){
	        			sb.append(line).append(" ");
	        		}
	        	}
	            line = br.readLine();
	            i++;
	        }
	        cordinates = new double[6];
	        data = new double[n][m];
	        String[] cordinatesSplit = buildCordinates.toString().split(" ");
	        for(int k = 0;k<cordinatesSplit.length;k++){
	        	cordinates[k] = Double.valueOf(cordinatesSplit[k]);
	        }
	        String[] dataSplit = sb.toString().split(" ");
	        i = 0;
	        for(int j = 0;j<n;j++){
	        	for(int k = 0;k<m;k++){
	        		while ( data[j][k] == 0){
	        			if( !dataSplit[i].isEmpty() ){
	        				data[j][k] = Double.valueOf(dataSplit[i]);
	        			}
	        			i++;
	        		}
	        	}
	        }
	        grd = new Grd(n,m,data,name,cordinates);
	    }
		return grd;
	}
}
