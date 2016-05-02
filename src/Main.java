import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
	public static int WIDTH;
	public static int HEIGHT;
	public static int var;
	static  int [][]val;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path filePath = Paths.get("input/problem/5x5.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(filePath);
			int i = 0, j = 0;
			HEIGHT = scanner.nextInt();
			WIDTH = scanner.nextInt();
			var=scanner.nextInt();
			val = new int[HEIGHT][WIDTH];
			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					int q = scanner.nextInt();
					if (j >= WIDTH) {
						i++;
						j = 0;
					}
					val[i][j] = q;
					j++;
				} else {
					scanner.next();
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
        }
		
		SatEncoding sat= new SatEncoding(val,WIDTH,HEIGHT,var);
		sat.endcode();
	}

}
