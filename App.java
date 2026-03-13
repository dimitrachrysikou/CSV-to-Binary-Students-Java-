import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int lineNumber = 0;
        

        try (RandomAccessFile raf = new RandomAccessFile("data.obj", "rw");
             Scanner scanner = new Scanner(new File("data.csv"))) {

            
            if (scanner.hasNextLine()) {
                scanner.nextLine();
                lineNumber++;
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNumber++;

                try {
                    
                    Student student = parseStudent(line);
                    if (student != null) {
                        System.out.println(student);
                        writeStudent(student, raf);
                    }
                } catch (Exception e) {
                    System.out.println("Error parsing line " + lineNumber + ": " + e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("To arxeio data.csv den brethhke: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }




    /*************************METHODOS*********************************************/
    public static Student parseStudent(String line) {
        try {
            
            String[] fields = line.split(";");
            if (fields.length != 3) { 
                throw new IllegalArgumentException("H grammh den eriexei 3 pedia " + line);
            }

            String am = fields[0]; 
            String name = fields[1]; 
            double grade = Double.parseDouble(fields[2]); 

            return new Student(am, name, grade);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error " + line, e);
        }
    }

    
    public static void writeStudent(Student student, RandomAccessFile raf) throws IOException {
        
        String am = String.format("%-13s", student.getAm());
        raf.writeChars(am);

        
        String name = String.format("%-50s", student.getOnoma());
        raf.writeChars(name);

        raf.writeDouble(student.getBathmos());
    }
}
