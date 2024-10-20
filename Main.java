import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Ошибка");
            System.exit(1);
        }

        String textFile = args[0];
        String directory = args[1];
        int digitCount;

        File file = new File(textFile);
        if (!file.exists() || !file.isFile()) {
            System.out.println("Ошибка. Текстовый файл " + textFile + " не найден");
            System.exit(1);
        }
        try {
            String content = new String(Files.readAllBytes(Paths.get(textFile)));
            digitCount = (int) content.chars().filter(Character::isDigit).count();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            System.exit(1);
            return;
        }

        File dir = new File(directory);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Ошибка. Каталог " + directory + " не существует.");
            System.exit(1);
        }
        File logFile = new File(dir, "info.log");
        try (FileWriter writer = new FileWriter(logFile)) {
            writer.write("В файле всего " + digitCount + " чисел");
            System.out.println("Лог записан в файл: " + logFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
            System.exit(1);
        }

        System.out.println("Код программы завершен успешно");
        System.exit(0);
    }
}