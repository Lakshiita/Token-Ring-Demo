import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class tokenRing {
    static ArrayList<Integer> StationList = new ArrayList<Integer>();
    public static void Generate_randomno(){
        for (int i = 1; i <= 10; i++) {
            StationList.add(i);
        }
        Collections.shuffle(StationList);
        System.out.println("Random Stations from 1 to 10");
        for (int i = 0; i < 10; i++) {
            System.out.print(" "+StationList.get(i));
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Generate_randomno();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Source ");int s=sc.nextInt();
        System.out.println("Enter destination ");int d=sc.nextInt();
        System.out.println("Enter message ");String m=sc.next();

        Frame frame=new Frame(s,d,m,StationList);
        frame.tokenRingT();
    }
}

class Frame{
    int source,destination;
    String msg;
    ArrayList<Integer> StationList;
    Frame(){}
    Frame(int s,int d,String m,ArrayList SList){
        source=s;
        destination=d;
        msg=m;
        StationList=SList;
    }
    public void tokenRingT(){
        int flag=0;
        for (int i = 0; i < StationList.size(); i++){

            if(StationList.get(i)!=destination && StationList.get(i)!=source) {
                System.out.println(StationList.get(i) + ": " + source + " | " + destination + " | " + msg);
            }
            else if(StationList.get(i)==destination){
            System.out.println(destination+": This is message : "+msg+" >>Recieved by "+StationList.get(i));
            flag++;
        }

        }
        if(flag==1){
            StationList.removeAll(StationList);
            System.out.println(source+": NULL");
        }
    }
}
