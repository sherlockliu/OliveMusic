/*     */ package com.yougou.mybatis.plugins;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.eclipse.jface.dialogs.MessageDialog;
/*     */ import org.eclipse.jface.wizard.WizardPage;
/*     */ import org.eclipse.swt.events.ModifyEvent;
/*     */ import org.eclipse.swt.events.ModifyListener;
/*     */ import org.eclipse.swt.events.SelectionAdapter;
/*     */ import org.eclipse.swt.events.SelectionEvent;
/*     */ import org.eclipse.swt.layout.FormAttachment;
/*     */ import org.eclipse.swt.layout.FormData;
/*     */ import org.eclipse.swt.layout.FormLayout;
/*     */ import org.eclipse.swt.widgets.Combo;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Label;
/*     */ import org.eclipse.swt.widgets.Table;
/*     */ import org.eclipse.swt.widgets.TableColumn;
/*     */ import org.eclipse.swt.widgets.TableItem;
/*     */ import org.eclipse.swt.widgets.Text;
/*     */ 
/*     */ public class WizardPageOne extends WizardPage
/*     */ {
/*     */   private Text text;
/*     */   private Table table;
/*  28 */   private Combo combo = null;
/*  29 */   private Map<String, List<String>> tableMap = null;
/*  30 */   private List<String> tableList = null;
/*     */   
/*     */ 
/*     */ 
/*     */   public WizardPageOne(Map<String, List<String>> tableMap)
/*     */   {
/*  36 */     super("page1");
/*  37 */     setTitle("请选择表信息");
/*  38 */     setDescription("请输入表信息");
/*  39 */     this.tableMap = tableMap;
/*     */   }
/*     */   
/*     */   public List<String> getTableList() {
/*  43 */     return this.tableList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void createControl(Composite parent)
/*     */   {
/*  52 */     Composite container = new Composite(parent, 2144);
/*  53 */     setControl(container);
/*  54 */     container.setLayout(new BorderLayout());
/*  55 */     setComplete(false);
/*     */     
/*  57 */     Composite composite = new Composite(container, 0);
/*  58 */     composite.setLayoutData(new BorderLayout.BorderData(0));
/*  59 */     FormLayout fl_composite = new FormLayout();
/*  60 */     fl_composite.marginTop = 5;
/*  61 */     fl_composite.marginHeight = 3;
/*  62 */     composite.setLayout(fl_composite);
/*     */     
/*  64 */     Label lblNewLabel = new Label(composite, 0);
/*  65 */     FormData fd_lblNewLabel = new FormData();
/*  66 */     fd_lblNewLabel.top = new FormAttachment(0, 10);
/*  67 */     fd_lblNewLabel.left = new FormAttachment(0, 3);
/*  68 */     lblNewLabel.setLayoutData(fd_lblNewLabel);
/*  69 */     lblNewLabel.setText("请输入表名:");
/*  70 */     this.combo = new Combo(composite, 8);
/*  71 */     this.combo.setTouchEnabled(true);
/*  72 */     this.combo.setToolTipText("请选择表空间");
/*  73 */     FormData fd_combo = new FormData();
/*  74 */     fd_combo.top = new FormAttachment(lblNewLabel, -5, 128);
/*  75 */     fd_combo.left = new FormAttachment(lblNewLabel, 10, 131072);
/*  76 */     this.combo.setLayoutData(fd_combo);
/*  77 */     if ((this.tableMap != null) && (this.tableMap.size() > 0)) {
/*  78 */       this.combo.setItems((String[])this.tableMap.keySet().toArray(new String[this.tableMap.keySet().size()]));
/*     */     }
/*     */     
/*  81 */     this.combo.addSelectionListener(new SelectionAdapter()
/*     */     {
/*     */       public void widgetSelected(SelectionEvent e) {
/*  84 */         WizardPageOne.this.table.removeAll();
/*     */         
/*  86 */         String key = WizardPageOne.this.combo.getText();
/*     */         
/*  88 */         for (String k : (List)WizardPageOne.this.tableMap.get(key)) {
/*  89 */           TableItem item = new TableItem(WizardPageOne.this.table, 0);
/*  90 */           item.setText(k);
/*     */         }
/*     */         
/*     */       }
/*  94 */     });
/*  95 */     this.text = new Text(composite, 2048);
/*  96 */     this.text.addModifyListener(new ModifyListener() {
/*     */       public void modifyText(ModifyEvent arg0) {
/*  98 */         WizardPageOne.this.table.removeAll();
/*     */         
/* 100 */         String key = WizardPageOne.this.combo.getText();
/* 101 */         if (key.equals("")) {
/* 102 */           MessageDialog.openConfirm(WizardPageOne.this.getShell(), "提交", "请选择对应的表空间");
/* 103 */           return;
/*     */         }
/* 105 */         List<String> newTableList = new ArrayList();
/* 106 */         for (String k : (List)WizardPageOne.this.tableMap.get(key)) {
/* 107 */           if (k.toLowerCase().indexOf(WizardPageOne.this.text.getText().toLowerCase()) != -1) {
/* 108 */             newTableList.add(k);
/*     */           }
/*     */         }
/*     */         
/* 112 */         for (String k : newTableList) {
/* 113 */           TableItem item = new TableItem(WizardPageOne.this.table, 0);
/* 114 */           item.setText(k);
/*     */         }
/*     */       }
/* 117 */     });
/* 118 */     FormData fd_text = new FormData();
/* 119 */     fd_text.top = new FormAttachment(this.combo, 2, 128);
/* 120 */     fd_text.left = new FormAttachment(this.combo, 10, 131072);
/* 121 */     this.text.setLayoutData(fd_text);
/*     */     
/* 123 */     this.table = new Table(container, 65570);
/* 124 */     this.tableList = new ArrayList();
/* 125 */     this.table.addSelectionListener(new SelectionAdapter()
/*     */     {
/*     */       public void widgetSelected(SelectionEvent e) {
/* 128 */         WizardPageOne.this.tableList.clear();
/*     */         
/* 130 */         for (int i = 0; i < WizardPageOne.this.table.getItems().length; i++) {
/* 131 */           if (WizardPageOne.this.table.getItems()[i].getChecked()) {
/* 132 */             WizardPageOne.this.tableList.add(WizardPageOne.this.combo.getText() + "." + WizardPageOne.this.table.getItems()[i].getText());
/*     */           }
/*     */         }
/*     */         
/* 136 */         if (WizardPageOne.this.tableList.size() > 0) {
/* 137 */           WizardPageOne.this.setComplete(true);
/*     */         } else {
/* 139 */           WizardPageOne.this.setComplete(false);
/*     */         }
/*     */       }
/* 142 */     });
/* 143 */     this.table.setLayoutData(new BorderLayout.BorderData(2));
/* 144 */     this.table.setHeaderVisible(true);
/* 145 */     this.table.setLinesVisible(true);
/*     */     
/* 147 */     TableColumn col1 = new TableColumn(this.table, 0);
/* 148 */     col1.setText("表名");
/* 149 */     col1.setWidth(300);
/*     */   }
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
/*     */   private void setComplete(boolean flag)
/*     */   {
/* 179 */     setPageComplete(flag);
/*     */   }
/*     */ }


/* Location:              C:\Users\user\Desktop\com.yougou.mybatis.plugin_1.3.2.jar!\com\yougou\mybatis\plugins\WizardPageOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */