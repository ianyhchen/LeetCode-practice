// define the structure of linkedlist to create stacks
typedef struct node{
    int data;
    struct node *next;
} Stack;

// use two stacks to implement queue
typedef struct {
    Stack *stack1;
    Stack *stack2;    
} MyQueue;
/**
Methods of controling stack
**/
Stack* stackCreate(void){
    Stack *newStack = (Stack*)malloc(sizeof(Stack));
    if(newStack == NULL){
        printf("malloc Stack failed \n");
        //getchar();
        exit(0);
    }
    //memset(newStack, 0, sizeof(Stack));
    newStack->data = NULL;
    newStack->next = NULL;
    return newStack;
}

bool isEmpty(Stack* stack){
    return (stack->next == NULL);
}

int stack_pop(Stack* stack){
    int value;
    Stack *temp = NULL;
    if(!isEmpty(stack)){       
        temp = stack->next;
        value = temp->data;
        stack->next = stack->next->next;
        free(temp);           
    }    
    else{
        printf("Stack underflow \n");
        //getchar();
        exit(0);  
    }
    return value;
}

void stack_push(Stack* stack, int new_data){
    Stack *newnode = (Stack*)malloc(sizeof(Stack));
    if(newnode ==NULL){
        printf("Stack overflow \n");
        getchar();
        exit(0);
    }
    newnode->data = new_data;
    newnode->next = stack->next;
    stack->next = newnode;
    //printf("push %d\n",stack->next->data);
}
int stack_top(Stack *stack)
{
    if(!isEmpty(stack))
    {
        return stack->next->data;
    }

    return -1;
}
/*
void show_stack(MyQueue* obj){
    MyQueue* temp = obj;
    if(temp->stack1 != NULL){
        printf("Stack1:");
        while(temp->stack1 != NULL){
            printf(" %d ",temp->stack1->data);
            stack_pop(&temp->stack1);
        }
    }
    else if(temp->stack2 != NULL){
        printf("Stack2:");
        while(temp->stack2 != NULL){
            printf(" %d ",temp->stack2->data);
            stack_pop(&temp->stack2);
        }
    }
}*/

/**
Methods of controling queue
**/

/** Initialize your data structure here. */
MyQueue* myQueueCreate(int maxSize) {
    MyQueue *queue = (MyQueue*)malloc(sizeof(MyQueue));
    queue->stack1 = stackCreate();
    queue->stack2 = stackCreate(); 
    //show_stack(queue);
    return queue;
}

/** Push element x to the back of queue. */
void myQueuePush(MyQueue* obj, int x) {
    stack_push(obj->stack1, x); //push the new element at the top of stack1
    //show_stack(obj);
}

/** Removes the element from in front of queue and returns that element. */
int myQueuePop(MyQueue* obj) {
    int temp_data;
    if(isEmpty(obj->stack1) && isEmpty(obj->stack2)){
        printf("queue is empty \n");
        getchar();
        exit(0);
    }
    // if stack2 is empty, pop all element in stack1 and push to stack2,  
    //thus,the oldest element in stack1 will be at the top of stack2) 
    else if(isEmpty(obj->stack2)){ 
        while(!isEmpty(obj->stack1)){           
            temp_data = stack_pop(obj->stack1);
            stack_push(obj->stack2, temp_data);            
        }
    }
    //pop the element at the top of stack2,
    temp_data = stack_pop(obj->stack2);
    return temp_data;
}

/** Get the front element. */
int myQueuePeek(MyQueue* obj) {
    int temp_data;
    if(isEmpty(obj->stack1) && isEmpty(obj->stack2)){
        printf("queue is empty \n");
        getchar();
        exit(0);
    }
    else if(isEmpty(obj->stack2)){              
        while(!isEmpty(obj->stack1)){           
            temp_data = stack_pop(obj->stack1);
            stack_push(obj->stack2, temp_data);            
        }
    }
    temp_data = stack_top(obj->stack2);
    //printf("%d\n",temp_data);
    return temp_data;
}

/** Returns whether the queue is empty. */
bool myQueueEmpty(MyQueue* obj) {
    return (isEmpty(obj->stack1) && isEmpty(obj->stack2));
}

void myQueueFree(MyQueue* obj) {
    if(obj){
        free(obj->stack1);
        free(obj->stack2);
    }
}

/**
 * Your MyQueue struct will be instantiated and called as such:
 * struct MyQueue* obj = myQueueCreate(maxSize);
 * myQueuePush(obj, x);
 * int param_2 = myQueuePop(obj);
 * int param_3 = myQueuePeek(obj);
 * bool param_4 = myQueueEmpty(obj);
 * myQueueFree(obj);
 */

