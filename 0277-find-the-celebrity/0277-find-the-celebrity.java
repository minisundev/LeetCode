/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        //아는 사람이 있으면 제거하면 됨
        int count = 0;
        int celeb = -1;

        //all the other people은 알아야 한다~ 나는 누구도 모르고...
        //내가 알아지는 것은 to에 내가 있어야 알 수 있음~
        for(int me = 0; me<n; me++){
            boolean everyoneKnowsMe = true;
            for(int other = 0; other<n; other++){
                if(other==me) continue;
                if(!knows(other,me)){
                    everyoneKnowsMe = false;
                    break;
                }
            }
            boolean iKnowNoOne = true;
            if(everyoneKnowsMe){
                //check if I know no one
                for(int other = 0; other<n; other++){
                    if(other==me) continue;
                    if(knows(me,other)){
                        iKnowNoOne = false;
                        break;
                    }
                }
                if(iKnowNoOne){
                    celeb = me;
                    count++;
                }
            }
            if(count>1){
                return -1;
            }
        }

        return celeb;
    }
}