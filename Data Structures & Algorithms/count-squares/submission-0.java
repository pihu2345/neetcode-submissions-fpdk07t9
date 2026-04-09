class CountSquares {
Map<String,Integer>map;
    public CountSquares() {
      map = new HashMap<>();  
    }
    
    public void add(int[] point) {
       String key = point[0]+","+point[1];
       map.put(key,map.getOrDefault(key,0)+1); 
    }
    
    public int count(int[] point) {
     int x = point[0],y = point[1],total =0;
     for(String key:map.keySet()){
        String[] parts = key.split(",");
        int px = Integer.parseInt(parts[0]);
        int py = Integer.parseInt(parts[1]);
        if(Math.abs(x-px) == Math.abs(y-py)&&x!=px){
            String p1 = x+","+py;
            String p2 = px+","+y;
            int count1 = map.getOrDefault(key,0);
            int count2 = map.getOrDefault(p1,0);
            int count3 = map.getOrDefault(p2,0);

            total += count1*count2*count3;
        }
     }   
     return total;
    }
}
