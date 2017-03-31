 package cn.com.magicsoft.olive.music.mybatis.plugin;
 
 import org.eclipse.core.runtime.IPluginDescriptor;
 import org.eclipse.ui.plugin.AbstractUIPlugin;
 import org.osgi.framework.BundleContext;
 

 public class Activator extends AbstractUIPlugin
 {
   public Activator(IPluginDescriptor descriptor) {
		super(descriptor);
		// TODO Auto-generated constructor stub
	}

public static final String PLUGIN_ID = "org.mybatis.generator.eclipse.ui";
   private static Activator plugin;
   
   public void start(BundleContext context)
     throws Exception
   {
     super.start(context);
     plugin = this;
   }

   public void stop(BundleContext context)
     throws Exception
   {
     plugin = null;
     super.stop(context);
   }

   public static Activator getDefault()
   {
     return plugin;
   }
}
