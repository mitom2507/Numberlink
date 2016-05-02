import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SatEncoding {
	private  int val[][];
	private  int WIDTH;
	private  int HEIGHT;
	private int clause;
	private int var;
	private int number_var;
	public SatEncoding(int[][] val, int wIDTH, int hEIGHT, int var1) {
		super();
		this.val = val;
		this.var=var1;
		WIDTH = wIDTH;
		HEIGHT = hEIGHT;
	}
	public void x1(){
		number_var=WIDTH*HEIGHT*4*var;
	}
	public void law1(BufferedWriter bw){
		for(int i=0 ; i< WIDTH; i++){
			for(int j=0 ; j< HEIGHT-1; j++){
				try{
					
					for(int k=1;k<=var;k++){
						bw.write( (-((i*5+j)*(4*var)+(k-1)*4+2)) + " "+ ( (i*5+j)*(4*var)+(k-1)*4+4 +4*var) );
						bw.write("\n");
					}
					
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
			
		}
		for(int i=0 ; i< HEIGHT-1; i++){
			for(int j=0 ; j< WIDTH; j++){
				try{
					
					for(int k=1;k<=var;k++){
						bw.write( (-((i*5+j)*(4*var)+(k-1)*4+3 )) + " "+ ( (i*5+j)*(4*var)+(k-1)*4+5 )  );
						bw.write("\n");
					}
					
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
			
		}
	}
	public void endcode(){
		
		try{
			File file = new File("input/cnf/input.cnf");
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(fw);
			law1(bw);
			bw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

}
