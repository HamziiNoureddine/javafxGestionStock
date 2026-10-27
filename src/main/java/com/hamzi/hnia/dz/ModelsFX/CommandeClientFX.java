package com.hamzi.hnia.dz.ModelsFX;

import com.hamzi.hnia.dz.Models.Client;
import com.hamzi.hnia.dz.Models.CommandeClient;
import com.hamzi.hnia.dz.Models.LigneCommandeClient;
import com.hamzi.hnia.dz.Models.StatutCommande;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CommandeClientFX {
    private SimpleLongProperty id;

    private SimpleStringProperty numeroCommande; // Ex: "VENTE-2023-001"
    private SimpleStringProperty date;
    private SimpleStringProperty statut; // Enum: EN_ATTENTE, LIVREE, ANNULEE
    private SimpleStringProperty client;
    private SimpleStringProperty adresseClient;
    private SimpleStringProperty tel;

    public CommandeClientFX(CommandeClient cc) {

        this.id = new SimpleLongProperty(cc.getId());
        this.numeroCommande = new SimpleStringProperty(cc.getNumeroCommande());
        this.date = new SimpleStringProperty(cc.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.client = new SimpleStringProperty(cc.getClient().getNom());
        this.adresseClient =   new SimpleStringProperty(cc.getClient().getAdresse());
        this.tel =  new SimpleStringProperty(cc.getClient().getTel());
        this.statut =  new SimpleStringProperty(cc.getStatut().name());
    }

    public long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getNumeroCommande() {
        return numeroCommande.get();
    }

    public SimpleStringProperty numeroCommandeProperty() {
        return numeroCommande;
    }

    public void setNumeroCommande(String numeroCommande) {
        this.numeroCommande.set(numeroCommande);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getStatut() {
        return statut.get();
    }

    public SimpleStringProperty statutProperty() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut.set(statut);
    }

    public String getClient() {
        return client.get();
    }

    public SimpleStringProperty clientProperty() {
        return client;
    }

    public void setClient(String client) {
        this.client.set(client);
    }

    public String getAdresseClient() {
        return adresseClient.get();
    }

    public SimpleStringProperty adresseClientProperty() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient.set(adresseClient);
    }

    public String getTel() {
        return tel.get();
    }

    public SimpleStringProperty telProperty() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }
}
