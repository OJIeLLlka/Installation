package netology.installation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void makeDirectory(String pathName) {

        if (new File(pathName).mkdir()) {
            sb.append("Каталог ").append(pathName).append(" создан.\n");
        }
    }

    static void makeFile(String pathFile, String fileName) {
        try {
            new File(pathFile, fileName).createNewFile();
            sb.append("Файл ").append(fileName).append(" добавлен в каталог ").append(pathFile).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        // write your code here
        makeDirectory("E://Games/src");
        makeDirectory("E://Games/res");
        makeDirectory("E://Games/savegames");
        makeDirectory("E://Games/temp");

        makeDirectory("E://Games/src/main");
        makeDirectory("E://Games/src/test");

        makeFile("E://Games/src/main", "Main.java");
        makeFile("E://Games/src/main", "Utils.java");

        makeDirectory("E://Games/res/drawables");
        makeDirectory("E://Games/res/vectors");
        makeDirectory("E://Games/res/icons");

        makeFile("E://Games/temp", "temp.txt");

        try (FileWriter writer = new FileWriter("E://Games/temp/temp.txt", true)) {
            writer.write(String.valueOf(sb));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
