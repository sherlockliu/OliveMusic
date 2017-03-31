/*     */ package com.yougou.mybatis.plugins;
/*     */ 
/*     */ import com.yougou.mybatis.plugins.function.FindJar;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.eclipse.core.resources.IFile;
/*     */ import org.eclipse.core.resources.IWorkspace;
/*     */ import org.eclipse.core.resources.ResourcesPlugin;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.eclipse.jdt.internal.core.JarPackageFragmentRoot;
/*     */ import org.eclipse.jface.action.IAction;
/*     */ import org.eclipse.jface.dialogs.MessageDialog;
/*     */ import org.eclipse.jface.viewers.ISelection;
/*     */ import org.eclipse.jface.viewers.StructuredSelection;
/*     */ import org.eclipse.swt.graphics.Rectangle;
/*     */ import org.eclipse.swt.widgets.Display;
/*     */ import org.eclipse.swt.widgets.Shell;
/*     */ import org.eclipse.ui.IObjectActionDelegate;
/*     */ import org.eclipse.ui.IWorkbenchPart;
/*     */ import org.eclipse.ui.IWorkbenchPartSite;
/*     */ import org.mybatis.generator.config.Configuration;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.config.JDBCConnectionConfiguration;
/*     */ import org.mybatis.generator.config.xml.ConfigurationParser;
/*     */ import org.mybatis.generator.eclipse.ui.content.ConfigurationFileAdapter;
/*     */ import org.mybatis.generator.exception.XMLParserException;
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
/*     */ public class PopAction
/*     */   implements IObjectActionDelegate
/*     */ {
/*     */   private IFile selectedFile;
/*     */   private Shell shell;
/*     */   public static Map<String, IPath> cacheDriverPathMap;
/*     */   
/*     */   public void setActivePart(IAction action, IWorkbenchPart targetPart)
/*     */   {
/*  55 */     this.shell = targetPart.getSite().getShell();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void run(IAction action)
/*     */   {
/*  62 */     String message = "The xml file is incorrect,";
/*  63 */     IPath rawPath = this.selectedFile.getRawLocation();
/*  64 */     File configurationFile = rawPath.toFile();
/*  65 */     ConfigurationParser cp = new ConfigurationParser(null);
/*  66 */     Tools.writeLine("config file:" + 
/*  67 */       configurationFile.getAbsolutePath());
/*  68 */     Configuration config = null;
/*     */     try {
/*  70 */       config = cp.parseConfiguration(configurationFile);
/*  71 */       System.out.println(config.getClassPathEntries());
/*  72 */       if ((config.getClassPathEntries().size() == 0) && (config.getContexts().size() > 0)) {
/*  73 */         for (Context c : config.getContexts()) {
/*  74 */           JDBCConnectionConfiguration connConfig = c.getJdbcConnectionConfiguration();
/*  75 */           if (connConfig != null) {
/*  76 */             if (cacheDriverPathMap == null) {
/*  77 */               cacheDriverPathMap = new HashMap();
/*     */             }
/*  79 */             String driverClassName = connConfig.getDriverClass().toString();
/*  80 */             IPath path = null;
/*  81 */             if (cacheDriverPathMap.get(driverClassName) != null) {
/*  82 */               path = (IPath)cacheDriverPathMap.get(driverClassName);
/*     */               
/*  84 */               if ((path != null) && (!path.toFile().exists())) {
/*  85 */                 path = findDriverJar(driverClassName);
/*     */               }
/*     */             } else {
/*  88 */               path = findDriverJar(driverClassName);
/*     */             }
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  95 */             if (path == null) {
/*  96 */               MessageDialog.openError(this.shell, "提醒", "未找到驱动包");
/*  97 */               return;
/*     */             }
/*     */             
/* 100 */             cacheDriverPathMap.put(driverClassName, path);
/* 101 */             config.getClassPathEntries().add(path.toString());
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (IOException e) {
/* 106 */       message = message + e.getMessage();
/* 107 */       Tools.writeLine(message);
/* 108 */       e.printStackTrace();
/*     */     } catch (XMLParserException e) {
/* 110 */       message = message + e.getMessage();
/* 111 */       Tools.writeLine(message);
/* 112 */       e.printStackTrace();
/*     */     }
/*     */     
/* 115 */     createWizrd(config);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private IPath findDriverJar(String driverClassName)
/*     */   {
/* 124 */     IWorkspace workspace = ResourcesPlugin.getWorkspace();
/* 125 */     JarPackageFragmentRoot driverJar = FindJar.findDrvierJar(workspace, driverClassName);
/* 126 */     return driverJar == null ? null : driverJar.getPath();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void createWizrd(Configuration config)
/*     */   {
/*     */     try
/*     */     {
/* 135 */       WizardWindow w = new WizardWindow(this.selectedFile, config);
/* 136 */       if (!w.isValidate()) {
/* 137 */         MessageDialog.openError(this.shell, "提醒", "配置文件有问题，请检查下列配置:\n" + w.getMessage());
/* 138 */         return;
/*     */       }
/*     */       
/* 141 */       WizardDialogExt dialog = new WizardDialogExt(this.shell, w);
/* 142 */       dialog.setPageSize(550, 450);
/* 143 */       dialog.create();
/*     */       
/* 145 */       Rectangle screenSize = Display.getDefault().getClientArea();
/* 146 */       Shell shell = dialog.getShell();
/* 147 */       shell.setLocation((screenSize.width - dialog.getShell().getBounds().width) / 2, (
/* 148 */         screenSize.height - dialog.getShell().getBounds().height) / 2);
/* 149 */       dialog.open();
/*     */     } catch (Exception e) {
/* 151 */       Tools.writeLine("show window is error:" + e.getMessage());
/* 152 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void selectionChanged(IAction action, ISelection selection)
/*     */   {
/* 160 */     StructuredSelection ss = (StructuredSelection)selection;
/* 161 */     ConfigurationFileAdapter adapter = new ConfigurationFileAdapter((IFile)ss.getFirstElement());
/* 162 */     if (adapter != null) {
/* 163 */       this.selectedFile = adapter.getBaseFile();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\user\Desktop\com.yougou.mybatis.plugin_1.3.2.jar!\com\yougou\mybatis\plugins\PopAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */