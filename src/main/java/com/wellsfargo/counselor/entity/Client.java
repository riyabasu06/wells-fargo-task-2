package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contactInfo;

    // Many Clients belong to one FinancialAdvisor
    @ManyToOne
    private FinancialAdvisor advisor;

    // One Client can have many Portfolios
    @OneToMany(mappedBy = "client")
    private List<Portfolio> portfolios;

    protected Client() {
    }

    public Client(String name, String contactInfo, FinancialAdvisor advisor) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.advisor = advisor;
    }

    public long getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public FinancialAdvisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(FinancialAdvisor advisor) {
        this.advisor = advisor;
    }
}
