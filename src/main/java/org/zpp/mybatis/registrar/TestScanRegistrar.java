package org.zpp.mybatis.registrar;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.zpp.mybatis.component.UserService;

public class TestScanRegistrar implements ImportBeanDefinitionRegistrar {

	public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition)beanDefinitionRegistry.getBeanDefinition("userService");

		/**
		 * 此时会根据UserService的属性是否提供了setXXX方法来进行自动装配，eg：setOrderService
		 */
		beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
		beanDefinitionRegistry.registerBeanDefinition("userService",beanDefinition);
	}
}