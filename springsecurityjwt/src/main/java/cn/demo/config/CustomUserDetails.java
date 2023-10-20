package cn.demo.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    @Getter
    private User user;

    public CustomUserDetails() {
    }

    private CustomUserDetails(User u) {
        this.user = u;
    }

    @Data
    public static class User {
        private int uid;
        private String username;
        private String password;
        private List<String> authorities;

        public User(int uid, String username, String password, List<String> authorities) {
            this.uid = uid;
            this.username = username;
            this.password = password;
            this.authorities = authorities;
        }
    }

    public static Builder withBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int uid;
        private String username;
        private String password;
        private List<String> authorities;

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withUid(int uid) {
            this.uid = uid;
            return this;
        }

        public Builder withAuthorities(List<String> authorities) {
            this.authorities = authorities;
            return this;
        }

        public CustomUserDetails build() {
            User u = new User(this.uid, this.username, this.password, this.authorities);
            return new CustomUserDetails(u);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(this.user.getAuthorities());
    }

    public int getUid() {
        return this.user.getUid();
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
