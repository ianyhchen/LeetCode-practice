typedef struct Node{
    char data;
    struct Node* next;
}Stack;

Stack* createStack(void){
     Stack* new_stack = (Stack*)malloc(sizeof(Stack));
    if(new_stack == NULL){
        printf("malloc stack failed");
        exit(0);
    }
    new_stack->data = NULL;
    new_stack->next = NULL;
    return new_stack;
}

void push(Stack** s,char newChar){
    Stack* newNode = createStack();
    newNode->data = newChar;
    newNode->next = *s;
    *s = newNode;
    //printf("push %c\n",(*s)->data);
}

char pop(Stack** s){
    char value;
    Stack* temp = NULL;
    if(*s != NULL){
        temp = *s;
        value = temp->data;
        *s = temp->next;
        free(temp);
    }
    else{
        printf("Stack underflow \n");
        //getchar();
        exit(0);  
    }
    //printf("pop %c\n",value);
    return value;
}

bool isValid(char* s) {
    Stack* stack = createStack();
    int len = strlen(s);
    for(int i = 0; i < len; i++){
        printf("char: %c\n",s[i]);
        if(s[i] == '(' || s[i] == '[' || s[i] == '{'){
            push(&stack, s[i]);
            //printf("push %c\n",stack->data);
        }
        else{
            if(stack == NULL){
                printf("stack NULL\n");
                return false;
            }                      
            if(s[i] == ')' && stack->data != '('){
                return false;
            }
            if(s[i] == '}' && stack->data != '{'){
                return false;
            }
            if(s[i] == ']' && stack->data != '['){
                return false;
            }
            pop(&stack);
            //printf("top: %c\n",stack->data);

        }
        
    }
    //printf("stack %c\n",stack);
    if(stack->data != NULL){
        //printf("stack NULL\n");
        return false;
    }
    return true;
    
}
