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
@Table(name = "food")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Food.findAll", query = "SELECT f FROM Food f"),
    @NamedQuery(name = "Food.findByProductid", query = "SELECT f FROM Food f WHERE f.productid = :productid"),
    @NamedQuery(name = "Food.findByProductcategory", query = "SELECT f FROM Food f WHERE f.productcategory = :productcategory"),
    @NamedQuery(name = "Food.findByProductname", query = "SELECT f FROM Food f WHERE f.productname = :productname"),
    @NamedQuery(name = "Food.findBySupliername", query = "SELECT f FROM Food f WHERE f.supliername = :supliername"),
    @NamedQuery(name = "Food.findByProductprice", query = "SELECT f FROM Food f WHERE f.productprice = :productprice"),
    @NamedQuery(name = "Food.findByQuntity", query = "SELECT f FROM Food f WHERE f.quntity = :quntity"),
    @NamedQuery(name = "Food.findByExpiredate", query = "SELECT f FROM Food f WHERE f.expiredate = :expiredate"),
    @NamedQuery(name = "Food.findBySuplierdate", query = "SELECT f FROM Food f WHERE f.suplierdate = :suplierdate")})
public class Food implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "productid")
    private String productid;
    @Basic(optional = false)
    @Column(name = "productcategory")
    private String productcategory;
    @Basic(optional = false)
    @Column(name = "productname")
    private String productname;
    @Basic(optional = false)
    @Column(name = "supliername")
    private String supliername;
    @Basic(optional = false)
    @Column(name = "productprice")
    private double productprice;
    @Basic(optional = false)
    @Column(name = "quntity")
    private int quntity;
    @Basic(optional = false)
    @Column(name = "expiredate")
    private String expiredate;
    @Basic(optional = false)
    @Column(name = "suplierdate")
    private String suplierdate;

    public Food() {
    }

    public Food(String productid) {
        this.productid = productid;
    }

    public Food(String productid, String productcategory, String productname, String supliername, double productprice, int quntity, String expiredate, String suplierdate) {
        this.productid = productid;
        this.productcategory = productcategory;
        this.productname = productname;
        this.supliername = supliername;
        this.productprice = productprice;
        this.quntity = quntity;
        this.expiredate = expiredate;
        this.suplierdate = suplierdate;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductcategory() {
        return productcategory;
    }

    public void setProductcategory(String productcategory) {
        this.productcategory = productcategory;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getSupliername() {
        return supliername;
    }

    public void setSupliername(String supliername) {
        this.supliername = supliername;
    }

    public double getProductprice() {
        return productprice;
    }

    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

    public int getQuntity() {
        return quntity;
    }

    public void setQuntity(int quntity) {
        this.quntity = quntity;
    }

    public String getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(String expiredate) {
        this.expiredate = expiredate;
    }

    public String getSuplierdate() {
        return suplierdate;
    }

    public void setSuplierdate(String suplierdate) {
        this.suplierdate = suplierdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productid != null ? productid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Food)) {
            return false;
        }
        Food other = (Food) object;
        if ((this.productid == null && other.productid != null) || (this.productid != null && !this.productid.equals(other.productid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sample.model.Food[ productid=" + productid + " ]";
    }
    
}
