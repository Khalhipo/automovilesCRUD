/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bueno
 */
@Entity
@Table(name = "automoviles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Automoviles.findAll", query = "SELECT a FROM Automoviles a"),
    @NamedQuery(name = "Automoviles.findById", query = "SELECT a FROM Automoviles a WHERE a.id = :id"),
    @NamedQuery(name = "Automoviles.findByMarca", query = "SELECT a FROM Automoviles a WHERE a.marca = :marca"),
    @NamedQuery(name = "Automoviles.findByModelo", query = "SELECT a FROM Automoviles a WHERE a.modelo = :modelo"),
    @NamedQuery(name = "Automoviles.findByCv", query = "SELECT a FROM Automoviles a WHERE a.cv = :cv")})
public class Automoviles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cv")
    private int cv;

    public Automoviles() {
    }

    public Automoviles(Integer id) {
        this.id = id;
    }

    public Automoviles(Integer id, String marca, String modelo, int cv) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automoviles)) {
            return false;
        }
        Automoviles other = (Automoviles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Automoviles[ id=" + id + " ]";
    }
    
}
