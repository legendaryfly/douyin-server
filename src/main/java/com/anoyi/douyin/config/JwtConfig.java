package com.anoyi.douyin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "jwt-config")
@Component
public class JwtConfig {
    private String header;//: Authorization
    private String secret;//: mySecret
    private long expiration;//: 604800
    private String tokenHead;//: Bearer
    private String[] antPermitPaths;

    public String[] getAntPermitPaths() {
        return antPermitPaths;
    }

    public void setAntPermitPaths(String[] antPermitPaths) {
        this.antPermitPaths = antPermitPaths;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    public String getTokenHead() {
        return tokenHead;
    }

    public void setTokenHead(String tokenHead) {
        this.tokenHead = tokenHead;
    }
}