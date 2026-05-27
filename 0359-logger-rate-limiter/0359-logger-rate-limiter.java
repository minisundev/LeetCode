class Logger {

    Map<String,Integer> map = new HashMap<>();

    public Logger() { }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        int last = map.getOrDefault(message,0);
        boolean b = last <= timestamp;
        if(b){
            map.put(message,timestamp+10);
        }
        return b;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */