typedef struct QNode{
    int data;
    struct QNode *next;
} QNode;

typedef struct Queue{
    struct QNode *front,*rear;
    
}Queue;

typedef struct {
    Queue *queue;
    int size;
} MyStack;


/**
Methods of controling quque 
*/
QNode *newNode(int new_data){
    QNode *node = (QNode*)malloc(sizeof(QNode));
    node->data = new_data;
    node->next = NULL;
    return node;
}
Queue *queueCreate(){
    Queue *queue = (Queue*)malloc(sizeof(Queue));
    queue->front = queue->rear = NULL;
    
    return queue;
}

bool isEmpty(Queue *q){
    printf("front:%d rear:%d\n",q->front->data,q->rear->data);
    return (q->rear->next == NULL);
}

Queue *deQueue(Queue *queue){
    if(queue->front == NULL){
        printf("queue is empty, dequeue failed\n");
        return NULL;
    }   
    queue->front = queue->front->next;    
    if(queue->front == NULL){
        printf("NULL\n");
        queue->rear = NULL;
    }    
    return 0;    
}

void enQueue(Queue *queue, int new_data){
    QNode *node = newNode(new_data);
     if(node == NULL){
        printf("malloc newnode failed\n");
        exit(0);
    }
    if(queue->rear == NULL){
        queue->front = queue->rear = node;
        return;
    }
    queue->rear->next = node;
    queue->rear = node;    
}
/** Initialize your data structure here. */
MyStack* myStackCreate(int maxSize) {
    MyStack *stack = (MyStack*)malloc(sizeof(MyStack));
    stack->queue = queueCreate();
    stack->size = 0;
    return stack;    
}

/** Push element x onto stack. */
void myStackPush(MyStack* obj, int x) {           
    enQueue(obj->queue,x);    
    (obj->size)++;
    int stack_size = obj->size;
    printf("enqueue: %d,stack size:%d\n",x,stack_size);
    //move those nodes before new node to behind of new node
    while(stack_size>1){        
        QNode* temp = obj->queue->front;        
        deQueue(obj->queue);
        enQueue(obj->queue,temp->data);        
        stack_size--;
    }   
}

/** Removes the element on top of the stack and returns that element. */
int myStackPop(MyStack* obj) {
    int temp = myStackTop(obj);   
    deQueue(obj->queue);    
    (obj->size)--;
    return temp;   
}

/** Get the top element. */
int myStackTop(MyStack* obj) {
    Queue *temp = obj->queue;
    return temp->front->data;
    
}

/** Returns whether the stack is empty. */
bool myStackEmpty(MyStack* obj) {
    if(obj->size == 0){
        return true;
    }
    else{
        return false;
    }
}

void myStackFree(MyStack* obj) {
    if(obj){
        free(obj);
    }
}

/**
 * Your MyStack struct will be instantiated and called as such:
 * struct MyStack* obj = myStackCreate(maxSize);
 * myStackPush(obj, x);
 * int param_2 = myStackPop(obj);
 * int param_3 = myStackTop(obj);
 * bool param_4 = myStackEmpty(obj);
 * myStackFree(obj);
 */

