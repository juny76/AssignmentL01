import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class StudentService {
    public static final int MAX_NAME_LENGTH = 100;
    public static final int MAX_ADDRESS_LENGTH = 300;
    public static final double MIN_HEIGHT = 50.0;
    public static final double MAX_HEIGHT = 300.0;
    public static final double MIN_WEIGHT = 5.0;
    public static final double MAX_WEIGHT = 1000.0;
    public static final int MAX_STUDENTCODE_LENGTH = 10;
    public static final String DEFAULT_SCHOOLNAME = "Unknown";
    public static final double MIN_GPA = 0.0;
    public static final double MAX_GPA = 10.0;

    Scanner scn=new Scanner(System.in);
    public static List<Student> StudentList= new ArrayList<>();
    public StudentService(){
    }
    public void CreateStudent(){

        String name = inputName();
        LocalDate DoB = inputDoB() ;
        String address = inputAddress();
        double height = inputHeight();
        double weight = inputWeight();
        String StudentCode = inputStudentCode();
        String SchoolName = inputSchoolName();
        int YearOfAdmission = inputYearofAdmission(DoB);
        double GPA= inputGPA();
        scn.nextLine();
        Student student = new Student(name,DoB,address,height,weight,StudentCode,SchoolName,YearOfAdmission,GPA);
        StudentList.add(student);
        System.out.println(student.toString());
    }

    public int SearchByID(int ID){
        int size=StudentList.size();
        for(int i=0;i<size;i++){
            if(StudentList.get(i).getId()==ID) return i;
        }
        return -1;
    }

    public void ReadStudent(){
        System.out.println("Enter ID for search student : ");
        int ID=scn.nextInt();
        scn.nextLine();
        int search=SearchByID(ID);
        Student student = StudentList.get(search);
        if(student == null) {
            System.out.println("ID not found!");
        }
        else{
            System.out.println("Information of Student");
            ShowStudent(student);
        }

    }
    public void UpdateStudent(){
        int exit=0;
        System.out.println("Enter ID number : ");
        int ID= scn.nextInt();
        scn.nextLine();
        int search =SearchByID(ID);
        Student student = StudentList.get(search);
        if(student==null){
            System.out.println("Not found!");
            UpdateStudent();
        }else {
            while (exit ==0) {
                MenuEditStudent();
                int choose = scn.nextInt();
                scn.nextLine();
                switch (choose) {
                    case 1:
                        student.setName(inputName());
                        break;
                    case 2:
                        student.setAddress(inputAddress());
                        break;
                    case 3:
                        student.setDoB(inputDoB());
                        break;
                    case 4:
                        student.setHeight(inputHeight());
                        break;
                    case 5:
                        student.setWeight(inputWeight());
                        break;
                    case 6:
                        student.setStudentCode(inputStudentCode());
                        break;
                    case 7:
                        student.setSchoolName(inputSchoolName());
                        break;
                    case 8:
                        student.setYearOfAdmission(inputYearofAdmission(student.getDoB()));
                        break;
                    case 9:
                        student.setGPA(inputGPA());
                        student.setStudentCapacity(student.getStudentCapacity());
                        break;
                    case 0:
                        System.out.println("exit!");
                        exit=1;
                        break;
                    default:
                        System.out.println("Please choose number in Menu!");
                        break;
                }

            }
        }
    }

    public void DeleteStudent(){
        System.out.println("Enter ID for delete student");
        int ID=scn.nextInt();
        scn.nextLine();
        int search = SearchByID(ID);
        if(search==-1){
            System.out.println("ID not found!");
        }else{
            StudentList.remove(search);
            System.out.println("Deleted!");
        }
    }
    public void ShowStudentList(){
        System.out.println("List of Student");
        for(int i=0;i<StudentList.size();i++){
            ShowStudent(StudentList.get(i));
        }
    }

    public void SearchByStudentCapacity() {

        String capacity="";
        int countResult=0;
        System.out.println("Enter Student Capacity");
        System.out.println("Student Capacity : EXCELLENT, VERY_GOOD, GOOD, AVERAGE, BELOW_AVERAGE, POOR");
        boolean inputValid = false;
        while (!inputValid){
            capacity=scn.nextLine();
            inputValid=checkInputCapacity(capacity);
            if(!inputValid){
                System.out.print("Incorrect! Enter again :");
            }
        }

        for (int i = 0; i < StudentList.size(); i++) {
            if (StudentList.get(i).getStudentCapacity().toString().equals(capacity)) {
                ShowStudent(StudentList.get(i));
                countResult++;
            }
        }
        if(countResult==0) System.out.println("Not found any student!");

    }

    public boolean checkInputCapacity(String checkStr){
        int keyCheck=0;
        String[] arrayCheck ={"EXCELLENT","VERY_GOOD","GOOD","AVERAGE","BELOW_AVERAGE","POOR"};
        for(String str : arrayCheck){
            if(checkStr.equals(str)) keyCheck++;

        }
        if(keyCheck == 0) return false;
        return true;

    }
    public void ShowStudent(Student student){
        System.out.println("ID : "+student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Date of Birth : " + student.getDoB());
        System.out.println("Address : " + student.getAddress());
        System.out.println("Height : " + student.getHeight());
        System.out.println("Weight : " + student.getWeight());
        System.out.println("Student Code : " + student.getStudentCode());
        System.out.println("School Name : " + student.getSchoolName());
        System.out.println("Year of Admission : " + student.getYearOfAdmission());
        System.out.println("GPA : " + student.getGPA());
        System.out.println("Student Capacity :" +student.getStudentCapacity());
        System.out.println("-----------------------------------------");
    }
    public void MenuEditStudent(){
        System.out.println("Menu Edit");
        System.out.println("1.Update Name ");
        System.out.println("2.Update Address ");
        System.out.println("3.Update Date of Birth ");
        System.out.println("4.Update Height ");
        System.out.println("5.Update Weight ");
        System.out.println("6.Update Student Code ");
        System.out.println("7.Update School Name ");
        System.out.println("8.Update Year of Admission ");
        System.out.println("9.Update GPA ");
        System.out.println("0.Exit ");
    }
    private String inputName(){
        System.out.print("Enter Name :");
        String name=scn.nextLine();
        if(name.length()<MAX_NAME_LENGTH && name.length()>0){
            return name;
        }
        return inputName();
    }

    private  String inputAddress(){
        System.out.print("Enter address : ");
        String address = scn.nextLine();
        if(address.length()<MAX_ADDRESS_LENGTH && address.length()>0){
            return address;
        }
        return inputAddress();
    }

    private LocalDate inputDoB(){

        System.out.print("Enter date of birth (format yyyy-mm-dd) :");
        String inputDate=scn.nextLine();
        try{
            LocalDate date=LocalDate.parse(inputDate);
            if(date.getYear()>1900) {
                return date;
            }
            return inputDoB();
        }catch(Exception e){
           return inputDoB();
        }
    }

    private double inputHeight(){
        double height =0;
        boolean inputValid=false;
        while (!inputValid) {
            try {
                System.out.print("Enter height : ");
                height = scn.nextDouble();
                if (height >= 50 && height <= 300) {
                    inputValid=true;
                }else{
                    System.out.println("Height input is out of Value! Enter again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input ! Please enter height again!");
                scn.nextLine();
            }
        }
        return height;
    }

    private double inputWeight(){
        double weight =0;
        boolean inputValid=false;
        while (!inputValid) {
            try {
                System.out.print("Enter weight : ");
                weight = scn.nextDouble();
                scn.nextLine();
                if (weight >= 5 && weight <= 1000) {
                    inputValid=true;
                }else{
                    System.out.println("Weight input is out of Value! Enter again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input ! Please enter height again!");
                scn.nextLine();
            }
        }
        return weight;
    }


    private String inputStudentCode(){
        String StudentCode= "";
        boolean inputValid=false;
        while (!inputValid) {
            System.out.print("Enter student code : ");
            StudentCode = scn.nextLine();
            boolean check = checkDistinctStudentCode(StudentCode);
            if (StudentCode.length() == 10 && check) {
                inputValid =true;
            }else{
                System.out.println("Incorrect Format of Student code ! Enter Again!");
            }
        }
        return StudentCode;
    }

    private boolean checkDistinctStudentCode(String code) {
        int k = 0;
        char c;
        for (int i = 0; i < code.length(); i++) {
            c = code.charAt(i);
            for (int j = i + 1; j < code.length(); j++) {
                if (c == code.charAt(j)) k++;
            }
        }
        if (k == 0) return true;
        else return false;
    }
        private int inputYearofAdmission(LocalDate DoB){
        int year=0;
        boolean inputValid = false;
        LocalDate localDate=LocalDate.now();
        while(!inputValid) {
            try {
                System.out.print("Enter year of admission : ");
                year = scn.nextInt();
                if(year>DoB.getYear()+15 && year <= localDate.getYear() ){
                    inputValid =true;
                }else{
                    System.out.println("Input year is out of value ! Enter again !");
                    scn.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Error ! Enter again !");
                scn.nextLine();
            }
        }
        return year;
    }

    private  String inputSchoolName(){
        String SchoolName = "";
        boolean inputValid = false;
        while(!inputValid) {
            try {
                System.out.print("Enter school name : ");
                SchoolName = scn.nextLine();
                if(SchoolName.length()>1){
                    inputValid=true;
                }
            }catch (IllegalArgumentException e){
                System.out.println("Error ! Enter again !");
                scn.nextLine();
            }

        }
        return SchoolName;
    }

    private  double inputGPA(){
        double GPA =0;
        boolean inputValid = false;
        while (!inputValid) {
            try{
                System.out.print("Enter GPA : ");
                GPA = scn.nextDouble();
                if (GPA >= MIN_GPA && GPA <= MAX_GPA) {
                    inputValid = true;
                }else{
                    System.out.println("GPA is out of value ! Enter again !");
                    scn.nextLine();
                }
            }
            catch(InputMismatchException e){
                System.out.println("Error ! Enter again !");
                scn.nextLine();
            }
        }
        return GPA;
    }
}
