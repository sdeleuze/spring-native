package org.springframework;

import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.nativex.extension.InitializationInfo;
import org.springframework.nativex.extension.InitializationTime;
import org.springframework.nativex.extension.NativeImageConfiguration;
import org.springframework.nativex.extension.NativeImageHint;
import org.springframework.nativex.extension.ProxyInfo;


@NativeImageHint(
		initializationInfos = @InitializationInfo(types = {
				org.springframework.aop.TargetSource.class,
				org.springframework.aop.framework.Advised.class,
				org.springframework.aop.Advisor.class,
				org.springframework.aop.framework.DefaultAopProxyFactory.class,
				org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.class,
				org.springframework.context.annotation.ConfigurationClassPostProcessor.class,
				org.springframework.context.annotation.CommonAnnotationBeanPostProcessor.class,
				org.springframework.core.DecoratingProxy.class,
				org.springframework.core.annotation.AnnotationFilter.class,
				org.springframework.core.DefaultParameterNameDiscoverer.class,
				org.springframework.core.ResolvableType.class,
				org.springframework.core.io.support.SpringFactoriesLoader.class,
				org.springframework.jdbc.datasource.ConnectionProxy.class,
				org.springframework.jdbc.support.JdbcAccessor.class,
				org.springframework.jdbc.support.JdbcTransactionManager.class,
				org.springframework.http.HttpStatus.class,
				org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter.class,
				org.springframework.transaction.annotation.Isolation.class,
				org.springframework.transaction.annotation.Propagation.class,
				org.springframework.util.unit.DataUnit.class,
				org.springframework.util.unit.DataSize.class,
				org.springframework.util.Assert.class,
				org.springframework.util.StringUtils.class,
				// Caches
				org.springframework.beans.CachedIntrospectionResults.class,
				org.springframework.core.annotation.AnnotationUtils.class,
				org.springframework.util.ReflectionUtils.class,
				// For SPEL removal
				org.springframework.context.support.AbstractApplicationContext.class,
				org.springframework.context.event.EventListenerMethodProcessor.class,
				org.springframework.core.SpringProperties.class,
				// For XML removal
				org.springframework.core.io.support.PropertiesLoaderUtils.class,
				org.springframework.core.io.support.ResourcePropertiesPersister.class,
				org.springframework.messaging.simp.config.AbstractMessageBrokerConfiguration.class,
				org.springframework.http.MediaType.class,
				org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter.class,
				org.springframework.beans.factory.xml.XmlBeanDefinitionReader.class,
				org.springframework.beans.PropertyEditorRegistrySupport.class,
				org.springframework.util.ReflectionUtils.class,
				org.springframework.util.DefaultPropertiesPersister.class,
				org.springframework.util.ClassUtils.class,
				org.springframework.util.ConcurrentReferenceHashMap.class,
				org.springframework.util.CollectionUtils.class,
				org.springframework.util.LinkedCaseInsensitiveMap.class,
				org.springframework.util.MimeType.class,
				org.springframework.web.servlet.function.support.RouterFunctionMapping.class,
				org.springframework.web.client.RestTemplate.class,
				org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver.class,
				org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport.class,
				org.springframework.web.socket.sockjs.transport.TransportHandlingSockJsService.class,
				org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.class,
				org.springframework.core.ReactiveAdapterRegistry.class
		}, typeNames = {
				"org.springframework.nativex.buildtools.StaticSpringFactories",
				"org.springframework.aop.Advisor$1",
				"org.springframework.core.annotation.AnnotationFilter$1",
				"org.springframework.core.annotation.AnnotationFilter$2",
				"org.springframework.core.annotation.PackagesAnnotationFilter",
				"org.springframework.core.annotation.TypeMappedAnnotations",
				"org.springframework.core.SerializableTypeWrapper",
				"org.springframework.core.SerializableTypeWrapper$SerializableTypeProxy",
				"org.springframework.context.annotation.ConfigurationClassEnhancer",
				"org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader",
				"org.springframework.format.annotation.DateTimeFormat$ISO",
				"org.springframework.http.codec.CodecConfigurerFactory",
				// For XML removal
				"org.springframework.http.codec.support.BaseDefaultCodecs"
		}, packageNames = {
				"org.springframework.core.env"
		}, initTime = InitializationTime.BUILD),
		proxyInfos = {
				// TODO For a regular web app this one is auto added now. But the function-netty app doesn't include endpoints and yet
				// needs this proxy - is there infrastructure that includes a mapping that we need to analyse (for auto synthannotation proxy
				// generation?). Currently the analysis is only done for app components, not library infrastructure.
				@ProxyInfo(types = {
						org.springframework.web.bind.annotation.RequestMapping.class,
						org.springframework.core.annotation.SynthesizedAnnotation.class
				}),
				@ProxyInfo(types = {
						org.springframework.context.annotation.Lazy.class,
						org.springframework.core.annotation.SynthesizedAnnotation.class
				})

		}

)
public class SpringFrameworkHints implements NativeImageConfiguration {
}