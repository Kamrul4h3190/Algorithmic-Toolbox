import java.util.*;

public class CoveringSegments {
    private static int[] optimalPoints(Segment[] segments) {
        //write your code here

        Segment[] sortedSegments = organizeSegments(segments);
        /*for (int i=0; i< sortedSegments.length; i++) {
            System.out.println(i+" : "+sortedSegments[i].start+"  "+sortedSegments[i].end);
        }*/
        ArrayList<Integer> intersectingPoints = new ArrayList<>();
        int lastPoint = 0;
        for (Segment segment : sortedSegments) {
            if (!segment.covered){
                if( segment.start > lastPoint){
                    segment.covered = true;
                    lastPoint = segment.end;
                    intersectingPoints.add(lastPoint);
                } else {
                    if ( segment.start < lastPoint ){
                        segment.covered = true;
                    }
                }
            }
        }

        int n = intersectingPoints.size();
        int[] points= new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = intersectingPoints.get(i);
        }
        return points;
    }

    private static Segment[] organizeSegments(Segment[] segments){
        //sort by left end. Ascending
        for (int i = 0; i < segments.length-1; i++) {
            //System.out.println("i : "+i);
            Segment minSeg = segments[i];
            int minSegIndex = i;
            for (int j = i+1; j < segments.length; j++) {
                if (segments[j].end < minSeg.end){
                    minSeg = segments[j];
                    minSegIndex = j;
                }
            }
            //System.out.println("minSegIndex : "+minSegIndex);
            Segment temp = segments[minSegIndex];
            segments[minSegIndex] = segments[i];
            segments[i] = temp;
        }
        return segments;
    }
    private static class Segment {
        int start, end;
        boolean covered = false;
        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
