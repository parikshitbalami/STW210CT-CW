package week6;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
 
class Main
{
    
    public static int findKthLargest(List<Integer> ints, int k)
    {
       
        PriorityQueue<Integer> pq = new PriorityQueue<>(ints.subList(0, k));
 
        for (int i = k; i < ints.size(); i++)
        {
            
            if (ints.get(i) > pq.peek())
            {
                
                pq.poll();
                pq.add(ints.get(i));
            }
        }
 
        // return the value
        return pq.peek();
    }
 
 
    public static void main(String[] args)
    {
        List<Integer> ints = Arrays.asList(7, 10, 4, 3, 20, 15);
        int k = 3;
 
        System.out.println("k'th largest array element is " +
                findKthLargest(ints, k));
    }
}