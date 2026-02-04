/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var diameterOfBinaryTree = function(root) {
  let maxDiameter = 0;

  function dfs(root){

    if(root === null){
      return 0;
    }

    let leftT = dfs(root.left);
    let rightT = dfs(root.right);

    maxDiameter = Math.max(maxDiameter, leftT + rightT);
    return Math.max(leftT, rightT) + 1;

  }
  dfs(root);
  return maxDiameter;
};