package org.tsaap.competencies;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class representing a competence.
 */
@Entity
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 4, max = 256)
    private String name;

    private String description;

    @ManyToOne
    @NotNull
    private Category category;

    @ManyToOne
    @NotNull
    private Catalog catalog;

    @OneToOne
    @NotNull
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


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public ValueDomain getValueDomain() {
        return valueDomain;
    }

    public void setValueDomain(ValueDomain valueDomain) {
        this.valueDomain = valueDomain;
    }
}
