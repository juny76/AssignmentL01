import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        StudentService studentService = new StudentService();
        SortPercent sortPercent = new SortPercent();
        OutputToFile outputToFile = new OutputToFile();
        int key;
        boolean exit = false;
        try {
            Scanner scanner = new Scanner(System.in);
            while (!exit) {
                showMenu();
                key = scanner.nextInt();

                switch (key) {

                    case 1:
                        studentService.CreateStudent();
                        break;
                    case 2:
                        studentService.ReadStudent();
                        break;

                    case 3:
                        studentService.UpdateStudent();
                        break;

                    case 4:
                        studentService.DeleteStudent();
                        break;
                    case 5:
                        studentService.ShowStudentList();
                        break;

                    case 6:
                        sortPercent.Sort_StudentCapacity_Percent();
                        break;
                    case 7:
                        sortPercent.Sort_GPA_Percent();
                        break;

                    case 8:
                        studentService.SearchByStudentCapacity();
                        break;
                    case 9:
                        outputToFile.WriteToFile();
                        break;

                    case 0:
                        System.out.println("Exit");
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid value ! Choose the menu");
                        break;
                }
                if (exit) break;
            }
        }catch (InputMismatchException e){
            System.err.println("ERROR!");
        }
    }

    public static void showMenu(){
        System.out.println("Menu");
        System.out.println("1.Create student");
        System.out.println("2.Read student");
        System.out.println("3.Update student");
        System.out.println("4.Delete student");
        System.out.println("5.Show list of student");
        System.out.println("6.Show Student Capacity Percentage");
        System.out.println("7.Show GPA Percentage");
        System.out.println("8.Search By Student Capacity");
        System.out.println("9.Save to file");
        System.out.println("0.Exit");
    }

}
