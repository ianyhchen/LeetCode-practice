/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int maxDepth(struct TreeNode* root) {    
    if(root == NULL){
        return 0;
    }    
    int ldepth = maxDepth(root->left);
    int rdepth = maxDepth(root->right);
    return 1+(ldepth > rdepth? ldepth:rdepth);
}
bool isBalanced(struct TreeNode* root) {
    if(root == NULL || root->left == NULL && root->right == NULL ){
        return true;
    }
    int left_depth = maxDepth(root->left);
    int right_depth = maxDepth(root->right);
    
    if(abs(left_depth-right_depth)>1){
        return false;
    }
    else{
        return isBalanced(root->left) && isBalanced(root->right);
        
    }
    
}
