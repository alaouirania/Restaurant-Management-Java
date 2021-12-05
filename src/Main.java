/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ritesh
 */
public class Main {
    String category,dishname;

    public Main() {
         //System.out.println("hello");
    }
   
   
   
  

   

    Main( String category, String dishname) {
       
       this.dishname=dishname;
       this.category=category;
       
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
   String getCategory(){
       return category;
       
   }
   String getDishname(){
       return dishname;
   }
  
    
}
