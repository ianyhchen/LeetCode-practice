/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


struct TreeNode* mergeTrees(struct TreeNode* t1, struct TreeNode* t2) {
    if (!t1){
        return t2;
    }
    if(!t2){
        return t1;
    }
    struct TreeNode *tree = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    tree->val = t1->val + t2->val;
    tree->left = mergeTrees(t1->left, t2->left);
    tree->right = mergeTrees(t1->right, t2->right);
    return tree;
    
}
