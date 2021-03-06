import java.io.FileNotFoundException;
import java.io.IOException;

import org.sat4j.minisat.SolverFactory;
import org.sat4j.reader.DimacsReader;
import org.sat4j.reader.ParseFormatException;
import org.sat4j.reader.Reader;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IProblem;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;

public class Test {
	public static void main ( String [] args ) {
		ISolver solver = SolverFactory . newDefault ();
		solver . setTimeout (3600); // 1 hour timeout
		Reader reader = new DimacsReader ( solver );
		// CNF filename is given on the command line
		try {
			System .out . println (args[0]);
			IProblem problem = reader . parseInstance ( args [0]);
			
			if ( problem . isSatisfiable ()) {
				System . out . println (" Satisfiable !");
				//System . out . println ( reader . decode ( problem . model ()));
			} else {
				System . out . println (" Unsatisfiable !");
			}
		} catch ( FileNotFoundException e) {
		// TODO Auto - generated catch block
			System .out . println (" 1");
		} catch ( ParseFormatException e) {
		// TODO Auto - generated catch block
			System .out . println (" 2");
		} catch ( IOException e) {
		// TODO Auto - generated catch block
			System .out . println (" 3");
		} catch ( ContradictionException e) {
		System .out . println (" Unsatisfiable ( trivial )!");
		} catch ( TimeoutException e) {
		System .out . println (" Timeout , sorry !");
		}
	}
}
