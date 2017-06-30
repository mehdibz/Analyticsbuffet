package newcompile;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
*
* @author Mehdi
*  
*/

public class Basic_Class {
    

    public static void main(String[] args) throws Exception {
                
            final String javaFile   = ".\\src\\main\\java\\newcompile\\NewClass.java";
            final String classFile  = ".\\target\\classes\\NewClass.class";
            final String classPath  = ".\\target\\classes\\";
            final String JarOutPath = ".\\target\\classes\\";
            
            Support obj = new Support();
            obj.Compile(javaFile);
            obj.LoadClass(classFile);
            obj.MakeJar(classFile, classPath, JarOutPath);
        }
 
}


