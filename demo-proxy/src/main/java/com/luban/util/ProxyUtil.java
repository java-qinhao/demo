package com.luban.util;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ProxyUtil {

    public static Object proxy(Object target){
        Object proxy=null;
        Class clazz=target.getClass().getInterfaces()[0];
        Method methods[]=clazz.getDeclaredMethods();
        String content="";
        String tab="\t";
        String line="\n";
        String pack="package com.luban;"+line;
        String impor="import "+clazz.getName()+";"+line;
        String a1="public class $Proxy implements "+clazz.getSimpleName()+" { "+line;
        String obj= tab+"private "+clazz.getSimpleName()+" target;"+line;
        String custmer=tab+"public $Proxy("+clazz.getSimpleName()+" target){" +line+
                        tab+tab+"this.target=target;"+line+
                tab+"}"+line;

        String m="";
        for (int i = 0; i < methods.length; i++) {
            String str=tab+"public "+methods[i].getReturnType()+" "+methods[i].getName()+"(){"+line+
                    tab+tab+" System.out.println(\"log\");"+line+
                    tab+tab+"target."+methods[i].getName()+"();"+line
                    +tab+"}"+line;
            m+=str;
        }
        content+=pack+impor+a1+obj+custmer+m+line+"}";
        try {
            File file=new File("E:\\com\\luban\\$Proxy.java");
            if (!file.exists()) {
                file.createNewFile();
            }
            Writer write = new FileWriter(file,true);
            write.write(content);
            write.flush();
            write.close();

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileMgr.getJavaFileObjects(file);
            JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
            t.call();
            fileMgr.close();
            URL[] urls = new URL[]{new URL("file:E:\\\\")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz1 = urlClassLoader.loadClass("com.luban.$Proxy");
            proxy = clazz1.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proxy;
    }
}
