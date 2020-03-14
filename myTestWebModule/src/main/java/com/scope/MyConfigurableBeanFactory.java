package com.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.*;
import org.springframework.core.ResolvableType;
import org.springframework.core.convert.ConversionService;
import org.springframework.util.StringValueResolver;

import java.beans.PropertyEditor;
import java.security.AccessControlContext;

public class MyConfigurableBeanFactory implements ConfigurableBeanFactory{
    @Override
    public void setParentBeanFactory(BeanFactory beanFactory) throws IllegalStateException {

    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

    }

    @Override
    public ClassLoader getBeanClassLoader() {
        return null;
    }

    @Override
    public void setTempClassLoader(ClassLoader classLoader) {

    }

    @Override
    public ClassLoader getTempClassLoader() {
        return null;
    }

    @Override
    public void setCacheBeanMetadata(boolean b) {

    }

    @Override
    public boolean isCacheBeanMetadata() {
        return false;
    }

    @Override
    public void setBeanExpressionResolver(BeanExpressionResolver beanExpressionResolver) {

    }

    @Override
    public BeanExpressionResolver getBeanExpressionResolver() {
        return null;
    }

    @Override
    public void setConversionService(ConversionService conversionService) {

    }

    @Override
    public ConversionService getConversionService() {
        return null;
    }

    @Override
    public void addPropertyEditorRegistrar(PropertyEditorRegistrar propertyEditorRegistrar) {

    }

    @Override
    public void registerCustomEditor(Class<?> aClass, Class<? extends PropertyEditor> aClass1) {

    }

    @Override
    public void copyRegisteredEditorsTo(PropertyEditorRegistry propertyEditorRegistry) {

    }

    @Override
    public void setTypeConverter(TypeConverter typeConverter) {

    }

    @Override
    public TypeConverter getTypeConverter() {
        return null;
    }

    @Override
    public void addEmbeddedValueResolver(StringValueResolver stringValueResolver) {

    }

    @Override
    public boolean hasEmbeddedValueResolver() {
        return false;
    }

    @Override
    public String resolveEmbeddedValue(String s) {
        return null;
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {

    }

    @Override
    public int getBeanPostProcessorCount() {
        return 0;
    }

    @Override
    public void registerScope(String s, Scope scope) {

    }

    @Override
    public String[] getRegisteredScopeNames() {
        return new String[0];
    }

    @Override
    public Scope getRegisteredScope(String s) {
        return null;
    }

    @Override
    public AccessControlContext getAccessControlContext() {
        return null;
    }

    @Override
    public void copyConfigurationFrom(ConfigurableBeanFactory configurableBeanFactory) {

    }

    @Override
    public void registerAlias(String s, String s1) throws BeanDefinitionStoreException {

    }

    @Override
    public void resolveAliases(StringValueResolver stringValueResolver) {

    }

    @Override
    public BeanDefinition getMergedBeanDefinition(String s) throws NoSuchBeanDefinitionException {
        return null;
    }

    @Override
    public boolean isFactoryBean(String s) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public void setCurrentlyInCreation(String s, boolean b) {

    }

    @Override
    public boolean isCurrentlyInCreation(String s) {
        return false;
    }

    @Override
    public void registerDependentBean(String s, String s1) {

    }

    @Override
    public String[] getDependentBeans(String s) {
        return new String[0];
    }

    @Override
    public String[] getDependenciesForBean(String s) {
        return new String[0];
    }

    @Override
    public void destroyBean(String s, Object o) {

    }

    @Override
    public void destroyScopedBean(String s) {

    }

    @Override
    public void destroySingletons() {

    }

    @Override
    public BeanFactory getParentBeanFactory() {
        return null;
    }

    @Override
    public boolean containsLocalBean(String s) {
        return false;
    }

    @Override
    public Object getBean(String s) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(String s, Class<T> aClass) throws BeansException {
        return null;
    }

    @Override
    public Object getBean(String s, Object... objects) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> aClass) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> aClass, Object... objects) throws BeansException {
        return null;
    }

    @Override
    public boolean containsBean(String s) {
        return false;
    }

    @Override
    public boolean isSingleton(String s) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public boolean isPrototype(String s) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public boolean isTypeMatch(String s, ResolvableType resolvableType) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public boolean isTypeMatch(String s, Class<?> aClass) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public Class<?> getType(String s) throws NoSuchBeanDefinitionException {
        return null;
    }

    @Override
    public String[] getAliases(String s) {
        return new String[0];
    }

    @Override
    public void registerSingleton(String s, Object o) {

    }

    @Override
    public Object getSingleton(String s) {
        return null;
    }

    @Override
    public boolean containsSingleton(String s) {
        return false;
    }

    @Override
    public String[] getSingletonNames() {
        return new String[0];
    }

    @Override
    public int getSingletonCount() {
        return 0;
    }

    @Override
    public Object getSingletonMutex() {
        return null;
    }
}
