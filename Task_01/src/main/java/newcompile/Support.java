package newcompile;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
*
* @author Mehdi
* Contain 3 method : 
* 	Compiling Java file,
* 	Loading Java class,
* 	Making JarFile. 
*/
public class Support {
	//The destination of JAR file is located in the same Class folder.
    public void MakeJar(String ClassFile, String ClassPath,String JarOutPath) throws FileNotFoundException, IOException{
    	
    	try{
            FileOutputStream fout = new FileOutputStream(JarOutPath + "Test.jar");
            JarOutputStream jarOut = new JarOutputStream(fout);
            jarOut.putNextEntry(new ZipEntry(ClassPath)); // Folders must end with "/".
            jarOut.putNextEntry(new ZipEntry(ClassFile));
            jarOut.write((ClassFile).getBytes());
            jarOut.closeEntry();
            jarOut.close();
            fout.close();
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
    
    
    //The destination of compiled classes is located in the same Java folder.
    public void Compile(String javaFile)throws FileNotFoundException, IOException{
         
    	try{
            File sourceFile = new File(javaFile);
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            compiler.run(null, null, null,sourceFile.getPath());
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
    
    //Load and instantiate compiled class from class folder.
    public void LoadClass(String ClassFile) throws Exception{
        
    	try{
        	File sourceFile = new File(ClassFile);
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { sourceFile.toURI().toURL() });
            Class<?> cls = Class.forName("newcompile.NewClass", true, classLoader); 
            cls.newInstance(); // "Hello world".
        }
        catch(Exception e){
        	System.out.println(e);
        }

    }
}
