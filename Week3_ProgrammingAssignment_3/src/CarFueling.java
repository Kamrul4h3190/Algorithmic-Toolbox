import java.util.*;
import java.io.*;

import static java.util.Arrays.*;

public class CarFueling {

    //my code clean passed
    static int computeMinRefills(int dist, int tank, int[] stops) {
        if (dist<=tank){
            //System.out.println("No additional refill");
            return 0;
        }
        if (stops[0] > dist){
            //System.out.println("broken at first before : "+stops[0]);
            return -1;
        }

        ArrayList<Integer> allStops = new ArrayList<Integer>();
        allStops.add(0);
        for (Integer stop : stops) {allStops.add(stop);}
        allStops.add(dist);
        //System.out.println(allStops);

        int refills = 0;
        int tankMileage = tank;
        for (int i = 0; i < allStops.size() - 1; i++) {
            int currStop = allStops.get(i);
            int nextStop = allStops.get(i+1);
            //System.out.println("curr : "+currStop+", next : "+nextStop);

            if( nextStop > tank && i==allStops.size()-2 && currStop+tankMileage >= dist){
                //System.out.println("last stop refill at : "+currStop);
                return ++refills;
            }
            if(currStop+tankMileage < nextStop){
                //System.out.println("out of fuel before : "+nextStop);
                return -1;
            }
            if (nextStop > tank){
                //System.out.println("refill at : "+currStop);
                refills++;
                tank=currStop+tankMileage;
            }
        }
        return refills;
    }
    //my code ruff passed
    /*static int computeMinRefills(int dist, int tank, int[] stops) {
        if (tank < stops[0]){
            return -1;// tank 200, first stop 250 . broken before reaching first stop
        }
        int refills = 0;
        if (dist<=tank ){ ///&& stops[stops.length-1] < dist
            //System.out.println("no additional refill");
            return refills;
        }
        //copyiing into arrayList with additional 0,dist
        ArrayList<Integer> allStops = new ArrayList<Integer>();
        allStops.add(0);
        for (Integer stop : stops) {allStops.add(stop);}
        allStops.add(dist);
        //System.out.println(allStops);


        int tankMileage = tank;
        for (int i = 0; i < allStops.size()-1; i++) {
            int currStop = allStops.get(i);
            int nextStop = allStops.get(i+1);
            //System.out.println("curr : "+currStop+", next : "+nextStop);

            if (currStop+tankMileage >= dist){
                */
    /*System.out.println("last refill at : "+currStop);
                System.out.println("tank : "+(currStop+tankMileage));*//*
                return ++refills;//last refill
            }

            if(currStop+tankMileage < nextStop){
                //System.out.println("out of fuel before : "+nextStop);
                return -1;
            }

            if (currStop<nextStop && nextStop < dist){
                if(currStop+tankMileage < nextStop){
                    //System.out.println("out of fuel before : "+nextStop);
                    return -1;
                }

                if( nextStop > tank && i==allStops.size()-2 && currStop+tankMileage >= dist){
                    //System.out.println("last stop refill at : "+currStop);
                    return ++refills;
                }

                if (nextStop > tank){
                    refills++;
                    tank=currStop+tankMileage;
                    if (tank>dist){
                        tank = dist;
                    }
                    *//*System.out.println("tank : "+tank);
                    System.out.println("refill at : "+currStop);*//*


                    ///checking if destination is reachable from this station after refuelling
                    if (tank >=dist &&
                            currStop+tankMileage <= tank &&  currStop+tankMileage >= dist){
                        return refills;
                    }

                }
            }


        }
        return refills;
    }*/
    //passed forum collected
    /*static int computeMinRefills(int dist, int tank, int[] stops) {
         if (tank < stops[0]) return -1;
         if (tank > dist) return 0;

         int len = stops.length;
         int[] numOfRefill = new int[len+2];
         numOfRefill[0] = 0; numOfRefill[len+1] = dist;
         for (int i = 1; i <= len; i++)
             numOfRefill[i] = stops[i-1];

         int count = 0;
         int curr = 0;
         int length = numOfRefill.length;
         while (curr < length-1)
         {
             int last_curr = curr;
             while ((curr < length-1) && (numOfRefill[curr+1] - numOfRefill[last_curr] <= tank))
             {
                 curr += 1;
             }
             if (curr == last_curr) return -1;
             if (curr < length-1) count += 1;
         }
         return count;
     }*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
