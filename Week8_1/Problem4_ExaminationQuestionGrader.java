import java.util.*;
import java.util.regex.*;
public class Problem4_ExaminationQuestionGrader {
    interface Question { double grade(String correct, String answer, double points); String type(); }
    static class MCQ implements Question {
        public double grade(String c,String a,double p){ return c.equals(a)?p:0; }
        public String type(){return "MCQ";}
    }
    static class TF implements Question {
        public double grade(String c,String a,double p){ return c.equals(a)?p:0; }
        public String type(){return "TF";}
    }
    static class Essay implements Question {
        public double grade(String c,String a,double p) {
            int hits=0;
            for(String k:c.split(",")) if(!k.trim().isEmpty() && a.toLowerCase().contains(k.trim().toLowerCase())) hits++;
            return hits>=2?p*.75:hits==1?p*.5:0;
        }
        public String type(){return "ESSAY";}
    }
    static String[] tokens(String s) {
        Matcher m=Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(s);
        List<String> out=new ArrayList<>();
        while(m.find()) out.add(m.group(1)!=null?m.group(1):m.group(2));
        return out.toArray(new String[0]);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine().trim()); double total=0;
        for(int i=0;i<n;i++) {
            String[] p=tokens(sc.nextLine());
            Question q=p[0].equals("MCQ")?new MCQ():p[0].equals("TF")?new TF():new Essay();
            double points=Double.parseDouble(p[4]);
            double score=q.grade(p[2],p[3],points);
            System.out.printf("%s: %.2f%n",q.type(),score); total+=score;
        }
        System.out.printf("Total Score: %.2f%n",total);
    }
}
