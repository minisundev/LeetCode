class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList();

        list.add(new ArrayList());
        list.get(0).add(1);

        for(int i=1; i<numRows; i++){

            List<Integer> l = new ArrayList();
            List<Integer> before = list.get(i-1);

            l.add(1);
            for(int j=1;j<before.size();j++){
                l.add(before.get(j-1)+before.get(j));
            }
            l.add(1);

            list.add(l);
        }

        return list;
    }
}