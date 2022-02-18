package week2;

import week2.*;//import all class from week2 package
public class MainRun {
	public static void main(String[] args) {
		GoldProfit gf=	new GoldProfit();
		  int price[] = { 100, 180, 260, 310, 40, 535, 695 };
	        int n = price.length;
	        //call function
	       new StockBuySell(price, n);//function for buy and sell
	      System.out.println("\nProfit is "+gf.checkProfit(price, 0, n-1)); //function for 
	       
	        
	}

	

}
