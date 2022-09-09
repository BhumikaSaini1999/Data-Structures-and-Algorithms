package stack1;

import java.util.Stack;

//For a given string expression containing only round brackets or parentheses, check if they are balanced or not. 
//Brackets are said to be balanced if the bracket which opens last, closes first.

//Time=>O(n), Space=>O(n)
//We have used stack here as an extra space

//Multiple Cases
// (()()())
// ()()(()
// (((
// ))
// (){{
// ())))
// ()()(
public class BalancedParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="(()())";
		System.out.println(isBalanced(str));

	}

	private static boolean isBalanced(String expression) {
		
		if(expression.length()%2==1) // if length of expression is odd , it means expression is already imbalanaced
        {
            return false;
        }
        
        Stack<Character> stack=new Stack<Character>();
        
        for(int i=0;i<expression.length();i++)
        {
            char ch=expression.charAt(i);
            
            if(i==0 && (ch=='}' || ch==')' || ch==']')) //if closing bracket is the first character of expression
            {
                return false;
            }
            else
            {
                if(ch=='{' || ch=='(' || ch=='[') //if opening bracket then push character to stack
                {
                    stack.push(ch);
                }
                else
                {
                    if(stack.isEmpty()) //if stack is empty and we are trying to find a match of top of the stack with ch
                    {
                        return false;
                    }
                    else if((stack.peek()=='{' && ch=='}') || (stack.peek()=='[' && ch==']') || (stack.peek()=='(' && ch==')'))
                    {
                        stack.pop();
                    }
                    else //if top of the stack is not a match with character of expression
                    {
                        return false;
                    }
                }
            }
            
        }
        
        if(stack.isEmpty())
            return true;
        else
            return false;
	}

}
