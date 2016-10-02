/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ravindu
 */
@Entity
@Table(name = "suplier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suplier.findAll", query = "SELECT s FROM Suplier s"),
    @NamedQuery(name = "Suplier.findBySupplierid", query = "SELECT s FROM Suplier s WHERE s.supplierid = :supplierid"),
    @NamedQuery(name = "Suplier.findBySuppliername", query = "SELECT s FROM Suplier s WHERE s.suppliername = :suppliername"),
    @NamedQuery(name = "Suplier.findBySupplierphone", query = "SELECT s FROM Suplier s WHERE s.supplierphone = :supplierphone"),
    @NamedQuery(name = "Suplier.findBySupplieradress", query = "SELECT s FROM Suplier s WHERE s.supplieradress = :supplieradress"),
    @NamedQuery(name = "Suplier.findBySupplierproductcategory", query = "SELECT s FROM Suplier s WHERE s.supplierproductcategory = :supplierproductcategory")})
public class Suplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "supplierid")
    private String supplierid;
    @Basic(optional = false)
    @Column(name = "suppliername")
    private String suppliername;
    @Basic(optional = false)
    @Column(name = "supplierphone")
    private String supplierphone;
    @Basic(optional = false)
    @Column(name = "supplieradress")
    private String supplieradress;
    @Basic(optional = false)
    @Column(name = "supplierproductcategory")
    private String supplierproductcategory;

    public Suplier() {
    }

    public Suplier(String supplierid) {
        this.supplierid = supplierid;
    }

    public Suplier(String supplierid, String suppliername, String supplierphone, String supplieradress, String supplierproductcategory) {
        this.supplierid = supplierid;
        this.suppliername = suppliername;
        this.supplierphone = supplierphone;
        this.supplieradress = supplieradress;
        this.supplierproductcategory = supplierproductcategory;
    }

    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getSupplierphone() {
        return supplierphone;
    }

    public void setSupplierphone(String supplierphone) {
        this.supplierphone = supplierphone;
    }

    public String getSupplieradress() {
        return supplieradress;
    }

    public void setSupplieradress(String supplieradress) {
        this.supplieradress = supplieradress;
    }

    public String getSupplierproductcategory() {
        return supplierproductcategory;
    }

    public void setSupplierproductcategory(String supplierproductcategory) {
        this.supplierproductcategory = supplierproductcategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierid != null ? supplierid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suplier)) {
            return false;
        }
        Suplier other = (Suplier) object;
        if ((this.supplierid == null && other.supplierid != null) || (this.supplierid != null && !this.supplierid.equals(other.supplierid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sample.model.Suplier[ supplierid=" + supplierid + " ]";
    }
    
}
