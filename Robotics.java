import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String[] robotInfo = scanner.nextLine().split(";");
        Map<String, Integer[]> robots = new LinkedHashMap<>();
        //naredihme robotite
        for (int i = 0; i < robotInfo.length; i++) {
            String[] curr = robotInfo[i].split("-");
            robots.put(curr[0],new Integer[2]);
            Integer[] arr = robots.get(curr[0]);
            arr[0] = Integer.parseInt(curr[1]);
            arr[1] = 0;
        }
        int[] time =Arrays.stream(scanner.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();
        long realTime = time[0]*3600 + time[1]*60 + time[2];

        ArrayDeque<String> product = new ArrayDeque<>();
        String input = scanner.nextLine();
        //poluchihme produktite
        while(!input.equals("End")){
            product.offer(input);
            input = scanner.nextLine();
        }
        //da gi zapo4nem
        while(!product.isEmpty()){
            realTime++;
            String nowHandling = product.poll();
            boolean isTaken = false;


            for(Map.Entry<String, Integer[]> e: robots.entrySet()){
                if(e.getValue()[1]==0 && !isTaken){
                    isTaken = true;
                    e.getValue()[1]=e.getValue()[0];
                    printTask(e.getKey(), nowHandling, realTime);

                }
                if(e.getValue()[1]>0){
                    e.getValue()[1]--;
                }
            }
            if(!isTaken){
                product.offer(nowHandling);
               // int minRuningTime = getMinTime(robots);
               // timePased+=
            }

        }

    }

    private static void printTask(String key,String product, long realTime) {
        String[] currTime = calcTime(realTime);
        System.out.println(String.format("%s - %s [%s:%s:%s]", key, product, currTime[0], currTime[1], currTime[2]));
    }

    private static String[] calcTime(long realTime) {
        long s = realTime % 60;
        long m = (realTime / 60) % 60;
        long h = (realTime / (60 * 60)) % 24;
        String[] time = new String[3];
        if(s<10) {
            time[2]="0"+s;
        }else{
            time[2]=""+s;
        }
        if(m<10){
            time[1]="0"+m;
        }else{
            time[1]=""+m;
        }
        if(h<10){
            time[0]="0"+h;
        }else{
            time[0]=""+h;
        }
        return time;

    }
}
