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
//Recursive solution
/*
void inorder(int *size, int **result, struct TreeNode* root){
    if(root == NULL){
        return;
    }
    inorder(size, result, root->left);
    (*size)++;
    *result = realloc(*result,(*size)*sizeof(int));
    (*result)[(*size) - 1] = root->val;
    inorder(size, result, root->right);
}

int* inorderTraversal(struct TreeNode* root, int* returnSize) {
    int size = 0;
    int* result = calloc(1,sizeof(int));
    inorder(&size, &result, root);
    *returnSize = size;
    return result;
    
}*/
// Iterative solution
int* inorderTraversal(struct TreeNode* root, int* returnSize) {
    int* result = NULL;
    *returnSize = 0;
    //Create an empty stack 
    struct TreeNode** stack = (struct TreeNode**)malloc(sizeof(struct TreeNode*));
    int stack_length = 0;    
    while(stack_length > 0 || root != NULL){
        if(root){
            //Push the current node to stack and set root = root->left until root is NULL
            stack = (struct TreeNode**)realloc(stack,sizeof(struct TreeNode*)*stack_length+1 );
            stack[stack_length++] = root;
            root = root->left;
        }
        else{
            // If current is NULL and stack is not empty then 
            //pop item from stack
            root = stack[--stack_length];
            result = (int*)realloc(result,sizeof(int)*(*returnSize+1));
            result[*returnSize] = root->val;
            *returnSize += 1;
            root = root->right;
            
        }
    }
    return result;
    
}
