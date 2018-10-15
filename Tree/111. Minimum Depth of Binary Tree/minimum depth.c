/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int minDepth(struct TreeNode* root) {
    if(root == NULL){
        return 0;
    }
    // Base case : Leaf Node. This accounts for height = 1. 
    if(root->left == NULL && root->right == NULL){
        return 1;
    }
    // If left subtree is NULL, recur for right subtree 
    if(!root->left){
        return 1+ minDepth(root->right);
    }
    // If right subtree is NULL, recur for left subtree 
    if(!root->right){
        return 1+ minDepth(root->left);
    }
    return 1+(minDepth(root->right) < minDepth(root->left)? minDepth(root->right):minDepth(root->left));
   
    
    
}
