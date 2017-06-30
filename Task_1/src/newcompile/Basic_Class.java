/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newcompile;


public class Basic_Class {
    

    public static void main(String[] args) throws Exception {
                
            final String path = "C:\\Users\\Mehdi\\Documents\\NetBeansProjects\\NewCompile\\src\\newcompile";
            final String javaFile = "NewClass.java";
            final String classFile = "NewClass.class";
            
            Support obj = new Support();
            obj.Compile(path,javaFile);
            obj.LoadClass(path,classFile);
        }
}


