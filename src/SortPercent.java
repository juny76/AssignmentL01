import java.util.ArrayList;
import java.util.HashMap;

public class SortPercent {

    public SortPercent(){

    }

    public void Sort_StudentCapacity_Percent(){
        int execellent=0;
        int very_good=0;
        int good = 0;
        int average=0;
        int below_average =0;
        int poor=0;
        double execellent_percent,very_good_percent,good_percent,average_percent,below_average_percent,poor_percent;

        for(int i = 0; i < StudentService.StudentList.size(); i++){
            if(StudentService.StudentList.get(i).getStudentCapacity()==StudentCapacity.EXCELLENT) execellent++;
            if(StudentService.StudentList.get(i).getStudentCapacity()==StudentCapacity.VERY_GOOD) very_good++;
            if(StudentService.StudentList.get(i).getStudentCapacity()==StudentCapacity.GOOD) good++;
            if(StudentService.StudentList.get(i).getStudentCapacity()==StudentCapacity.AVERAGE) average++;
            if(StudentService.StudentList.get(i).getStudentCapacity()==StudentCapacity.BELOW_AVERAGE) below_average++;
            if(StudentService.StudentList.get(i).getStudentCapacity()==StudentCapacity.POOR) poor++;
        }
        execellent_percent=(double) execellent/ StudentService.StudentList.size() * 100;
        very_good_percent=(double) very_good/ StudentService.StudentList.size() * 100;
        good_percent=(double) good/ StudentService.StudentList.size() * 100;
        average_percent=(double) average/ StudentService.StudentList.size() * 100;
        below_average_percent=(double) below_average/ StudentService.StudentList.size() * 100;
        poor_percent=(double) poor/ StudentService.StudentList.size() * 100;

        String[][] arr={{"Excellent", String.valueOf(execellent_percent)},{"Very Good",String.valueOf(very_good_percent)},{"Good",String.valueOf(good_percent)},{"Average",String.valueOf(average_percent)},{"Below Average",String.valueOf(below_average_percent)},{"Poor",String.valueOf(poor_percent)} };

        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                double value1=Double.parseDouble(arr[j][1]);
                double value2=Double.parseDouble(arr[j+1][1]);
                if(value1<value2){
                    String[] temp =arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        for(int i=0;i<arr.length;i++){
//            System.out.println(arr[i][0] + ":" + arr[i][1]);
            double output1= Double.parseDouble(arr[i][1]);
            System.out.printf("%s : %.2f %% \n",arr[i][0],output1);
        }
    }

    public void Sort_GPA_Percent(){
        ArrayList<Double> ScoreList = new ArrayList<>();
        for(int i = 0; i< StudentService.StudentList.size(); i++){
            ScoreList.add(StudentService.StudentList.get(i).getGPA());
        }

        HashMap<Double,Integer> ScoreCounter=new HashMap<>();

        for(int i=0;i<ScoreList.size();i++){
            if(!ScoreCounter.containsKey(ScoreList.get(i))){
                ScoreCounter.put(ScoreList.get(i),1);
            }else{
                ScoreCounter.put(ScoreList.get(i),ScoreCounter.get(ScoreList.get(i))+1);
            }
        }
        for(double score : ScoreCounter.keySet()){
            double percentage = (double) ScoreCounter.get(score)/ScoreList.size() * 100;
            System.out.printf("%.2f : %.2f %% \n",score,percentage);
        }

    }
}
