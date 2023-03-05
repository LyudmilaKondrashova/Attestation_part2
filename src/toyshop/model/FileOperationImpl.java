package toyshop.model;

import java.io.*;
import java.util.ArrayList;
import static toyshop.model.Constants.FILETOYSNAME;
import static toyshop.model.Constants.FILEPRESENTTOYSNAME;

public class FileOperationImpl implements FileOperation {
    // Получение из файла списка всех игрушек
    @Override
    public ArrayList<String> readAllToys(String fileName) {
        ArrayList<String> toyLines = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            if (line != null) {
                toyLines.add(line);
            }
            while (line != null) {
                line = bufferedReader.readLine();
                if (line != null) {
                    toyLines.add(line);
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Файл с разыгрываемыми игрушками " + FILETOYSNAME + " отсутствует!");
            System.out.println("Создан новый файл!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toyLines;
    }

    // Запись в файл списка всех игрушек
    @Override
    public void saveAllToys(String fileName, ArrayList<String> toys) {
        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            for (String line : toys) {
                fileWriter.write(line);
                fileWriter.append('\n');
            }
            fileWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void savePresentToy(String fileName, String presentToy) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(presentToy);
            fileWriter.append('\n');
            fileWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
