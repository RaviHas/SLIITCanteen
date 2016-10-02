/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

/**
 *
 * @author Ravindu
 */
public class Validation {
    
    public boolean isEmpty(String text) {
        if("".equals(text))
            return true;
        else
            return false;
    }
    
    
    public boolean isString(String str){
      for(int i=0; i<str.length();i++){
          if(!Character.isLetter(str.charAt(i)) && !(str.charAt(i)==' '))
              return false;
      }  
      return true;
    }
    
    
    public boolean isDigit(String str){
      for(int i=0; i<str.length();i++){
          if(!Character.isDigit(str.charAt(i)))
              return false;
      } 
      return true; 
    }
    
    
    public boolean isEmail(String str )
    {
      if(str.endsWith(".com"))
      {
          if(str.indexOf("@")>0)
          {
              int indexOfAt=str.indexOf("@");
              int indexOfDot=str.indexOf(".");
              String a=str.substring(indexOfAt+1, indexOfDot);
              if (a.equals("."))
                  return false;
              else
                  return true;
         }
          else
          return false;      
      }
      return false;
    }
    
    
    public boolean isPhone(String phone)
    {
            if(phone.matches("\\d{10}"))
                return true;
            else
                return false;
    }
    
    public boolean isNIC(String nic)
    {
           if(nic.matches("^[0-9]{9}[vVxX]$"))
                return true;
           else
                return false;
    }
    
    
     
}
