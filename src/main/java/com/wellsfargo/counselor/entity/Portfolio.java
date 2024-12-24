package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long portfolioId;

    @Column(nullable = false)
    private String portfolioName;

    // Many Portfolios belong to one Client
    @ManyToOne
    private Client client;

    // One Portfolio can have many Securities
    @OneToMany(mappedBy = "portfolio")
    private List<Security> securities;

    protected Portfolio() {
    }

    public Portfolio(String portfolioName, Client client) {
        this.portfolioName = portfolioName;
        this.client = client;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
