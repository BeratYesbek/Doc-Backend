package com.doc.doc_backend.core.entities;

import com.doc.doc_backend.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_operation_claims")
@AllArgsConstructor
@NoArgsConstructor
public class UserOperationClaim {

    @Id
    @Column(name = "user_operation_claim_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_operation_claim_id;

    @JoinColumn(name = "operation_claim_id")
    @ManyToOne
    private OperationClaim operationClaim;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;
}
