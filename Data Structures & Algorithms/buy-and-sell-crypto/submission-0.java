class Solution {
    public int maxProfit(int[] prices) {
       //int []price =  price.length()-1;
       int minprice =Integer.MAX_VALUE;
       
       int profit=0;
       for(int price:prices){
        if(price<minprice){
            minprice =price;
        }else{
 int diff = price - minprice;
profit = Math.max(profit,diff);
       }}
       return profit;
    }
}
