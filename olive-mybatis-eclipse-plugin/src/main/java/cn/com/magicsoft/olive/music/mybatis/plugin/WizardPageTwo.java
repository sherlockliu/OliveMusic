/*     */ package com.yougou.mybatis.plugins;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.eclipse.jface.viewers.ComboViewer;
/*     */ import org.eclipse.jface.wizard.WizardPage;
/*     */ import org.eclipse.swt.events.ModifyEvent;
/*     */ import org.eclipse.swt.events.ModifyListener;
/*     */ import org.eclipse.swt.events.SelectionAdapter;
/*     */ import org.eclipse.swt.events.SelectionEvent;
/*     */ import org.eclipse.swt.widgets.Button;
/*     */ import org.eclipse.swt.widgets.Combo;
/*     */ import org.eclipse.swt.widgets.Composite;
/*     */ import org.eclipse.swt.widgets.Group;
/*     */ import org.eclipse.swt.widgets.Label;
/*     */ import org.eclipse.swt.widgets.Text;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WizardPageTwo
/*     */   extends WizardPage
/*     */ {
/*     */   private Map<CodeLayoutEnum, Boolean> codeLayoutMap;
/*     */   private String codeVersion;
/*     */   private Text txt_version;
/*     */   
/*     */   public WizardPageTwo()
/*     */   {
/*  31 */     super("page2");
/*  32 */     setTitle("生成代码层");
/*  33 */     setDescription("选择生成的代码层");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void createControl(Composite parent)
/*     */   {
/*  41 */     this.codeLayoutMap = new HashMap(3);
/*  42 */     Composite container = new Composite(parent, 0);
/*  43 */     container.setLayout(new BorderLayout());
/*  44 */     setControl(container);
/*     */     
/*  46 */     Group group = new Group(container, 0);
/*  47 */     group.setLayoutData(new BorderLayout.BorderData(2));
/*  48 */     group.setText("代码层");
/*     */     
/*  50 */     ComboViewer comboViewer = new ComboViewer(group, 0);
/*  51 */     final Combo combo = comboViewer.getCombo();
/*  52 */     combo.setItems(new String[] { CodeHierarchicalEnum.THREE.name, CodeHierarchicalEnum.FOUR.name });
/*  53 */     combo.setBounds(64, 33, 88, 25);
/*  54 */     combo.select(1);
/*     */     
/*  56 */     Button check_dal = new Button(group, 32);
/*  57 */     check_dal.setEnabled(false);
/*  58 */     check_dal.setSelection(true);
/*  59 */     check_dal.setBounds(10, 83, 98, 17);
/*  60 */     check_dal.setText("Dal层");
/*     */     
/*  62 */     final Button check_service = new Button(group, 32);
/*  63 */     check_service.setBounds(123, 83, 98, 17);
/*  64 */     check_service.setText("Service层");
/*     */     
/*  66 */     final Button check_manager = new Button(group, 32);
/*  67 */     check_manager.setBounds(247, 83, 98, 17);
/*  68 */     check_manager.setText("Manager层");
/*     */     
/*  70 */     final Button check_controller = new Button(group, 32);
/*  71 */     check_controller.setBounds(380, 83, 98, 17);
/*  72 */     check_controller.setText("Controller层");
/*     */     
/*  74 */     this.txt_version = new Text(group, 2048);
/*  75 */     this.txt_version.setToolTipText("此选项在生成java代码的注解中的版本号");
/*  76 */     this.txt_version.setText("1.0.0");
/*  77 */     this.txt_version.setBounds(64, 131, 73, 23);
/*     */     
/*  79 */     Label lblNewLabel = new Label(group, 0);
/*  80 */     lblNewLabel.setBounds(10, 137, 41, 17);
/*  81 */     lblNewLabel.setText("版本号");
/*     */     
/*  83 */     Label label = new Label(group, 0);
/*  84 */     label.setText("代码分层");
/*  85 */     label.setBounds(10, 41, 48, 17);
/*  86 */     check_service.addSelectionListener(new SelectionAdapter()
/*     */     {
/*     */       public void widgetSelected(SelectionEvent e) {
/*  89 */         boolean flag = ((Button)e.getSource()).getSelection();
/*  90 */         if (!flag) {
/*  91 */           check_manager.setSelection(false);
/*  92 */           check_controller.setSelection(false);
/*     */         }
/*     */         
/*  95 */         WizardPageTwo.this.builderCodeLayoutMap(new Button[] { check_service, check_manager, check_controller });
/*     */       }
/*  97 */     });
/*  98 */     check_manager.addSelectionListener(new SelectionAdapter()
/*     */     {
/*     */       public void widgetSelected(SelectionEvent e) {
/* 101 */         boolean flag = ((Button)e.getSource()).getSelection();
/* 102 */         if (flag) {
/* 103 */           check_service.setSelection(flag);
/*     */         }
/* 105 */         if ((!flag) && (check_controller.getSelection())) {
/* 106 */           check_controller.setSelection(false);
/*     */         }
/* 108 */         WizardPageTwo.this.builderCodeLayoutMap(new Button[] { check_service, check_manager, check_controller });
/*     */       }
/* 110 */     });
/* 111 */     check_controller.addSelectionListener(new SelectionAdapter()
/*     */     {
/*     */       public void widgetSelected(SelectionEvent e) {
/* 114 */         boolean flag = ((Button)e.getSource()).getSelection();
/* 115 */         if (flag) {
/* 116 */           check_service.setSelection(flag);
/* 117 */           if (combo.getSelectionIndex() == CodeHierarchicalEnum.FOUR.point) {
/* 118 */             check_manager.setSelection(flag);
/*     */           }
/*     */         }
/* 121 */         WizardPageTwo.this.builderCodeLayoutMap(new Button[] { check_service, check_manager, check_controller });
/*     */       }
/*     */       
/* 124 */     });
/* 125 */     combo.addModifyListener(new ModifyListener()
/*     */     {
/*     */       public void modifyText(ModifyEvent e) {
/* 128 */         int itemIndex = ((Combo)e.getSource()).getSelectionIndex();
/* 129 */         if (itemIndex == CodeHierarchicalEnum.THREE.point) {
/* 130 */           check_manager.setEnabled(false);
/* 131 */           check_manager.setSelection(false);
/* 132 */         } else if (itemIndex == CodeHierarchicalEnum.FOUR.point) {
/* 133 */           check_manager.setEnabled(true);
/* 134 */           check_manager.setSelection(true);
/*     */         }
/* 136 */         WizardPageTwo.this.builderCodeLayoutMap(new Button[] { check_service, check_manager, check_controller });
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private void builderCodeLayoutMap(Button[] checkList) {
/* 142 */     this.codeLayoutMap.clear();
/* 143 */     if (checkList[0].getSelection())
/* 144 */       this.codeLayoutMap.put(CodeLayoutEnum.SERVICE_LAYOUT, Boolean.valueOf(true));
/* 145 */     if (checkList[1].getSelection())
/* 146 */       this.codeLayoutMap.put(CodeLayoutEnum.MANAGER_LAYOUT, Boolean.valueOf(true));
/* 147 */     if (checkList[2].getSelection())
/* 148 */       this.codeLayoutMap.put(CodeLayoutEnum.CONTROLLER_LAYOUT, Boolean.valueOf(true));
/*     */   }
/*     */   
/*     */   public Map<CodeLayoutEnum, Boolean> getCodeLayoutMap() {
/* 152 */     return this.codeLayoutMap;
/*     */   }
/*     */   
/*     */   public String getCodeVersion() {
/* 156 */     return this.txt_version.getText();
/*     */   }
/*     */ }


/* Location:              C:\Users\user\Desktop\com.yougou.mybatis.plugin_1.3.2.jar!\com\yougou\mybatis\plugins\WizardPageTwo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */