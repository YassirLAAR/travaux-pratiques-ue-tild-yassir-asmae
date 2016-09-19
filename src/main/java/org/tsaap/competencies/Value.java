package org.tsaap.competencies;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Class representing a value in a domain
 */
@Entity
public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 4, max = 256)
    private String name;

    private String description;

    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private BigDecimal score;

    @NotNull
    private Integer order;

    @ManyToOne
    private ValueDomain valueDomain;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public ValueDomain getValueDomain() {
        return valueDomain;
    }

    public void setValueDomain(ValueDomain valueDomain) {
        this.valueDomain = valueDomain;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
