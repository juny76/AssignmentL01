import java.time.LocalDate;

public class Student extends  Person {
    private String StudentCode;
    private String SchoolName;
    private int YearOfAdmission;
    private double GPA;
    private StudentCapacity studentCapacity;
    public Student(){}
    public Student(String name, LocalDate DoB, String address, double height, double weight, String studentCode, String schoolName, int yearOfAdmission, double GPA) {
        super(name, DoB, address, height, weight);
        this.StudentCode = studentCode;
        this.SchoolName = schoolName;
        this.YearOfAdmission = yearOfAdmission;
        this.GPA = GPA;
    }

    public String getStudentCode() {
        return StudentCode;
    }

    public void setStudentCode(String studentCode) {
        StudentCode = studentCode;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public int getYearOfAdmission() {
        return YearOfAdmission;
    }

    public void setYearOfAdmission(int yearOfAdmission) {
        YearOfAdmission = yearOfAdmission;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public StudentCapacity getStudentCapacity() {
        double score=this.getGPA();
        if(score<3) return StudentCapacity.POOR;
        if(score>=3 && score<5) return StudentCapacity.BELOW_AVERAGE;
        if (score>=5 && score<6.5) return StudentCapacity.AVERAGE;
        if (score>=6.5 && score<7.5) return StudentCapacity.GOOD;
        if (score>=7.5 && score<9) return StudentCapacity.VERY_GOOD;
        if (score>=9 && score<=10) return StudentCapacity.EXCELLENT;
        return null;
    }

    public void setStudentCapacity(StudentCapacity studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    @Override
    public String toString(){
        return super.toString()
                +"Student Code : " + this.StudentCode + "\n"
                +"School Name : " + this.SchoolName + "\n"
                +"Year of Admission : " + this.YearOfAdmission + "\n"
                +"GPA : " + this.GPA + "\n"
                +"Student Capacity : " + getStudentCapacity() +"\n"
                ;
    }
}
