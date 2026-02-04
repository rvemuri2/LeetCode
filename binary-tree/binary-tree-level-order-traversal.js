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
 * @return {number[][]}
 */
var levelOrder = function(root) {
     if(!root){
    return [];
  }

  const result = [];
  const q = [root];
  let head = 0;

  //   3
// 9   20
//    15  7
// [[3], [9, 20], [15, 7]]

  while(head < q.length){
    const level = []; //empty
    const levelSize = q.length - head; //2

    for(let iterator = 0; iterator < levelSize; iterator++){

      const node = q[head]; //20
      head++; //3

      level.push(node.val); // [9, 20]

      if(node.left){
        q.push(node.left); //3, 9, 
      }
      if(node.right) {
        q.push(node.right); //3, 9, 20, 15, 7
      }

    }

    result.push(level); //[3], [9,20]
  }

  return result;
};