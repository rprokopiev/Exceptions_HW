import java.io.FileWriter;

public class WriteToFile {

    public static void addToFile(String[] data) {
        String fileName = data[0] + ".txt";
        try (FileWriter newWriter = new FileWriter(fileName, true);){
            for (int i = 0; i < data.length; i++) {
                newWriter.write("<");
                newWriter.write(data[i]);
                newWriter.write(">");
            }
            newWriter.append("\n");
        } catch (Exception e) {
            System.out.println("Ошибка");
            e.printStackTrace();
        }
    }

}