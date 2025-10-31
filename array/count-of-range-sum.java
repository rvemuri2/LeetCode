class BST{
    long arr[];
    int n;
    
    BST(long arr[]) {
        this.arr = arr;
        this.n = arr.length;
    }
    
    int ceil(long num){
        int lo = 0, hi = n-1, res = -1;
        while(hi >= lo) {
            int mid = (lo + hi) / 2;

            if(arr[mid] >= num) {
                res=mid;
                hi=mid-1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
    
    int floor(long num){
        int lo = 0, hi = n-1, res = -1;
        while(hi >= lo) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= num) {
                res = mid;
                lo = mid+1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }
}

class Solution {
    
    int seg[];
    
    long sum[];
    
    Map<Long,Integer>map;
    
    Map<Long,Integer>mapCount;
    
    private int build(int left,int right,int index){
        if(left == right)
            return seg[index] = 1;
        int mid=(left+right) / 2;
        return seg[index] = build(left, mid, 2 * index + 1) + build(mid+1, right, 2 * index + 2);
    }
    
    private int update(int left,int right,int in,int index){
        if(left > in || right < in)
            return seg[index];
        if(left==right)
            return seg[index]=0;
        int mid= (left + right) / 2;
        return seg[index]=update(left,mid,in,2*index+1)+update(mid+1,right,in,2*index+2);
    }
    
    private int count(int left, int right, int l, int r, int index){
        if(right < l || left > r)
            return 0;
        if(left >= l && right <= r)
            return seg[index];
        int mid = (left + right) / 2;
        return count(left, mid, l, r, 2 * index + 1) + count(mid + 1, right, l, r, 2 * index + 2);
    }
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        
        seg = new int[4 * n];
        sum = new long[n];
        map = new HashMap<>();
        mapCount = new HashMap<>();
        
        sum[0] = nums[0];

        for(int i = 1; i < n; i++)
            sum[i] = sum[i-1] + nums[i];
        
        Arrays.sort(sum);
        
        build(0, n-1, 0);
        
        for(int i = 0; i < n; i++)

            if(map.get(sum[i]) == null){
                map.put(sum[i], i);
                mapCount.put(sum[i], 0);
            }
        
        int res = 0;
        
        long mid = 0;
        
        BST bst = new BST(sum);
        
        for(int i = 0; i < n; i++){
            
            int fl = bst.floor(mid + upper);
            
            int ce = bst.ceil(mid + lower);
            
            if(fl != -1 && ce != -1 && fl >= ce)
                res += count(0, n-1, ce, fl, 0);
            
            mid += nums[i];
            
            update(0, n-1, map.get(mid) + mapCount.get(mid), 0);

            mapCount.put(mid, mapCount.get(mid) + 1);
        }
        return res;
    }
}