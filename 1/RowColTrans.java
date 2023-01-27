import java.util.*;
class RowColTrans
{
    static String ROWEncryption(String plainText,int depth)throws Exception
    {
     int r=depth,len=plainText.length();
     int c=len/depth;
     char mat[][]=new char[r][c];
     int k=0;
     
     String cipherText="";
     
     for(int i=0;i< c;i++)
     {
      for(int j=0;j< r;j++)
      {
       if(k!=len)
        mat[j][i]=plainText.charAt(k++);
       else
        mat[j][i]='X';
      }
     }
    
     for(int i=0;i< r;i++)
     {
      for(int j=0;j< c;j++)
      {
       cipherText+=mat[i][j];
      }
     }
     System.out.println("\nThe Generated Matrix\n");
     int t=1;
     for(int i=0;i< r;i++)
     {      
      System.out.print(t +" "); 
      t++;
      for(int j=0;j< c;j++)
      {
        System.out.print(mat[i][j]+" ");
      }
      System.out.println();
     }
     return cipherText;
     }
    
    static String ROWDecryption(String cipherText,int depth)throws Exception
     {
      int r=depth,len=cipherText.length();
      int c=len/depth;
      char mat[][]=new char[r][c];
      int k=0;
      
      String plainText="";
      
      
      for(int i=0;i< r;i++)
      {
       for(int j=0;j< c;j++)
       {
        mat[i][j]=cipherText.charAt(k++);
       }
      }
      for(int i=0;i< c;i++)
      {
       for(int j=0;j< r;j++)
       {
        plainText+=mat[j][i];
       }
      }
      
      return plainText;
     }
 static String COLEncryption(String plainText,int depth)throws Exception
 {
  int r=depth,len=plainText.length();
  int c=len/depth;
  char mat[][]=new char[r][c];
  int k=0;
  
  String cipherText="";
  
  for(int i=0;i< r;i++)
  {
   for(int j=0;j< c;j++)
   {
    if(k!=len)
     mat[i][j]=plainText.charAt(k++);
    else
     mat[i][j]='X';
   }
  }
  
  
  for(int i=0;i< c;i++)
  {
   for(int j=0;j< r;j++)
   {
    cipherText+=mat[j][i];
   }
  }

  
  System.out.println("\nThe Generated Matrix\n");
  for(int i=1;i<=c;i++)
  {      
    System.out.print(i+" ");
  }
  System.out.println();
  for(int i=0;i< r;i++)
  {
    for(int j=0;j< c;j++)
    {
      System.out.print(mat[i][j]+" ");
    }
    System.out.println();
   }
  return cipherText;
  }
 
 static String COLDecryption(String cipherText,int depth)throws Exception
  {
   int r=depth,len=cipherText.length();
   int c=len/depth;
   char mat[][]=new char[r][c];
   int k=0;
   
   String plainText="";
   
   
   for(int i=0;i< c;i++)
   {
    for(int j=0;j< r;j++)
    {
     mat[j][i]=cipherText.charAt(k++);
    }
   }
   for(int i=0;i< r;i++)
   {
    for(int j=0;j< c;j++)
    {
     plainText+=mat[i][j];
    }
   }
   
   return plainText;
  }
  
 public static void main(String args[])throws Exception
  {
   
                 Scanner scn=new Scanner(System.in);
                 int depth,choice=0;
   
                 String plainText,cipherText,decryptedText;

                 
                 while(choice!=3)
                 {
                    System.out.println("Press");
                    System.out.println("1. Row Transformation");
                    System.out.println("2. Column Transformation");
                    System.out.println("3. Exit");
                    choice=scn.nextInt();
                    if(choice==1)
                    {
                        scn.nextLine();
                        System.out.println("Enter plain text:");
                        
                        plainText=scn.nextLine();
                        
                        System.out.println("Enter depth for Encryption:");
                        depth=scn.nextInt();
                       
                        cipherText=ROWEncryption(plainText,depth);
                        System.out.println("\n\nEncrypted text is:\n"+cipherText);
                        
                        decryptedText=ROWDecryption(cipherText, depth);
                        
                        System.out.println("\n\nDecrypted text is:\n"+decryptedText);
                        System.out.println("\n\n\n");
                    }
                    else if(choice==2)
                    {
                        scn.nextLine();
                        System.out.println("Enter plain text:");
                        plainText=scn.nextLine();
                        
                        System.out.println("Enter depth for Encryption:");
                        depth=scn.nextInt();
                       
                        cipherText=COLEncryption(plainText,depth);
                        System.out.println("\n\nEncrypted text is:\n"+cipherText);
                        
                        decryptedText=COLDecryption(cipherText, depth);
                        
                        System.out.println("\n\nDecrypted text is:\n"+decryptedText);
                        System.out.println("\n\n\n");
                    }
                    else if(choice==3)
                    {
                        System.out.println("Program Exited\n");
                    }
                    else
                    {
                        System.out.println("Choose a valid choice\n");
                    }

                 } 
  }
}
 