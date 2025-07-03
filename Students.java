package com.Parth;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Students {
   
   @Id
   private int rollNumber;
   private String name;
   private String programme;
   
   public int getrollNumber(){
       return rollNumber;
   }
   public void setrollNumber(int rollNumber){
        this.rollNumber = rollNumber;
   }
   
   public String getname(){
       return name;
   }
   public void setname(String name){
       this.name = name;
   }
   
   public String getprogramme(){
       return programme;
   }
   public void setprogramme(String programme){
       this.programme = programme;
   }
}
