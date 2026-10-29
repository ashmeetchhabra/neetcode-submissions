class TimeMap {
    Map<String,ArrayList<TimestampValues>> mp;

    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!mp.containsKey(key)){
            ArrayList<TimestampValues> lt= new ArrayList<>();
            mp.put(key,lt);
        }
        TimestampValues tv = new TimestampValues(timestamp,value);
        mp.get(key).add(tv);
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key))
            return "";
        ArrayList<TimestampValues> arr= mp.get(key);
        Optional<TimestampValues> op = binarySearch(arr, timestamp);
        if(op.isEmpty())
            return "";
        return op.get().val;  
    }

    private Optional<TimestampValues> binarySearch(ArrayList<TimestampValues> arr, int timestamp){
        int left = 0;
        int right = arr.size()-1;
        int matchIdx=-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr.get(mid).timestamp==timestamp)
                return Optional.of(arr.get(mid));
            else if(arr.get(mid).timestamp<timestamp){
                matchIdx=mid;
                left=mid+1;
            }
            else
                right=mid-1;
        }
        if(matchIdx==-1)
            return Optional.empty();
        return Optional.of(arr.get(matchIdx));
    }
}

class TimestampValues{
    int timestamp;
    String val;

    TimestampValues(int timestamp, String val){
        this.timestamp= timestamp;
        this.val=val;
    }

}
