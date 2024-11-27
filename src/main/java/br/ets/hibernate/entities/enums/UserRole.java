package br.ets.hibernate.entities.enums;

public enum UserRole {
    ROLE_ADMIN("admin"),
    ROLE_DEFAULT("default");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public static UserRole fromString(String value) {
        for (UserRole userRole : UserRole.values()){
            if (userRole.name().equalsIgnoreCase(value)) {
                return userRole;
            }
        }
        throw new IllegalArgumentException("Role inválida!");
    }
}

