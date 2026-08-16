class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, candidates.length - 1, new ArrayList<Integer>());
        return result;

    }

    public void dfs(int candidates[], int target, int i, List<Integer> curr) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (i < 0 || target < 0) {
            return;
        }

        curr.add(candidates[i]);
        dfs(candidates, target - candidates[i], i - 1, curr);
        curr.remove(curr.size() - 1);
        int j = i - 1;
        while (j >= 0 && candidates[j] == candidates[i]) {
            j--;
        }
        dfs(candidates, target, j, curr);

    }
}