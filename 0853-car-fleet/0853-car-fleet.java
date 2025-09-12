class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //car fleet number
        // like... lecture problem...

        //list vs stack
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < speed.length; i++) {
            list.add(new Car(speed[i], position[i], target));
        }

        Collections.sort(list, (o1, o2) -> o2.position - o1.position);

        List<Car> fleets = new ArrayList<>();
        fleets.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            Car now = list.get(i);
            Car last = fleets.get(fleets.size()-1);

            if(now.time>last.time){
                fleets.add(now);
            }
            //or previous fleets will absorb : this doesn't count

        }
        return fleets.size();
    }
}

class Car {
    public int speed;
    public int position;
    public double time;

    public Car(int s, int p, int target) {
        speed = s;
        position = p;
        time = (double)(target-p)/s;
    }
}