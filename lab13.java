import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class lab13 {
	private ArrayList<Integer> streamList;
	
	public void readData(String filename) {
	 try
        {
            streamList = Files.lines(Paths.get(filename))
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(ArrayList::new));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            streamList = new ArrayList<>();
        }
	}
	
	public long getTotalCount() {
		return streamList.stream().count();
	}
	
	public long getOddCount() {
		return streamList.stream().filter(n -> n % 2 != 0).count();
	}
	
	public long getEvenCount() {
		return streamList.stream().filter(n -> n % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount() {
		return streamList.stream().filter(n -> n > 5).distinct().count();
	}
	
	public Integer[] getResult1() {
		return streamList.stream().filter(n -> n % 2 == 0 && n > 5 && n < 50)
                .sorted()
                .toArray(Integer[]::new);
	}
	
	public Integer[] getResult2() {
		return streamList.stream()
                .map(n -> n * n * 3)
                .limit(50)
                .toArray(Integer[]::new);
	}
	
	public Integer[] getResult3() {
		return streamList.stream().filter(n -> n % 2 != 0)
                .map(n -> n * 2)
                .sorted()
                .skip(20)
                .distinct()
                .toArray(Integer[]::new);
	}
}
