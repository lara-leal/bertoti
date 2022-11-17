import java.io.*;  

public class Main{  
    private static int  escolha;  
    public static void main(String args[]) throws NumberFormatException, IOException{  
        do{       
            System.out.print("========= Loja de roupa ============ \n");  
            System.out.print("            1. Calça.              \n");  
            System.out.print("            2. Vestido.              \n");  
            System.out.print("            3. Tênis.            \n");  
            System.out.print("            4. Exit.                     \n");  
            System.out.print("Escolha o produto: ");  
              
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));  
            escolha =Integer.parseInt(br.readLine());  
            Vendedor ven = new Vendedor();  
              
            switch (escolha) {  
            case 1:  
                {   
                  ven.VenderCalca();  
                    }  
                break;  
       case 2:  
                {  
                  ven.VenderVestido();      
                    }  
                break;    
       case 3:  
                           {  
                           ven.VenderTenis();       
                           }  
                   break;     
            default:  
            {    
                System.out.println("Você saiu da loja!");  
            }         
                return;  
            }  
              
      }while(escolha!=4);  
   }  
}  