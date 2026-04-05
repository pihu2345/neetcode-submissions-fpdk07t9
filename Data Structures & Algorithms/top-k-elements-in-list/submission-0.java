class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     Map<Integer,Integer>count= new HashMap<>();
for(int num:nums){
    count.put(num, count.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<int []>map=new PriorityQueue<>((a,b)->a[0]-b[0]);
    for(Map.Entry<Integer,Integer>entry:count.entrySet()){
map.offer(new int[]{entry.getValue(),entry.getKey()});
    
    if(map.size()>k){
        map.poll();
    }}
    int [] result = new int[k];
    for(int i=0;i<k;i++){
    result[i] = map.poll()[1];
        

    }
return result;
    }}
    

    