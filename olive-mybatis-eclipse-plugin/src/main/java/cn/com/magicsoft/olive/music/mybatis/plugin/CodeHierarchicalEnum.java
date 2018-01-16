/*    */ package com.yougou.mybatis.plugins;
/*    */ 
/*    */ public enum CodeHierarchicalEnum {
/*  4 */   THREE(0, "三层"),  FOUR(1, "四层");
/*    */   
/*    */   public int point;
/*    */   public String name;
/*    */   
/*    */   private CodeHierarchicalEnum(int point, String name) {
/* 10 */     this.point = point;
/* 11 */     this.name = name;
/*    */   }
/*    */ }