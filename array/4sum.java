import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return ans;

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            long minWithI = (long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (minWithI > target) {
                break;
            }

            long maxWithI = (long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3];
            if (maxWithI < target) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                long minWithIJ = (long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (minWithIJ > target) {
                    break;
                }

                long maxWithIJ = (long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2];
                if (maxWithIJ < target) {
                    continue;
                }

                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        int lv = nums[l];
                        int rv = nums[r];
                        while (l < r && nums[l] == lv) {
                            l++;
                        }
                        while (l < r && nums[r] == rv) {
                             r--;
                        }
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return ans;
    }
}
