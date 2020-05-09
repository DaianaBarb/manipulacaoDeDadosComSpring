package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class SubmissionId implements Serializable {
// Relacionamento n..n (lê-se muitos para muitos) - quando tabelas têm entre si relacionamento n..n, é necessário criar uma nova tabela com as chaves primárias das tabelas envolvidas, ficando assim uma chave composta, ou seja, formada por diversos campos chave de outras tabelas. A relacionamento então se reduz para uma relacionamento 1..n, sendo que o lado n ficará com a nova tabela criada. 
	@ManyToOne
    private Challenge challenge;

    @ManyToOne
    private User user;

}
