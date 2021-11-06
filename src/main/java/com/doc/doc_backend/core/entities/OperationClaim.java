package com.doc.doc_backend.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "operation_claims")
@Entity
public class OperationClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_claim_id")
    private int operation_claim_id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "operationClaim")
    private List<UserOperationClaim> userOperationClaims;
}
