import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class OutputToFile {
    private static final String FILENAME_STRING = "student.txt";
    public OutputToFile(){

    }

    public void WriteToFile(){
        try {
            File file = new File(FILENAME_STRING);
            FileWriter fileWriter = new FileWriter(file);
            for(Student student : StudentService.StudentList){
                String data = "ID : "+student.getId() +"\n"
                        +"Name: " + student.getName() +"\n"
                        +"Date of Birth : " + student.getDoB() + "\n"
                        +"Address : " + student.getAddress() +"\n"
                        +"Height : " + student.getHeight() +"\n"
                        +"Weight : " + student.getWeight() +"\n"
                        +"Student Code : " + student.getStudentCode() +"\n"
                        +"School Name : " + student.getSchoolName() +"\n"
                        +"Year of Admission : " + student.getYearOfAdmission()+"\n"
                        +"GPA : " + student.getGPA() +"\n"
                        +"Student Capacity :" +student.getStudentCapacity();
                fileWriter.write(data+ System.lineSeparator());
            }
            fileWriter.close();

        }catch (FileNotFoundException e){
            System.err.println("File not found !");
        }catch (IOException e1){
            System.err.println("File Output Error!");
        }catch (NullPointerException e2){
            System.err.println("Null Pointer!");
        }
    }
}
