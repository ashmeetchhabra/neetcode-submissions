class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed =0;
        
        for(int pile: piles){
            maxSpeed = Math.max(maxSpeed, pile);
        }

        while(minSpeed<=maxSpeed){
            int mid = (minSpeed+maxSpeed)/2;
            if(canEatBananas(piles, h, mid))
                maxSpeed=mid-1;
            else
                minSpeed=mid+1;
        }
        return minSpeed;
    }

    private boolean canEatBananas(int[] piles, int h, int speed){
        long hours = 0;
        for(int pile: piles){
            hours = hours + (long)(Math.ceil((double)pile/speed));
        }
        if(hours<=h)
            return true;
        return false;
    }
}
