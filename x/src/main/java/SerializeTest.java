import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeTest {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("temp.out");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    }
}
