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
        for (int j = i; j >= 0; j--) {
            if (j < i && candidates[j] == candidates[j + 1])
                continue;
            if (candidates[j] > target)
                continue;
            curr.add(candidates[j]);
            dfs(candidates, target - candidates[j], j - 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
