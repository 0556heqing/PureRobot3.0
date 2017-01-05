package com.heqing.thread;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component("BeanDefineConfigue2")
public class AfterInitialization implements ApplicationListener<ContextRefreshedEvent> {

	@Resource	
	private GetAccessTokenThread getAccessTokenThread;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//root application context 没有parent，他就是老大. 
		if(((ApplicationContextEvent) event).getApplicationContext().getParent() == null){
			System.out.println("============Spring Container initialized============");
//			new Thread(getAccessTokenThread).start();
       }  
	}

}
