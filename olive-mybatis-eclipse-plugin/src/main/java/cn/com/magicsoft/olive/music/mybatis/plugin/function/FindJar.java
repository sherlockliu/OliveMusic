/*     */ package com.yougou.mybatis.plugins.function;
/*     */ 
/*     */ import com.yougou.mybatis.plugins.Tools;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.eclipse.core.resources.IProject;
/*     */ import org.eclipse.core.resources.IWorkspace;
/*     */ import org.eclipse.core.resources.IWorkspaceRoot;
/*     */ import org.eclipse.jdt.core.IClassFile;
/*     */ import org.eclipse.jdt.core.IClasspathContainer;
/*     */ import org.eclipse.jdt.core.IClasspathEntry;
/*     */ import org.eclipse.jdt.core.IJavaElement;
/*     */ import org.eclipse.jdt.core.IJavaProject;
/*     */ import org.eclipse.jdt.core.IPackageFragmentRoot;
/*     */ import org.eclipse.jdt.core.JavaCore;
/*     */ import org.eclipse.jdt.core.JavaModelException;
/*     */ import org.eclipse.jdt.internal.core.JarPackageFragmentRoot;
/*     */ import org.eclipse.jdt.internal.core.PackageFragment;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FindJar
/*     */ {
/*     */   private static final String DOT = ".";
/*     */   
/*     */   public static List<IJavaProject> findProject(IWorkspace workspace)
/*     */   {
/*  42 */     IProject[] projects = workspace.getRoot().getProjects();
/*  43 */     if (projects != null) {
/*  44 */       List<IJavaProject> jProjects = new ArrayList(projects.length);
/*  45 */       IProject[] arrayOfIProject1; int j = (arrayOfIProject1 = projects).length; for (int i = 0; i < j; i++) { IProject p = arrayOfIProject1[i];
/*     */         
/*  47 */         IJavaProject jProject = JavaCore.create(p);
/*     */         
/*  49 */         if ((jProject != null) && (jProject.exists()))
/*     */         {
/*  51 */           jProjects.add(jProject);
/*     */         }
/*     */       }
/*  54 */       return jProjects;
/*     */     }
/*  56 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<JarPackageFragmentRoot> findAllJar(IJavaProject jProject)
/*     */   {
/*     */     try
/*     */     {
/*  67 */       IPackageFragmentRoot[] jars = jProject.getAllPackageFragmentRoots();
/*  68 */       if (jars != null) {
/*  69 */         List<JarPackageFragmentRoot> jarList = new ArrayList();
/*  70 */         IPackageFragmentRoot[] arrayOfIPackageFragmentRoot1; int j = (arrayOfIPackageFragmentRoot1 = jars).length; for (int i = 0; i < j; i++) { IPackageFragmentRoot ele = arrayOfIPackageFragmentRoot1[i];
/*     */           
/*  72 */           if ((ele instanceof JarPackageFragmentRoot))
/*     */           {
/*  74 */             JarPackageFragmentRoot jarFile = (JarPackageFragmentRoot)ele;
/*     */             
/*     */ 
/*     */ 
/*  78 */             IClasspathEntry rawClasspathEntry = jarFile.getRawClasspathEntry();
/*  79 */             IClasspathContainer classpathContainer = JavaCore.getClasspathContainer(
/*  80 */               rawClasspathEntry.getPath(), jProject);
/*     */             
/*  82 */             if (classpathContainer.getKind() != 3)
/*     */             {
/*  84 */               jarList.add(jarFile);
/*     */             }
/*     */           }
/*     */         }
/*  88 */         return jarList;
/*     */       }
/*     */     } catch (JavaModelException e) {
/*  91 */       e.printStackTrace();
/*     */     }
/*  93 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static JarPackageFragmentRoot findDrvierJar(IWorkspace workspace, String driverClassName)
/*     */   {
/* 103 */     List<IJavaProject> projects = findProject(workspace);
/* 104 */     if (projects != null) {
/* 105 */       List<JarPackageFragmentRoot> jarList = new ArrayList();
/* 106 */       for (IJavaProject iJavaProject : projects) {
/* 107 */         jarList.addAll(findAllJar(iJavaProject));
/*     */       }
/* 109 */       if (jarList.size() > 0)
/*     */       {
/* 111 */         boolean flag = false;
/* 112 */         for (JarPackageFragmentRoot jar : jarList) {
/* 113 */           flag = existsClassFile(jar, driverClassName);
/* 114 */           if (flag) {
/* 115 */             String msg = MessageFormat.format("已自动找到驱动,驱动包路径:{0}", new Object[] { jar.getPath() });
/* 116 */             Tools.writeLine(msg);
/* 117 */             return jar;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 122 */     return null;
/*     */   }
/*     */   
/*     */   private static boolean existsClassFile(JarPackageFragmentRoot jarFile, String driverClassName) {
/* 126 */     if (("".equals(driverClassName)) || (driverClassName == null))
/* 127 */       return false;
/*     */     try {
/* 129 */       IJavaElement[] children = jarFile.getChildren();
/* 130 */       if (children != null) {
/* 131 */         String packageName = driverClassName.substring(0, driverClassName.lastIndexOf("."));
/*     */         IJavaElement[] arrayOfIJavaElement1;
/* 133 */         int j = (arrayOfIJavaElement1 = children).length; for (int i = 0; i < j; i++) { IJavaElement ele = arrayOfIJavaElement1[i];
/* 134 */           if ((ele instanceof PackageFragment))
/*     */           {
/* 136 */             if (ele.getElementName().equals(packageName)) {
/* 137 */               IJavaElement[] classes = ((PackageFragment)ele).getChildren();
/*     */               IJavaElement[] arrayOfIJavaElement2;
/* 139 */               int m = (arrayOfIJavaElement2 = classes).length; for (int k = 0; k < m; k++) { IJavaElement cls = arrayOfIJavaElement2[k];
/* 140 */                 if ((cls instanceof IClassFile))
/*     */                 {
/* 142 */                   String cName = cls.getElementName();
/* 143 */                   String className = ele.getElementName() + "." + cName.substring(0, cName.indexOf("."));
/* 144 */                   if (className.equals(driverClassName)) {
/* 145 */                     return true;
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (JavaModelException e) {
/* 154 */       e.printStackTrace();
/*     */     }
/* 156 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\user\Desktop\com.yougou.mybatis.plugin_1.3.2.jar!\com\yougou\mybatis\plugins\function\FindJar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */