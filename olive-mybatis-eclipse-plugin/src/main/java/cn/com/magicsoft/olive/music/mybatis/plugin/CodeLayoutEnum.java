/*    */ package com.yougou.mybatis.plugins;
/*    */ 
/*    */ public enum CodeLayoutEnum {
/*  4 */   DAL_LAYOUT("dal"),  SERVICE_LAYOUT("service"),  MANAGER_LAYOUT("manager"),  CONTROLLER_LAYOUT(
/*  5 */     "controller");
/*    */   
/*    */   public String name;
/*    */   
/*    */   private CodeLayoutEnum(String name) {
/* 10 */     this.name = name;
/*    */   }
/*    */ }


/* Location:              C:\Users\user\Desktop\com.yougou.mybatis.plugin_1.3.2.jar!\com\yougou\mybatis\plugins\CodeLayoutEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */