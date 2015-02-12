import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		SortName sn = new SortName();
		sn.sort("names.txt", "Output.txt");
	}

}
