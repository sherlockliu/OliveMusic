/*     */ package cn.com.magicsoft.olive.music.mybatis.plugin;
/*     */ 
/*     */ import org.eclipse.swt.graphics.Point;
/*     */ import org.eclipse.swt.graphics.Rectangle;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Control;
/*     */ import org.eclipse.swt.widgets.Layout;
/*     */ 
/*     */ public class BorderLayout extends Layout
/*     */ {
/*     */   public static final int NORTH = 0;
/*     */   public static final int SOUTH = 1;
/*     */   public static final int CENTER = 2;
/*     */   public static final int EAST = 3;
/*     */   public static final int WEST = 4;
/*     */   
/*     */   public static class BorderData
/*     */   {
/*  19 */     public int region = 2;
/*     */     
/*     */     public BorderData() {}
/*     */     
/*     */     public BorderData(int region)
/*     */     {
/*  25 */       this.region = region;
/*     */     }
/*     */   }
/*     */   
/*  29 */   public Control[] controls = new Control[5];
/*     */   
/*     */   Point[] sizes;
/*     */   int width;
/*     */   int height;
/*     */   
/*     */   protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache)
/*     */   {
/*  37 */     if ((this.sizes == null) || (flushCache))
/*  38 */       refreshSizes(composite.getChildren());
/*  39 */     int w = wHint;
/*  40 */     int h = hHint;
/*  41 */     if (w == -1)
/*  42 */       w = this.width;
/*  43 */     if (h == -1)
/*  44 */       h = this.height;
/*  45 */     return new Point(w, h);
/*     */   }
/*     */   
/*     */   protected void layout(Composite composite, boolean flushCache) {
/*  49 */     if ((flushCache) || (this.sizes == null))
/*  50 */       refreshSizes(composite.getChildren());
/*  51 */     Rectangle clientArea = composite.getClientArea();
/*  52 */     if (this.controls[0] != null) {
/*  53 */       this.controls[0].setBounds(clientArea.x, clientArea.y, 
/*  54 */         clientArea.width, this.sizes[0].y);
/*     */     }
/*  56 */     if (this.controls[1] != null) {
/*  57 */       this.controls[1].setBounds(clientArea.x, clientArea.y + 
/*  58 */         clientArea.height - this.sizes[1].y, clientArea.width, 
/*  59 */         this.sizes[1].y);
/*     */     }
/*  61 */     if (this.controls[4] != null) {
/*  62 */       this.controls[4].setBounds(clientArea.x, clientArea.y + 
/*  63 */         this.sizes[0].y, this.sizes[4].x, clientArea.height - 
/*  64 */         this.sizes[0].y - this.sizes[1].y);
/*     */     }
/*  66 */     if (this.controls[3] != null) {
/*  67 */       this.controls[3].setBounds(clientArea.x + clientArea.width - 
/*  68 */         this.sizes[3].x, clientArea.y + this.sizes[0].y, 
/*  69 */         this.sizes[3].x, clientArea.height - this.sizes[0].y - 
/*  70 */         this.sizes[1].y);
/*     */     }
/*  72 */     if (this.controls[2] != null) {
/*  73 */       this.controls[2].setBounds(clientArea.x + this.sizes[4].x, 
/*  74 */         clientArea.y + this.sizes[0].y, clientArea.width - 
/*  75 */         this.sizes[4].x - this.sizes[3].x, clientArea.height - 
/*  76 */         this.sizes[0].y - this.sizes[1].y);
/*     */     }
/*     */   }
/*     */   
/*     */   private void refreshSizes(Control[] children)
/*     */   {
/*  82 */     for (int i = 0; i < children.length; i++) {
/*  83 */       Object layoutData = children[i].getLayoutData();
/*  84 */       if ((layoutData != null) && ((layoutData instanceof BorderData)))
/*     */       {
/*  86 */         BorderData borderData = (BorderData)layoutData;
/*  87 */         if ((borderData.region >= 0) && (borderData.region <= 4))
/*     */         {
/*  89 */           this.controls[borderData.region] = children[i]; }
/*     */       } }
/*  91 */     this.width = 0;
/*  92 */     this.height = 0;
/*  93 */     if (this.sizes == null)
/*  94 */       this.sizes = new Point[5];
/*  95 */     for (int i = 0; i < this.controls.length; i++) {
/*  96 */       Control control = this.controls[i];
/*  97 */       if (control == null) {
/*  98 */         this.sizes[i] = new Point(0, 0);
/*     */       } else {
/* 100 */         this.sizes[i] = control.computeSize(-1, -1, true);
/*     */       }
/*     */     }
/* 103 */     this.width = Math.max(this.width, this.sizes[0].x);
/* 104 */     this.width = 
/* 105 */       Math.max(this.width, this.sizes[4].x + this.sizes[2].x + this.sizes[3].x);
/* 106 */     this.width = Math.max(this.width, this.sizes[1].x);
/* 107 */     this.height = 
/* 108 */       (Math.max(Math.max(this.sizes[4].y, this.sizes[3].y), this.sizes[2].y) + this.sizes[0].y + this.sizes[1].y);
/*     */   }
/*     */ }