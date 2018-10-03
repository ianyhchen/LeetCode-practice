/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
void preorder(int *size, int **result, struct TreeNode* root){
    if(root == NULL){
        return;
    }
    (*size)++;
    *result = realloc(*result,(*size)*sizeof(int));
    (*result)[(*size)-1] = root->val;
    preorder(size, result, root->left);
    preorder(size, result, root->right);
}

int* preorderTraversal(struct TreeNode* root, int* returnSize) {
    int size = 0;
    int* result = calloc(1,sizeof(int));
    preorder(&size, &result, root);
    *returnSize = size;
    /*for(int i = 0; i < size; i++){
        printf("%d ",result[i]);
    }*/
    return result;
}
