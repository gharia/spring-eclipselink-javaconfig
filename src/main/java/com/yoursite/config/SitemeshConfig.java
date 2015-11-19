package com.yoursite.config;

import org.apache.log4j.Logger;
import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.Sm2TagRuleBundle;

/**
 * Class for Sitemesh related configuration
 * @author Hemrajsinh Gharia
 *
 */
public class SitemeshConfig extends ConfigurableSiteMeshFilter {

	private static org.apache.log4j.Logger log = Logger.getLogger(SitemeshConfig.class);
	
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/*", "/WEB-INF/decorators/genericdecorator.jsp");
		builder.addTagRuleBundle(new Sm2TagRuleBundle());		
		log.debug("Sitemesh Configuration done!");
	}
}
