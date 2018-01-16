package cn.com.magicsoft.framework.web.mvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class MagicSoftWebBinding implements WebBindingInitializer {  
	  
    public void initBinder(WebDataBinder binder, WebRequest request) {  
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd");     
         CustomDateEditor dateEditor = new CustomDateEditor(df, true);     
        //表示如果命令对象有Date类型的属性，将使用该属性编辑器进行类型转换     
        binder.registerCustomEditor(Date.class, dateEditor);     
    }  
}  