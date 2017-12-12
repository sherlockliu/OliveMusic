/*     */ package com.yougou.mybatis.plugins;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.eclipse.core.resources.IFile;
/*     */ import org.eclipse.core.resources.IProject;
/*     */ import org.eclipse.core.resources.IResource;
/*     */ import org.eclipse.core.resources.IWorkspace;
/*     */ import org.eclipse.core.resources.IWorkspaceRoot;
/*     */ import org.eclipse.core.resources.IWorkspaceRunnable;
/*     */ import org.eclipse.core.resources.ResourcesPlugin;
/*     */ import org.eclipse.core.runtime.CoreException;
/*     */ import org.eclipse.core.runtime.IPath;
/*     */ import org.eclipse.jdt.core.IClasspathEntry;
/*     */ import org.eclipse.jdt.core.IJavaProject;
/*     */ import org.eclipse.jdt.core.JavaCore;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RunGeneratorThread
/*     */   implements IWorkspaceRunnable
/*     */ {
/*     */   private IFile inputFile;
/*     */   private List<String> warnings;
/*     */   private ClassLoader oldClassLoader;
/*     */   private List<String> tableList;
/*     */   private Map<CodeLayoutEnum, Boolean> codeLayout;
/*     */   private String codeVersion;
/*     */   
/*     */   public RunGeneratorThread(IFile inputFile, List<String> warnings, List<String> tableList, Map<CodeLayoutEnum, Boolean> codeLayout, String codeVersion)
/*     */   {
/*  73 */     this.inputFile = inputFile;
/*  74 */     this.warnings = warnings;
/*  75 */     this.tableList = tableList;
/*  76 */     this.codeLayout = codeLayout;
/*  77 */     this.codeVersion = codeVersion;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void run(org.eclipse.core.runtime.IProgressMonitor monitor)
/*     */     throws CoreException
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: sipush 1000
/*     */     //   4: invokestatic 48	org/eclipse/core/runtime/SubMonitor:convert	(Lorg/eclipse/core/runtime/IProgressMonitor;I)Lorg/eclipse/core/runtime/SubMonitor;
/*     */     //   7: astore_2
/*     */     //   8: aload_2
/*     */     //   9: ldc 54
/*     */     //   11: sipush 1000
/*     */     //   14: invokevirtual 56	org/eclipse/core/runtime/SubMonitor:beginTask	(Ljava/lang/String;I)V
/*     */     //   17: aload_0
/*     */     //   18: invokespecial 60	com/yougou/mybatis/plugins/RunGeneratorThread:setClassLoader	()V
/*     */     //   21: aload_2
/*     */     //   22: ldc 63
/*     */     //   24: invokevirtual 65	org/eclipse/core/runtime/SubMonitor:subTask	(Ljava/lang/String;)V
/*     */     //   27: new 69	org/mybatis/generator/config/xml/ConfigurationParser
/*     */     //   30: dup
/*     */     //   31: aload_0
/*     */     //   32: getfield 30	com/yougou/mybatis/plugins/RunGeneratorThread:warnings	Ljava/util/List;
/*     */     //   35: invokespecial 71	org/mybatis/generator/config/xml/ConfigurationParser:<init>	(Ljava/util/List;)V
/*     */     //   38: astore_3
/*     */     //   39: aload_3
/*     */     //   40: new 74	org/xml/sax/InputSource
/*     */     //   43: dup
/*     */     //   44: new 76	java/io/FileReader
/*     */     //   47: dup
/*     */     //   48: aload_0
/*     */     //   49: getfield 28	com/yougou/mybatis/plugins/RunGeneratorThread:inputFile	Lorg/eclipse/core/resources/IFile;
/*     */     //   52: invokeinterface 78 1 0
/*     */     //   57: invokeinterface 84 1 0
/*     */     //   62: invokespecial 90	java/io/FileReader:<init>	(Ljava/io/File;)V
/*     */     //   65: invokespecial 93	org/xml/sax/InputSource:<init>	(Ljava/io/Reader;)V
/*     */     //   68: aload_0
/*     */     //   69: getfield 32	com/yougou/mybatis/plugins/RunGeneratorThread:tableList	Ljava/util/List;
/*     */     //   72: aload_0
/*     */     //   73: getfield 34	com/yougou/mybatis/plugins/RunGeneratorThread:codeLayout	Ljava/util/Map;
/*     */     //   76: aload_0
/*     */     //   77: getfield 36	com/yougou/mybatis/plugins/RunGeneratorThread:codeVersion	Ljava/lang/String;
/*     */     //   80: invokevirtual 96	org/mybatis/generator/config/xml/ConfigurationParser:parseConfiguration	(Lorg/xml/sax/InputSource;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)Lorg/mybatis/generator/config/Configuration;
/*     */     //   83: astore 4
/*     */     //   85: aload 4
/*     */     //   87: invokevirtual 100	org/mybatis/generator/config/Configuration:getClassPathEntries	()Ljava/util/List;
/*     */     //   90: invokeinterface 106 1 0
/*     */     //   95: ifne +78 -> 173
/*     */     //   98: getstatic 112	com/yougou/mybatis/plugins/PopAction:cacheDriverPathMap	Ljava/util/Map;
/*     */     //   101: ifnull +72 -> 173
/*     */     //   104: getstatic 112	com/yougou/mybatis/plugins/PopAction:cacheDriverPathMap	Ljava/util/Map;
/*     */     //   107: invokeinterface 117 1 0
/*     */     //   112: ifle +61 -> 173
/*     */     //   115: getstatic 112	com/yougou/mybatis/plugins/PopAction:cacheDriverPathMap	Ljava/util/Map;
/*     */     //   118: invokeinterface 120 1 0
/*     */     //   123: invokeinterface 124 1 0
/*     */     //   128: astore 6
/*     */     //   130: goto +33 -> 163
/*     */     //   133: aload 6
/*     */     //   135: invokeinterface 130 1 0
/*     */     //   140: checkcast 85	org/eclipse/core/runtime/IPath
/*     */     //   143: astore 5
/*     */     //   145: aload 4
/*     */     //   147: invokevirtual 100	org/mybatis/generator/config/Configuration:getClassPathEntries	()Ljava/util/List;
/*     */     //   150: aload 5
/*     */     //   152: invokeinterface 136 1 0
/*     */     //   157: invokeinterface 140 2 0
/*     */     //   162: pop
/*     */     //   163: aload 6
/*     */     //   165: invokeinterface 144 1 0
/*     */     //   170: ifne -37 -> 133
/*     */     //   173: aload_2
/*     */     //   174: bipush 50
/*     */     //   176: invokevirtual 148	org/eclipse/core/runtime/SubMonitor:worked	(I)V
/*     */     //   179: new 152	org/mybatis/generator/api/MyBatisGenerator
/*     */     //   182: dup
/*     */     //   183: aload 4
/*     */     //   185: new 154	org/mybatis/generator/eclipse/core/callback/EclipseShellCallback
/*     */     //   188: dup
/*     */     //   189: invokespecial 156	org/mybatis/generator/eclipse/core/callback/EclipseShellCallback:<init>	()V
/*     */     //   192: aload_0
/*     */     //   193: getfield 30	com/yougou/mybatis/plugins/RunGeneratorThread:warnings	Ljava/util/List;
/*     */     //   196: invokespecial 157	org/mybatis/generator/api/MyBatisGenerator:<init>	(Lorg/mybatis/generator/config/Configuration;Lorg/mybatis/generator/api/ShellCallback;Ljava/util/List;)V
/*     */     //   199: astore 5
/*     */     //   201: aload_1
/*     */     //   202: ldc -96
/*     */     //   204: invokeinterface 162 2 0
/*     */     //   209: aload_2
/*     */     //   210: sipush 950
/*     */     //   213: invokevirtual 165	org/eclipse/core/runtime/SubMonitor:newChild	(I)Lorg/eclipse/core/runtime/SubMonitor;
/*     */     //   216: astore 6
/*     */     //   218: aload 5
/*     */     //   220: new 169	org/mybatis/generator/eclipse/core/callback/EclipseProgressCallback
/*     */     //   223: dup
/*     */     //   224: aload 6
/*     */     //   226: invokespecial 171	org/mybatis/generator/eclipse/core/callback/EclipseProgressCallback:<init>	(Lorg/eclipse/core/runtime/IProgressMonitor;)V
/*     */     //   229: invokevirtual 173	org/mybatis/generator/api/MyBatisGenerator:generate	(Lorg/mybatis/generator/api/ProgressCallback;)V
/*     */     //   232: goto +281 -> 513
/*     */     //   235: pop
/*     */     //   236: new 177	org/eclipse/core/runtime/OperationCanceledException
/*     */     //   239: dup
/*     */     //   240: invokespecial 179	org/eclipse/core/runtime/OperationCanceledException:<init>	()V
/*     */     //   243: athrow
/*     */     //   244: astore_3
/*     */     //   245: new 180	org/eclipse/core/runtime/Status
/*     */     //   248: dup
/*     */     //   249: iconst_4
/*     */     //   250: ldc -74
/*     */     //   252: iconst_4
/*     */     //   253: aload_3
/*     */     //   254: invokevirtual 184	java/sql/SQLException:getMessage	()Ljava/lang/String;
/*     */     //   257: aload_3
/*     */     //   258: invokespecial 189	org/eclipse/core/runtime/Status:<init>	(ILjava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   261: astore 4
/*     */     //   263: invokestatic 192	com/yougou/mybatis/plugins/Activator:getDefault	()Lcom/yougou/mybatis/plugins/Activator;
/*     */     //   266: invokevirtual 198	com/yougou/mybatis/plugins/Activator:getLog	()Lorg/eclipse/core/runtime/ILog;
/*     */     //   269: aload 4
/*     */     //   271: invokeinterface 202 2 0
/*     */     //   276: new 46	org/eclipse/core/runtime/CoreException
/*     */     //   279: dup
/*     */     //   280: aload 4
/*     */     //   282: invokespecial 208	org/eclipse/core/runtime/CoreException:<init>	(Lorg/eclipse/core/runtime/IStatus;)V
/*     */     //   285: athrow
/*     */     //   286: astore_3
/*     */     //   287: new 180	org/eclipse/core/runtime/Status
/*     */     //   290: dup
/*     */     //   291: iconst_4
/*     */     //   292: ldc -74
/*     */     //   294: iconst_4
/*     */     //   295: aload_3
/*     */     //   296: invokevirtual 210	java/io/IOException:getMessage	()Ljava/lang/String;
/*     */     //   299: aload_3
/*     */     //   300: invokespecial 189	org/eclipse/core/runtime/Status:<init>	(ILjava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   303: astore 4
/*     */     //   305: invokestatic 192	com/yougou/mybatis/plugins/Activator:getDefault	()Lcom/yougou/mybatis/plugins/Activator;
/*     */     //   308: invokevirtual 198	com/yougou/mybatis/plugins/Activator:getLog	()Lorg/eclipse/core/runtime/ILog;
/*     */     //   311: aload 4
/*     */     //   313: invokeinterface 202 2 0
/*     */     //   318: new 46	org/eclipse/core/runtime/CoreException
/*     */     //   321: dup
/*     */     //   322: aload 4
/*     */     //   324: invokespecial 208	org/eclipse/core/runtime/CoreException:<init>	(Lorg/eclipse/core/runtime/IStatus;)V
/*     */     //   327: athrow
/*     */     //   328: astore_3
/*     */     //   329: aload_3
/*     */     //   330: invokevirtual 213	org/mybatis/generator/exception/XMLParserException:getErrors	()Ljava/util/List;
/*     */     //   333: astore 4
/*     */     //   335: new 218	org/eclipse/core/runtime/MultiStatus
/*     */     //   338: dup
/*     */     //   339: ldc -74
/*     */     //   341: iconst_4
/*     */     //   342: ldc -36
/*     */     //   344: aconst_null
/*     */     //   345: invokespecial 222	org/eclipse/core/runtime/MultiStatus:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   348: astore 5
/*     */     //   350: aload 4
/*     */     //   352: invokeinterface 225 1 0
/*     */     //   357: astore 6
/*     */     //   359: goto +34 -> 393
/*     */     //   362: new 180	org/eclipse/core/runtime/Status
/*     */     //   365: dup
/*     */     //   366: iconst_4
/*     */     //   367: ldc -74
/*     */     //   369: iconst_4
/*     */     //   370: aload 6
/*     */     //   372: invokeinterface 130 1 0
/*     */     //   377: checkcast 226	java/lang/String
/*     */     //   380: aconst_null
/*     */     //   381: invokespecial 189	org/eclipse/core/runtime/Status:<init>	(ILjava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   384: astore 7
/*     */     //   386: aload 5
/*     */     //   388: aload 7
/*     */     //   390: invokevirtual 228	org/eclipse/core/runtime/MultiStatus:add	(Lorg/eclipse/core/runtime/IStatus;)V
/*     */     //   393: aload 6
/*     */     //   395: invokeinterface 144 1 0
/*     */     //   400: ifne -38 -> 362
/*     */     //   403: new 46	org/eclipse/core/runtime/CoreException
/*     */     //   406: dup
/*     */     //   407: aload 5
/*     */     //   409: invokespecial 208	org/eclipse/core/runtime/CoreException:<init>	(Lorg/eclipse/core/runtime/IStatus;)V
/*     */     //   412: athrow
/*     */     //   413: astore_3
/*     */     //   414: aload_3
/*     */     //   415: invokevirtual 230	org/mybatis/generator/exception/InvalidConfigurationException:getErrors	()Ljava/util/List;
/*     */     //   418: astore 4
/*     */     //   420: new 218	org/eclipse/core/runtime/MultiStatus
/*     */     //   423: dup
/*     */     //   424: ldc -74
/*     */     //   426: iconst_4
/*     */     //   427: ldc -23
/*     */     //   429: aconst_null
/*     */     //   430: invokespecial 222	org/eclipse/core/runtime/MultiStatus:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   433: astore 5
/*     */     //   435: aload 4
/*     */     //   437: invokeinterface 225 1 0
/*     */     //   442: astore 6
/*     */     //   444: goto +34 -> 478
/*     */     //   447: new 180	org/eclipse/core/runtime/Status
/*     */     //   450: dup
/*     */     //   451: iconst_4
/*     */     //   452: ldc -74
/*     */     //   454: iconst_4
/*     */     //   455: aload 6
/*     */     //   457: invokeinterface 130 1 0
/*     */     //   462: checkcast 226	java/lang/String
/*     */     //   465: aconst_null
/*     */     //   466: invokespecial 189	org/eclipse/core/runtime/Status:<init>	(ILjava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   469: astore 7
/*     */     //   471: aload 5
/*     */     //   473: aload 7
/*     */     //   475: invokevirtual 228	org/eclipse/core/runtime/MultiStatus:add	(Lorg/eclipse/core/runtime/IStatus;)V
/*     */     //   478: aload 6
/*     */     //   480: invokeinterface 144 1 0
/*     */     //   485: ifne -38 -> 447
/*     */     //   488: new 46	org/eclipse/core/runtime/CoreException
/*     */     //   491: dup
/*     */     //   492: aload 5
/*     */     //   494: invokespecial 208	org/eclipse/core/runtime/CoreException:<init>	(Lorg/eclipse/core/runtime/IStatus;)V
/*     */     //   497: athrow
/*     */     //   498: astore 8
/*     */     //   500: aload_1
/*     */     //   501: invokeinterface 235 1 0
/*     */     //   506: aload_0
/*     */     //   507: invokespecial 238	com/yougou/mybatis/plugins/RunGeneratorThread:restoreClassLoader	()V
/*     */     //   510: aload 8
/*     */     //   512: athrow
/*     */     //   513: aload_1
/*     */     //   514: invokeinterface 235 1 0
/*     */     //   519: aload_0
/*     */     //   520: invokespecial 238	com/yougou/mybatis/plugins/RunGeneratorThread:restoreClassLoader	()V
/*     */     //   523: return
/*     */     // Line number table:
/*     */     //   Java source line #86	-> byte code offset #0
/*     */     //   Java source line #87	-> byte code offset #8
/*     */     //   Java source line #89	-> byte code offset #17
/*     */     //   Java source line #92	-> byte code offset #21
/*     */     //   Java source line #94	-> byte code offset #27
/*     */     //   Java source line #95	-> byte code offset #31
/*     */     //   Java source line #94	-> byte code offset #35
/*     */     //   Java source line #102	-> byte code offset #39
/*     */     //   Java source line #108	-> byte code offset #85
/*     */     //   Java source line #109	-> byte code offset #115
/*     */     //   Java source line #110	-> byte code offset #145
/*     */     //   Java source line #109	-> byte code offset #163
/*     */     //   Java source line #114	-> byte code offset #173
/*     */     //   Java source line #116	-> byte code offset #179
/*     */     //   Java source line #117	-> byte code offset #201
/*     */     //   Java source line #118	-> byte code offset #209
/*     */     //   Java source line #119	-> byte code offset #218
/*     */     //   Java source line #121	-> byte code offset #235
/*     */     //   Java source line #122	-> byte code offset #236
/*     */     //   Java source line #123	-> byte code offset #244
/*     */     //   Java source line #124	-> byte code offset #245
/*     */     //   Java source line #125	-> byte code offset #252
/*     */     //   Java source line #124	-> byte code offset #258
/*     */     //   Java source line #126	-> byte code offset #263
/*     */     //   Java source line #127	-> byte code offset #276
/*     */     //   Java source line #128	-> byte code offset #286
/*     */     //   Java source line #129	-> byte code offset #287
/*     */     //   Java source line #130	-> byte code offset #305
/*     */     //   Java source line #131	-> byte code offset #318
/*     */     //   Java source line #132	-> byte code offset #328
/*     */     //   Java source line #133	-> byte code offset #329
/*     */     //   Java source line #134	-> byte code offset #335
/*     */     //   Java source line #135	-> byte code offset #342
/*     */     //   Java source line #136	-> byte code offset #344
/*     */     //   Java source line #134	-> byte code offset #345
/*     */     //   Java source line #138	-> byte code offset #350
/*     */     //   Java source line #139	-> byte code offset #359
/*     */     //   Java source line #140	-> byte code offset #362
/*     */     //   Java source line #141	-> byte code offset #380
/*     */     //   Java source line #140	-> byte code offset #381
/*     */     //   Java source line #143	-> byte code offset #386
/*     */     //   Java source line #139	-> byte code offset #393
/*     */     //   Java source line #145	-> byte code offset #403
/*     */     //   Java source line #146	-> byte code offset #413
/*     */     //   Java source line #147	-> byte code offset #414
/*     */     //   Java source line #149	-> byte code offset #420
/*     */     //   Java source line #150	-> byte code offset #424
/*     */     //   Java source line #151	-> byte code offset #426
/*     */     //   Java source line #152	-> byte code offset #427
/*     */     //   Java source line #153	-> byte code offset #429
/*     */     //   Java source line #149	-> byte code offset #430
/*     */     //   Java source line #155	-> byte code offset #435
/*     */     //   Java source line #156	-> byte code offset #444
/*     */     //   Java source line #157	-> byte code offset #447
/*     */     //   Java source line #158	-> byte code offset #465
/*     */     //   Java source line #157	-> byte code offset #466
/*     */     //   Java source line #160	-> byte code offset #471
/*     */     //   Java source line #156	-> byte code offset #478
/*     */     //   Java source line #162	-> byte code offset #488
/*     */     //   Java source line #163	-> byte code offset #498
/*     */     //   Java source line #164	-> byte code offset #500
/*     */     //   Java source line #165	-> byte code offset #506
/*     */     //   Java source line #166	-> byte code offset #510
/*     */     //   Java source line #164	-> byte code offset #513
/*     */     //   Java source line #165	-> byte code offset #519
/*     */     //   Java source line #167	-> byte code offset #523
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	524	0	this	RunGeneratorThread
/*     */     //   0	524	1	monitor	org.eclipse.core.runtime.IProgressMonitor
/*     */     //   7	203	2	subMonitor	org.eclipse.core.runtime.SubMonitor
/*     */     //   38	2	3	cp	org.mybatis.generator.config.xml.ConfigurationParser
/*     */     //   244	14	3	e	java.sql.SQLException
/*     */     //   286	14	3	e	java.io.IOException
/*     */     //   328	2	3	e	org.mybatis.generator.exception.XMLParserException
/*     */     //   413	2	3	e	org.mybatis.generator.exception.InvalidConfigurationException
/*     */     //   83	101	4	config	org.mybatis.generator.config.Configuration
/*     */     //   261	20	4	status	org.eclipse.core.runtime.Status
/*     */     //   303	20	4	status	org.eclipse.core.runtime.Status
/*     */     //   333	18	4	errors	List<String>
/*     */     //   418	18	4	errors	List<String>
/*     */     //   143	8	5	path	IPath
/*     */     //   199	20	5	mybatisGenerator	org.mybatis.generator.api.MyBatisGenerator
/*     */     //   348	60	5	multiStatus	org.eclipse.core.runtime.MultiStatus
/*     */     //   433	60	5	multiStatus	org.eclipse.core.runtime.MultiStatus
/*     */     //   128	36	6	localIterator	java.util.Iterator
/*     */     //   216	9	6	spm	org.eclipse.core.runtime.SubMonitor
/*     */     //   357	37	6	iter	Object
/*     */     //   442	37	6	iter	Object
/*     */     //   384	5	7	message	org.eclipse.core.runtime.Status
/*     */     //   469	5	7	message	org.eclipse.core.runtime.Status
/*     */     //   498	13	8	localObject1	Object
/*     */     //   235	1	24	localInterruptedException	InterruptedException
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   21	232	235	java/lang/InterruptedException
/*     */     //   21	232	244	java/sql/SQLException
/*     */     //   21	232	286	java/io/IOException
/*     */     //   21	232	328	org/mybatis/generator/exception/XMLParserException
/*     */     //   21	232	413	org/mybatis/generator/exception/InvalidConfigurationException
/*     */     //   21	498	498	finally
/*     */   }
/*     */   
/*     */   private void setClassLoader()
/*     */   {
/* 171 */     IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
/* 172 */     IJavaProject javaProject = getJavaProject();
/*     */     try
/*     */     {
/* 175 */       if (javaProject != null) {
/* 176 */         List<URL> entries = new ArrayList();
/* 177 */         IPath path = javaProject.getOutputLocation();
/* 178 */         IResource iResource = root.findMember(path);
/* 179 */         path = iResource.getLocation();
/* 180 */         path = path.addTrailingSeparator();
/* 181 */         entries.add(path.toFile().toURL());
/*     */         
/* 183 */         IClasspathEntry[] cpEntries = javaProject.getRawClasspath();
/* 184 */         IClasspathEntry[] arrayOfIClasspathEntry1; int j = (arrayOfIClasspathEntry1 = cpEntries).length; for (int i = 0; i < j; i++) { IClasspathEntry cpEntry = arrayOfIClasspathEntry1[i];
/* 185 */           switch (cpEntry.getEntryKind()) {
/*     */           case 3: 
/* 187 */             path = cpEntry.getOutputLocation();
/* 188 */             if (path != null) {
/* 189 */               iResource = root.findMember(path);
/* 190 */               path = iResource.getLocation();
/* 191 */               path = path.addTrailingSeparator();
/* 192 */               entries.add(path.toFile().toURL());
/*     */             }
/* 194 */             break;
/*     */           
/*     */           case 1: 
/* 197 */             iResource = root.findMember(cpEntry.getPath());
/* 198 */             if (iResource == null)
/*     */             {
/* 200 */               path = cpEntry.getPath();
/*     */             } else {
/* 202 */               path = iResource.getLocation();
/*     */             }
/* 204 */             entries.add(path.toFile().toURL());
/*     */           }
/*     */           
/*     */         }
/*     */         
/* 209 */         ClassLoader oldCl = Thread.currentThread().getContextClassLoader();
/* 210 */         URL[] entryArray = new URL[entries.size()];
/* 211 */         entries.toArray(entryArray);
/* 212 */         Object newCl = new URLClassLoader(entryArray, oldCl);
/* 213 */         Thread.currentThread().setContextClassLoader((ClassLoader)newCl);
/* 214 */         this.oldClassLoader = oldCl;
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void restoreClassLoader()
/*     */   {
/* 224 */     if (this.oldClassLoader != null) {
/* 225 */       Thread.currentThread().setContextClassLoader(this.oldClassLoader);
/*     */     }
/*     */   }
/*     */   
/*     */   private IJavaProject getJavaProject() {
/* 230 */     IJavaProject answer = null;
/* 231 */     IProject project = this.inputFile.getProject();
/*     */     try {
/* 233 */       if (project.hasNature("org.eclipse.jdt.core.javanature")) {
/* 234 */         answer = JavaCore.create(project);
/*     */       }
/*     */     }
/*     */     catch (CoreException localCoreException) {}
/*     */     
/*     */ 
/*     */ 
/* 241 */     return answer;
/*     */   }
/*     */ }


/* Location:              C:\Users\user\Desktop\com.yougou.mybatis.plugin_1.3.2.jar!\com\yougou\mybatis\plugins\RunGeneratorThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */