package com.it100000.config.shiro;

import com.it100000.config.jwt.JwtFilter;
import com.it100000.config.shiro.filter.ShiroFormAuthenticationFilter;
import com.it100000.config.shiro.realm.CustomRealm;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置类
 *
 * @author 杨新杰
 * @date 2019/7/1022:54
 */
@Slf4j
@Configuration
public class ShiroConfiguration {

    /**
     * 功能说明:Shiro的Web过滤器Factory 命名:shiroFilter
     *
     * @author 杨新杰
     * @date 17:16 2019/5/27
     **/
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        log.info(">>>> 注入Shiro的shiroFilter" + ShiroFilterFactoryBean.class);
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 注入自定义拦截器
        Map<String, Filter> filters = new HashMap<>(16);
        filters.put("authc", shiroFormAuthenticationFilter());
        filters.put("jwt",jwtFilter());
        shiroFilterFactoryBean.setFilters(filters);

        shiroFilterFactoryBean.setLoginUrl("/login");
        //Shiro的核心安全接口,这个属性是必须的
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/**", "jwt");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 自定义拦截器
     *
     * @return SecurityManager
     * @author 杨新杰
     * @date 17:21 2019/5/27
     */
    @Bean
    public ShiroFormAuthenticationFilter shiroFormAuthenticationFilter() {
        return new ShiroFormAuthenticationFilter();
    }

    /**
     * JWT 拦截器
     *
     * @return jwt拦截器
     * @author 杨新杰
     * @date 17:21 2019/5/27
     */
    @Bean
    public JwtFilter jwtFilter(){
        return new JwtFilter();
    }

    /**
     * 功能说明:shiro核心管理器
     *
     * @return SecurityManager
     * @author 杨新杰
     * @date 17:21 2019/5/27
     **/
    @Bean(name = "securityManager")
    public SecurityManager securityManager(CustomRealm customRealm) {
        log.info(">>>> 注入Shiro的安全管理器" + ShiroFilterFactoryBean.class);
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关闭默认Session
        DefaultSessionStorageEvaluator evaluator = new DefaultSessionStorageEvaluator();
        evaluator.setSessionStorageEnabled(false);
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        subjectDAO.setSessionStorageEvaluator(evaluator);
        securityManager.setSubjectDAO(subjectDAO);

        securityManager.setRealm(customRealm);
        return securityManager;
    }


    /**
     * 功能说明:自定义的Realm
     *
     * @author 杨新杰
     * @date 17:24 2019/5/27
     **/
    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }

    /**
     * 功能说明:Shiro生命周期处理器
     *
     * @return LifecycleBeanPostProcessor
     * @author 杨新杰
     * @date 17:12 2019/5/27
     **/
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),
     * 需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)
     * 即可实现此功能
     *
     * @return DefaultAdvisorAutoProxyCreator
     * @author 杨新杰
     * @date 17:11 2019/5/27
     **/
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
