package com.client.explorer.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("basic")
public class BasicConfiguration {
	
	private String serverHost;
	private String localhost;
	
	
	public String getServerHost() {
		return serverHost;
	}
	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}
	public String getLocalhost() {
		return localhost;
	}
	public void setLocalhost(String localhost) {
		this.localhost = localhost;
	}
	
	
}
