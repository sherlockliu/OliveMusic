/*    */ package com.yougou.mybatis.plugins;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.eclipse.ui.console.ConsolePlugin;
/*    */ import org.eclipse.ui.console.IConsole;
/*    */ import org.eclipse.ui.console.IConsoleManager;
/*    */ import org.eclipse.ui.console.MessageConsole;
/*    */ import org.eclipse.ui.console.MessageConsoleStream;
/*    */ import org.mybatis.generator.config.Context;
/*    */ import org.mybatis.generator.config.TableConfiguration;
/*    */ import org.mybatis.generator.internal.util.StringUtility;
/*    */ 
/*    */ 
/*    */ public class Tools
/*    */ {
/* 16 */   private static MessageConsoleStream consoleStream = null;
/*    */   
/* 18 */   static { IConsoleManager consoleManager = ConsolePlugin.getDefault().getConsoleManager();
/* 19 */     IConsole[] consoles = consoleManager.getConsoles();
/* 20 */     if ((consoles != null) && (consoles.length > 0)) {
/* 21 */       IConsole console = consoles[0];
/* 22 */       if ((console instanceof MessageConsole)) {
/* 23 */         consoleStream = ((MessageConsole)console).newMessageStream();
/*    */       }
/*    */     }
/*    */     else {
/* 27 */       MessageConsole console = new MessageConsole("aotuMybatis", null);
/*    */       
/* 29 */       consoleManager.addConsoles(new IConsole[] { console });
/*    */       
/*    */ 
/* 32 */       consoleStream = console.newMessageStream();
/*    */       
/* 34 */       consoleManager.showConsoleView(console);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void writeLine(String message) {
/* 39 */     if (consoleStream != null) {
/* 40 */       consoleStream.println(message);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void writeLine() {
/* 45 */     if (consoleStream != null) {
/* 46 */       consoleStream.println();
/*    */     }
/*    */   }
/*    */   
/*    */   public static String formatRelativePath(String linkPath, String relativePath) throws Exception {
/* 51 */     if ((linkPath == null) || (relativePath == null) || ("".equals(relativePath.trim()))) {
/* 52 */       return linkPath;
/*    */     }
/* 54 */     if (linkPath.substring(linkPath.length() - 1, linkPath.length()).equals(File.separator)) {
/* 55 */       linkPath = linkPath.substring(0, linkPath.length() - 1);
/*    */     }
/* 57 */     relativePath = relativePath.replace("\\", "/");
/* 58 */     if (relativePath.indexOf("/") < 0) {
/* 59 */       relativePath = "/" + relativePath;
/*    */     }
/* 61 */     int index = relativePath.indexOf("../");
/* 62 */     while (index >= 0) {
/* 63 */       int _index = linkPath.lastIndexOf(File.separator);
/* 64 */       if (_index < 0) {
/* 65 */         throw new Exception("The relativePath is incorrect base on linkPath. ");
/*    */       }
/* 67 */       linkPath = linkPath.substring(0, _index);
/* 68 */       relativePath = relativePath.substring(index + 2);
/* 69 */       index = relativePath.indexOf("../");
/*    */     }
/* 71 */     String realPath = (linkPath + relativePath).replace("/", File.separator);
/* 72 */     File file = new File(realPath);
/* 73 */     if (!file.exists()) {
/* 74 */       boolean r = file.mkdir();
/* 75 */       if (!r) {
/* 76 */         r = file.mkdirs();
/*    */       }
/*    */     }
/* 79 */     return realPath;
/*    */   }
/*    */   
/*    */   public static void parseTable(Context context, String tableName)
/*    */   {
/* 84 */     if (StringUtility.stringHasValue(tableName)) {
/* 85 */       TableConfiguration tc = new TableConfiguration(context);
/* 86 */       context.addTableConfiguration(tc);
/* 87 */       tc.setTableName(tableName);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\user\Desktop\com.yougou.mybatis.plugin_1.3.2.jar!\com\yougou\mybatis\plugins\Tools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */