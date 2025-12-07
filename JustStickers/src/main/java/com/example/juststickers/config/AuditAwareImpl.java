package com.example.juststickers.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.juststickers.entity.Customer;

@Component("auditorAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() ||
                authentication.getPrincipal().equals("anonymousUser")) {
            return Optional.of("Anonymous user");
        }
        Object principal = authentication.getPrincipal();
        String username;

        if (principal instanceof Customer customer) {
            username = customer.getEmail();
        } else {
            username = principal.toString(); // fallback
        }

        return Optional.of(username);
    }
}