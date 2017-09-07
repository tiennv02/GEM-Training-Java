package com.javatpoint;

import com.javatpoint.Samsung.Samsung;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
public static void main(String[] args) {

	ApplicationContext factory=new ClassPathXmlApplicationContext("applicationContext.xml");

//	Employee
	Employee emSet = (Employee) factory.getBean("emSet");
	Employee emSet1 = (Employee) factory.getBean("emSet");
	Employee emCons = (Employee) factory.getBean("emCons");

	emSet1.setName("Akali");

    System.out.println(emSet.getId() + "\n" + emSet.getName() + "\n" +emSet.getCity() + "\n" + emSet.getPhone() + "\n");
    System.out.println(emSet1.getId() + "\n" + emSet1.getName() + "\n" +emSet1.getCity() + "\n" + emSet1.getPhone() + "\n");
    System.out.println(emCons.getId() + "\n" + emCons.getName() + "\n" +emCons.getCity() + "\n" + emCons.getPhone() + "\n\n");

//  Office
    Office offSet = (Office) factory.getBean("offSet");
    Office offCons = (Office) factory.getBean("offCons");

    System.out.println(offSet.getName() + "\n" + offSet.getAddress() + "\n" +offSet.getId() + "\n");
	System.out.println(offCons.getName() + "\n" + offCons.getAddress() + "\n" +offCons.getId() + "\n");
//  -------------------------------------------------------

//  Samsung - Mobile - TV
    Samsung ss1 = (Samsung) factory.getBean("ss1");
    Samsung ss2 = (Samsung) factory.getBean("ss2");

    System.out.println("Address: " +ss1.getAddress() + "\n Model Moblie: " + ss1.getMb() + "\n Model TV: " + ss1.getTv() + "\n");
    System.out.println("Address: " +ss2.getAddress() + "\n Model Mobile: " + ss2.getMb() + "\n Model TV: " + ss2.getTv() + "\n");
	}
}

