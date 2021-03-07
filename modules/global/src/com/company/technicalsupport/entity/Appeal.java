package com.company.technicalsupport.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(name = "TECHNICALSUPPORT_APPEAL")
@Entity(name = "technicalsupport_Appeal")
@NamePattern("%s|description")
public class Appeal extends StandardEntity {
    private static final long serialVersionUID = -8299407662621236302L;

    @Column(name = "DATE_CREATE")
    private LocalDate dateCreate;

    @NotNull
    @Column(name = "PRODUCT", nullable = false)
    private String product;

    @NotNull
    @Lob
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Lob
    @Column(name = "ANSWER")
    private String answer;

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

}