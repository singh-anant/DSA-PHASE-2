import java.util.ArrayList;

class Solution {
    static void findPermutation(int nums[], int fr[], ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ans) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (fr[i] == 0) {
                fr[i] = 1;
                ds.add(nums[i]);
                findPermutation(nums, fr, ds, ans);
                ds.remove(ds.size() - 1);
                fr[i] = 0;
            }
        }
    }

    public ArrayList<ArrayList<Integer>> permute(int[] nums) {
        int fr[] = new int[nums.length];
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        findPermutation(nums, fr, ds, answer);
        return answer;
    }
}