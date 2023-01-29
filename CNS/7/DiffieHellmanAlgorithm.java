package CNS;

import java.util.*;                                                               

public class DiffieHellmanAlgorithm 
{  
   public static void main(String args)
   {
       long P,G,a,b,x,y,ka,kb;
       Scanner in = new Scanner(System.in);
       System.out.println("Enter the Public key for P");
       G = in.nextLong();
       System.out.println("Enter the Public key for G");
       P = in.nextLong();
       System.out.println("Enter the Private key for User 1");
       a = in.nextLong();
       System.out.println("Enter the Private key for User 2");
       b = in.nextLong();
       
       x = calculatePow(G,a,P);
       y = calculatePow(G,b,P);
       
       ka = calculatePow(y,a,P);
       kb = calculatePow(x,b,P);
       
       System.out.println("Secret key for User 1 : "+ka);
       System.out.println("Secret key for User 2 : "+kb);
   }

    private static long calculatePow(long x, long y, long P) 
    {
        long result=0;
        if(y==1)
        {
            return x;
        }
        else
        {
            result = ((long)Math.pow(x,y))%P;
        }
        return result;
    }
    
} 