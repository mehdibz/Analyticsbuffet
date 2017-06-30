/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newcompile;

import static com.sun.xml.internal.messaging.saaj.packaging.mime.util.ASCIIUtility.getBytes;
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
 */
public class Support {
    
    void MakeJar() throws FileNotFoundException, IOException{
        FileOutputStream fout = new FileOutputStream("c:\\TEMP\\test.jar");
        JarOutputStream jarOut = new JarOutputStream(fout);
        jarOut.putNextEntry(new ZipEntry("C:\\Users\\Mehdi\\Documents\\NetBeansProjects\\GuiApp1\\src\\app\\")); // Folders must end with "/".
        jarOut.putNextEntry(new ZipEntry("C:\\Users\\Mehdi\\Documents\\NetBeansProjects\\GuiApp1\\src\\app\\GuiApp1.class"));
       // jarOut.write(getBytes("C:\\Users\\Mehdi\\Documents\\NetBeansProjects\\GuiApp1\\src\\app\\GuiApp1.class"));
        jarOut.closeEntry();
        jarOut.close();
        fout.close();
    }
    
    void Compile(String path,String javaFile){
         
        File sourceFile = new File(path, javaFile);
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null,sourceFile.toString());
    }
    
    public void LoadClass(String ClassPath,String ClassFile) throws Exception{
        
        File root = new File(ClassPath);
        File sourceFile = new File(root,ClassFile);

        // Load and instantiate compiled class.
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { sourceFile.toURI().toURL() });
        Class<?> cls = Class.forName("newcompile.NewClass", true, classLoader); 
        Object instance = cls.newInstance(); // "Hello world".
    }
}
