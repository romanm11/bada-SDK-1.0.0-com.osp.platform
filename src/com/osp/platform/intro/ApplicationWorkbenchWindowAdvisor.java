package com.osp.platform.intro;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.internal.ide.application.IDEWorkbenchAdvisor;
import org.eclipse.ui.internal.ide.application.IDEWorkbenchWindowAdvisor;


public class ApplicationWorkbenchWindowAdvisor extends IDEWorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(IDEWorkbenchAdvisor wbAdvisor,
			IWorkbenchWindowConfigurer configurer) {
		super(wbAdvisor, configurer);
    }

	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return super.createActionBarAdvisor(configurer);
	}


    public void preWindowOpen() {
    	
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.setTitle("bada");
		
    	super.preWindowOpen();

//    	IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
//        configurer.setInitialSize(new Point(700, 550));
//        configurer.setShowCoolBar(false);
//        configurer.setShowStatusLine(false);
//        configurer.setTitle("bada Product");
    }
    
    @Override
    public void postWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        IMenuManager menuManager = configurer.getActionBarConfigurer().getMenuManager();
        MenuManager windowMenu = (MenuManager) menuManager
            .find(IWorkbenchActionConstants.M_WINDOW);
 
        if(windowMenu != null) {
            windowMenu.remove("openNewWindow");
            windowMenu.remove("newEditor");
        }
        
       super.postWindowOpen();
    }
} 
