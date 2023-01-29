package CNS;


import java.util.*;
public class RailFence 
{    
    private static String Encryption(String plaintext, int depth)throws Exception
    {
        int r = depth,c = plaintext.length()/depth;
        char mat[][] = new char[r][c];
        int k=0;
        String ciphertext="";        
        for(int i=0;i<c;i++)
        {
            for(int j=0;j<r;j++)
            {
                if(k!=plaintext.length())
                {
                    mat[j][i]=plaintext.charAt(k++);
                }
                else
                {
                    mat[j][i]='X';
                }
            }
        }
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                ciphertext+=mat[i][j];
            }
        }
        return ciphertext;
    }
    private static String Decryption(String ciphertext,int depth)throws Exception
    {
        int r = depth,c = ciphertext.length()/depth;
        char mat[][] = new char[r][c];
        int k=0;
        String plaintext="";        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(k!=ciphertext.length())
                {
                    mat[i][j]=ciphertext.charAt(k++);
                }
                else
                {
                    mat[i][j]='X';
                }
            }
        }
        for(int i=0;i<c;i++)
        {
            for(int j=0;j<r;j++)
            {
                plaintext+=mat[j][i];
            }
        }
        return plaintext;
    }    
    public static void main(String ards[])throws Exception
    {
        Scanner in = new Scanner(System.in);        
        System.out.println("Enter the Plain text");
        String plaintext,ciphertext,decrypttext;
        plaintext = in.nextLine();
        System.out.println("Enter the Depth");
        int depth;
        depth = in.nextInt();        
        ciphertext = Encryption(plaintext,depth);
        System.out.println("The ENCRYPT text :"+ciphertext);         
        decrypttext=Decryption(ciphertext,depth);
        System.out.println("The DECRYPT text :"+decrypttext);
    }   
}
