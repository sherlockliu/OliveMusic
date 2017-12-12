/*     */ package com.yougou.mybatis.plugins;
/*     */ 
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.eclipse.core.resources.IFile;
/*     */ import org.eclipse.core.resources.IWorkspace;
/*     */ import org.eclipse.core.runtime.CoreException;
/*     */ import org.eclipse.core.runtime.ILog;
/*     */ import org.eclipse.core.runtime.IProgressMonitor;
/*     */ import org.eclipse.core.runtime.IStatus;
/*     */ import org.eclipse.core.runtime.MultiStatus;
/*     */ import org.eclipse.core.runtime.Status;
/*     */ import org.eclipse.jface.dialogs.ErrorDialog;
/*     */ import org.eclipse.jface.dialogs.ProgressMonitorDialog;
/*     */ import org.eclipse.jface.operation.IRunnableWithProgress;
/*     */ import org.eclipse.jface.wizard.IWizardContainer;
/*     */ import org.eclipse.jface.wizard.IWizardPage;
/*     */ import org.eclipse.jface.wizard.Wizard;
/*     */ import org.eclipse.swt.graphics.RGB;
/*     */ import org.eclipse.swt.widgets.Shell;
/*     */ import org.mybatis.generator.config.Configuration;
/*     */ import org.mybatis.generator.config.Context;
/*     */ import org.mybatis.generator.config.JDBCConnectionConfiguration;
/*     */ import org.mybatis.generator.internal.ObjectFactory;
/*     */ import org.mybatis.generator.internal.db.ConnectionFactory;
/*     */ import org.mybatis.generator.internal.util.ClassloaderUtility;
/*     */ 
/*     */ public class WizardWindow extends Wizard
/*     */ {
/*     */   public WizardPageOne pageOne;
/*     */   public WizardPageTwo pageTwo;
/*  40 */   private Map<String, List<String>> tableMap = null;
/*     */   
/*     */   private IFile selectedFile;
/*     */   
/*     */   private boolean validate;
/*     */   
/*     */   private String message;
/*     */   
/*     */ 
/*     */   public WizardWindow(IFile selectedFile, Configuration config)
/*     */   {
/*  51 */     setWindowTitle("向导");
/*  52 */     setNeedsProgressMonitor(true);
/*  53 */     setTitleBarColor(new RGB(255, 0, 0));
/*  54 */     setWindowTitle("选择表信息");
/*  55 */     this.selectedFile = selectedFile;
/*  56 */     this.validate = loadConn(config);
/*     */   }
/*     */   
/*     */   public boolean isValidate() {
/*  60 */     return this.validate;
/*     */   }
/*     */   
/*     */   public String getMessage() {
/*  64 */     return this.message;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean canFinish()
/*     */   {
/*  70 */     if (getContainer().getCurrentPage() == this.pageTwo) {
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public IWizardPage getNextPage(IWizardPage page)
/*     */   {
/*  79 */     return super.getNextPage(page);
/*     */   }
/*     */   
/*     */   public boolean performCancel()
/*     */   {
/*  84 */     return super.performCancel();
/*     */   }
/*     */   
/*     */   public void addPages()
/*     */   {
/*  89 */     this.pageOne = new WizardPageOne(this.tableMap);
/*  90 */     addPage(this.pageOne);
/*  91 */     this.pageTwo = new WizardPageTwo();
/*  92 */     addPage(this.pageTwo);
/*     */   }
/*     */   
/*     */   private boolean loadConn(Configuration config) {
/*     */     try {
/*  97 */       List<Context> contexts = config.getContexts();
/*  98 */       if (config.getClassPathEntries().size() > 0) {
/*  99 */         ClassLoader classLoader = ClassloaderUtility.getCustomClassloader(config
/* 100 */           .getClassPathEntries());
/* 101 */         ObjectFactory.addExternalClassLoader(classLoader);
/*     */       } else {
/* 103 */         this.message = "The xml file is invalid.";
/* 104 */         Tools.writeLine(this.message);
/* 105 */         return false;
/*     */       }
/* 107 */       if ((contexts != null) && (contexts.size() > 0) && 
/* 108 */         (contexts.get(0) != null)) {
/* 109 */         JDBCConnectionConfiguration jdbcConfig = ((Context)contexts.get(0))
/* 110 */           .getJdbcConnectionConfiguration();
/* 111 */         Connection con = null;
/*     */         try {
/* 113 */           con = ConnectionFactory.getInstance().getConnection(
/* 114 */             jdbcConfig);
/*     */           
/* 116 */           DatabaseMetaData meta = con.getMetaData();
/* 117 */           ResultSet rs = meta.getTables(null, null, null, 
/* 118 */             new String[] { "TABLE" });
/* 119 */           this.tableMap = new HashMap();
/* 120 */           while (rs.next()) {
/* 121 */             if ((rs.getString(1) != null) && 
/* 122 */               (this.tableMap.get(rs.getString(1)) == null)) {
/* 123 */               List<String> tableList = new ArrayList();
/* 124 */               tableList.add(rs.getString(3));
/* 125 */               this.tableMap.put(rs.getString(1), tableList);
/* 126 */             } else if (rs.getString(1) != null) {
/* 127 */               ((List)this.tableMap.get(rs.getString(1))).add(rs.getString(3));
/*     */             }
/* 129 */             if ((rs.getString(2) != null) && 
/* 130 */               (this.tableMap.get(rs.getString(2)) == null)) {
/* 131 */               List<String> tableList = new ArrayList();
/* 132 */               tableList.add(rs.getString(3));
/* 133 */               this.tableMap.put(rs.getString(2), tableList);
/* 134 */             } else if (rs.getString(2) != null) {
/* 135 */               ((List)this.tableMap.get(rs.getString(2))).add(rs.getString(3));
/*     */             }
/*     */           }
/* 138 */           con.close();
/* 139 */           return true;
/*     */         } catch (Exception e) {
/*     */           try {
/* 142 */             if (con != null)
/* 143 */               con.close();
/*     */           } catch (SQLException e1) {
/* 145 */             this.message = e1.getLocalizedMessage();
/* 146 */             Tools.writeLine(this.message);
/*     */           }
/* 148 */           this.message = e.getLocalizedMessage();
/* 149 */           Tools.writeLine(this.message);
/* 150 */           return false;
/*     */         }
/*     */       }
/* 153 */       this.message = "The xml file is incorrect.";
/* 154 */       Tools.writeLine(this.message);
/* 155 */       return false;
/*     */     }
/*     */     catch (Exception e) {
/* 158 */       this.message = ("init connection error:" + e.getMessage());
/* 159 */       Tools.writeLine(this.message); }
/* 160 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean performFinish()
/*     */   {
/* 166 */     Shell shell = getShell();
/*     */     try {
/* 168 */       List<String> warnings = new ArrayList();
/* 169 */       ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
/*     */       
/* 171 */       Map<CodeLayoutEnum, Boolean> codeLayoutSwitch = this.pageTwo
/* 172 */         .getCodeLayoutMap();
/* 173 */       String codeVersion = this.pageTwo.getCodeVersion();
/* 174 */       if (codeLayoutSwitch.size() == 0) {
/* 175 */         codeLayoutSwitch.put(CodeLayoutEnum.SERVICE_LAYOUT, Boolean.valueOf(false));
/* 176 */         codeLayoutSwitch.put(CodeLayoutEnum.MANAGER_LAYOUT, Boolean.valueOf(false));
/* 177 */         codeLayoutSwitch.put(CodeLayoutEnum.CONTROLLER_LAYOUT, Boolean.valueOf(false));
/*     */       }
/*     */       
/* 180 */       IRunnableWithProgress thread = new GeneratorRunner(warnings, 
/* 181 */         this.pageOne.getTableList(), codeLayoutSwitch, codeVersion);
/*     */       
/* 183 */       dialog.run(true, false, thread);
/*     */       
/* 185 */       if (warnings.size() > 0) {
/* 186 */         MultiStatus ms = new MultiStatus("org.mybatis.generator.eclipse.ui", 
/* 187 */           2, "Generation Warnings Occured", null);
/*     */         
/* 189 */         Iterator<String> iter = warnings.iterator();
/* 190 */         while (iter.hasNext()) {
/* 191 */           Status status = new Status(2, 
/* 192 */             "org.mybatis.generator.eclipse.ui", 2, (String)iter.next(), 
/* 193 */             null);
/* 194 */           ms.add(status);
/*     */         }
/*     */         
/* 197 */         ErrorDialog.openError(shell, "MyBatis Generator", 
/* 198 */           "Run Complete With Warnings", ms, 2);
/*     */       }
/*     */     } catch (Exception e) {
/* 201 */       e.printStackTrace();
/* 202 */       handleException(e, shell);
/*     */     }
/*     */     
/* 205 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private class GeneratorRunner
/*     */     implements IRunnableWithProgress
/*     */   {
/*     */     private List<String> warnings;
/*     */     
/*     */     private List<String> tableList;
/*     */     
/*     */     private Map<CodeLayoutEnum, Boolean> codeLayout;
/*     */     
/*     */     private String codeVersion;
/*     */     
/*     */     public GeneratorRunner(List<String> warnings, Map<CodeLayoutEnum, Boolean> tableList, String codeLayout)
/*     */     {
/* 222 */       this.warnings = warnings;
/* 223 */       this.tableList = tableList;
/* 224 */       this.codeLayout = codeLayout;
/* 225 */       this.codeVersion = codeVersion;
/*     */     }
/*     */     
/*     */     public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException
/*     */     {
/*     */       try {
/* 231 */         RunGeneratorThread thread = new RunGeneratorThread(
/* 232 */           WizardWindow.this.selectedFile, this.warnings, this.tableList, this.codeLayout, 
/* 233 */           this.codeVersion);
/*     */         
/* 235 */         org.eclipse.core.resources.ResourcesPlugin.getWorkspace().run(thread, monitor);
/*     */       } catch (CoreException e) {
/* 237 */         throw new InvocationTargetException(e);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void handleException(Exception exception, Shell shell)
/*     */   {
/*     */     Throwable exceptionToHandle;
/*     */     Throwable exceptionToHandle;
/* 246 */     if ((exception instanceof InvocationTargetException)) {
/* 247 */       exceptionToHandle = 
/* 248 */         ((InvocationTargetException)exception).getCause();
/*     */     } else
/* 250 */       exceptionToHandle = exception;
/*     */     IStatus status;
/*     */     IStatus status;
/* 253 */     if ((exceptionToHandle instanceof InterruptedException)) {
/* 254 */       status = new Status(8, "org.mybatis.generator.eclipse.ui", 
/* 255 */         8, "Cancelled by User", exceptionToHandle); } else { IStatus status;
/* 256 */       if ((exceptionToHandle instanceof CoreException)) {
/* 257 */         status = ((CoreException)exceptionToHandle).getStatus();
/*     */       } else {
/* 259 */         String message = "Unexpected error while running MyBatis Generator.";
/*     */         
/* 261 */         status = new Status(4, "org.mybatis.generator.eclipse.ui", 
/* 262 */           4, message, exceptionToHandle);
/*     */         
/* 264 */         Activator.getDefault().getLog().log(status);
/*     */       }
/*     */     }
/* 267 */     ErrorDialog.openError(shell, "MyBatis Generator", "Generation Failed", 
/* 268 */       status, 12);
/*     */   }
/*     */ }


/* Location:              C:\Users\user\Desktop\com.yougou.mybatis.plugin_1.3.2.jar!\com\yougou\mybatis\plugins\WizardWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */