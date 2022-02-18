package week2;

import java.util.ArrayList;
import week2.Interval;

public class StockBuySell {
	
	public StockBuySell(int[] price, int n) {
		 int count;
		  if (n == 1)//if list of price is less than 2
		  {  return;}
 
		  else {
			   count = 0;
		  }
 
         ArrayList<Interval> sol = new ArrayList<Interval>();
        
        int i = 0;
        while (i < n - 1) {
            
            while ((i < n - 1) && (price[i + 1] <= price[i]))
                i++;
 
           
            if (i == n - 1)
                break;
 
            Interval e = new Interval();
            e.buy = i++;
           
           
            while ((i < n) && (price[i] >= price[i - 1]))
                i++;
 
        
            e.sell = i - 1;
            sol.add(e);
 
          
            count++;
        }
 
       
        if (count == 0)
            System.out.println("There is no day when purchasing a gold will result in a profit.");
        else
            for (int j = 0; j < count; j++)
                System.out.println("Day: " + sol.get(j).buy+" buy gold "+ "\tDay : " + sol.get(j).sell+" sell gold");
 
        return;
    }
	

}
