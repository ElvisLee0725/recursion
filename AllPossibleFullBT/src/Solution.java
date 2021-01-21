import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// A full binary tree is a binary tree where each node has exactly 0 or 2 children.
// Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
// Each node of each tree in the answer must have node.val = 0.
// You may return the final list of trees in any order.

// For each root, all FBT are from all possible left child FBT and right child FBT
// Use a HashMap<Integer, List<TreeNode>> to store <N, List of treenode at N>
// At each round, if the N doesn't exist in map, try all x (number of nodes in left) and y (number of nodes in right) combination. Create a node to assign its left and right child to left and right.
// Add the list to map with current N
// Finally, return map.get(N) to get the list of nodes
class Solution {
    public static void main(String[] args) {
        
    }
    HashMap<Integer, List<TreeNode>> map = new HashMap();

    public List<TreeNode> allPossibleFBT(int N) {
        if(!map.containsKey(N)) {
            List<TreeNode> list = new ArrayList();
            if(N == 1) {
                list.add(new TreeNode(0));
            }
            else if(N % 2 == 1) {
                for(int x = 0; x < N; x++) {
                    int y = N - 1 - x;
                    for(TreeNode left : allPossibleFBT(x)) {
                        for(TreeNode right : allPossibleFBT(y)) {
                            TreeNode cur = new TreeNode(0);
                            cur.left = left;
                            cur.right = right;
                            list.add(cur);
                        }
                    }
                }
            }
            map.put(N, list);
        }
        return map.get(N);
    }
}