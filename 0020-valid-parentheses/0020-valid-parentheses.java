class Solution {
    public boolean isValid(String s) {
        String[] sArr = s.split("");
        UserStack stk = new UserStack(sArr.length);
        for(String iter : sArr){
            if(iter.equals(")")){
                if(stk.elemNum != 0){
                    if(!stk.pop().equals("(")){return false;}
                    else {continue;}
                } else {return false;}
            }
            else if(iter.equals("}")){
                if(stk.elemNum != 0){
                    if(!stk.pop().equals("{")){return false;}
                    else {continue;}
                } else {return false;}
            }
            else if(iter.equals("]")){
                if(stk.elemNum != 0){
                    if(!stk.pop().equals("[")){return false;}
                    else {continue;}
                } else {return false;}
            } else {stk.push(iter);}
        }
        return stk.elemNum == 0;
    }
}

class UserStack {
    String[] stack;
    int top;
    int elemNum;

    public UserStack(int size){
        this.stack = new String[size];
        this.top = 0;
        this.elemNum = 0;
    }
    public void push(String elem){
        this.stack[this.top] = elem;
        this.top++;
        this.elemNum++;
    }

    public String pop(){
        if(this.elemNum != 0){
            this.top--;
            String temp = this.stack[this.top];
            this.stack[this.top] = null;
            this.elemNum--;
            return temp;
        } else {return "none";}
        
    }
}