package com.webportal.app.domain;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jedlab.framework.spring.dao.BasePO;
import com.jedlab.framework.spring.security.SecurityUserContext;


/**
 *
 * @author Omid Pourhadi
 *
 */
@Entity
@Table(name = "sec_user")
public class User extends BasePO implements UserDetails, SecurityUserContext
{

    @Column(name="enabled")
    private boolean enabled;
    
    @Column(name="user_name")
    private String username;
    
    @Column(name="user_pass")
    private String password;

    public User()
    {
    }

    public User(Long id, boolean enabled, String username, String password)
    {
        setId(id);
        this.enabled = enabled;
        this.username = username;
        this.password = password;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword()
    {
        return password;
    }

    @Override
    public String getUsername()
    {
        return username;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

}