package com.employee.api.model;

import com.employee.api.model.enums.RoleEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "approle")
@NoArgsConstructor
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = 6410095741748080177L;

    private static final String PREFIX = "ROLE_";

    @Id
    @Column(name = "approle_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(unique = true, nullable = false)
    private String authority;

    @ManyToMany(mappedBy = "authorities")
    private Set<Candidate> users = new HashSet<>(0);

    public Role(RoleEnum authority) {
        this.authority = PREFIX + authority.toString();
    }

    @Override
    public String toString() {
        return authority;
    }

}

