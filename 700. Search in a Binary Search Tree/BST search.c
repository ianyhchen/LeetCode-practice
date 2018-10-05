/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* searchBST(struct TreeNode* root, int val) {
    if(root == NULL){
        return NULL;
    }
    //printf("root val: %d\n",root->val);
    if(root->val == val){
        //printf("same\n");
        return root;
    }
    if(root->val < val){
        return searchBST(root->right, val);
    }
    else if(root->val > val){
        return searchBST(root->left, val);
    }
    return NULL;
}
