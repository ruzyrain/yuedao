package com.YueDao.web.base;



import org.springframework.ui.ModelMap;

public class BaseJsonJumpAction {
	
	
	protected String jmodule;
/*	public void common(ModelMap map)
	{
		map.put("url", "/Activity/");
		map.put("jmodule", jmodule);
	}*/
	public ModelMap msg(String msg_text)
	{
		ModelMap m = new ModelMap();
		m.put("state", 0);
		m.put("msg", msg_text); // 填空属性
		return m;
	}
	public ModelMap jump(String url)
	{
		ModelMap m = new ModelMap();
		m.put("state", 1);
		m.put("url", url); // 填空属性
		return m;
	}
	public ModelMap jump(String url,String msg)
	{
		ModelMap m = new ModelMap();
		m.put("state", 1);
		m.put("url", url); // 填空属性
		m.put("msg", msg); // 填空属性
		return m;
	}
	public String ModuleUrl(String url)
	{
		return jmodule+url;
	}
	public String RedirectModuleUrl(String url)
	{
		return "redirect:"+jmodule+url;
	}
	
	public void setJmodule(String module) {
		// TODO Auto-generated method stub
		jmodule=module;
	}
	
	
	
}
