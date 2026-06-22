class Solution {
    public int countPrimes(int n) {

        if(n == 0 || n == 1){return 0;}
        
        boolean[] comp = sieve(n);
        int cnt = 0;
        for(int i = 2; i < n; i++){
            if(!comp[i]){cnt++;}
        }

        return cnt;
    }

    public boolean[] sieve(int n) {
        boolean[] comp = new boolean[n]; // 0~n-1
        comp[0] = comp[1] = true;

        for(int i = 2; i * i < n; i++){
            if(!comp[i]){
                for(int j = i * i; j < n; j += i){comp[j] = true;}
            }
        }

        return comp;
    }
}