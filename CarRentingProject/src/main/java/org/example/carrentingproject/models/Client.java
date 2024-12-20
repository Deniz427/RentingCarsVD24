package org.example.carrentingproject.models;

import javax.persistence.*;

@Entity
@Table(name = "clients_table")
public class Client extends User{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "selected_firm_id")
    private Firm selectedFirm;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    // Задължителен празен конструктор за Hibernate
    public Client() {
        super(); // Важно: извиква се конструкторът на класа-родител
    }

    public Client(String name, String email, String password, String accountType) {
        super(name, email, password, accountType);
        this.clientName = name;
    }

    public Firm getSelectedFirm() {
        return selectedFirm;
    }

    public void setSelectedFirm(Firm selectedFirm) {
        this.selectedFirm = selectedFirm;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}