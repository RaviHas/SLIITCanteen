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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "orderitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderitem.findAll", query = "SELECT o FROM Orderitem o"),
    @NamedQuery(name = "Orderitem.findByOrderitemid", query = "SELECT o FROM Orderitem o WHERE o.orderitemid = :orderitemid"),
    @NamedQuery(name = "Orderitem.findByOrderid", query = "SELECT o FROM Orderitem o WHERE o.orderid = :orderid"),
    @NamedQuery(name = "Orderitem.findByProductid", query = "SELECT o FROM Orderitem o WHERE o.productid = :productid"),
    @NamedQuery(name = "Orderitem.findByItemquantity", query = "SELECT o FROM Orderitem o WHERE o.itemquantity = :itemquantity"),
    @NamedQuery(name = "Orderitem.findByProductname", query = "SELECT o FROM Orderitem o WHERE o.productname = :productname"),
    @NamedQuery(name = "Orderitem.findByProductprice", query = "SELECT o FROM Orderitem o WHERE o.productprice = :productprice")})
public class Orderitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orderitemid")
    private Integer orderitemid;
    @Basic(optional = false)
    @Column(name = "orderid")
    private int orderid;
    @Basic(optional = false)
    @Column(name = "productid")
    private String productid;
    @Basic(optional = false)
    @Column(name = "itemquantity")
    private int itemquantity;
    @Basic(optional = false)
    @Column(name = "productname")
    private String productname;
    @Basic(optional = false)
    @Column(name = "productprice")
    private double productprice;

    public Orderitem() {
    }

    public Orderitem(Integer orderitemid) {
        this.orderitemid = orderitemid;
    }

    public Orderitem(Integer orderitemid, int orderid, String productid, int itemquantity, String productname, double productprice) {
        this.orderitemid = orderitemid;
        this.orderid = orderid;
        this.productid = productid;
        this.itemquantity = itemquantity;
        this.productname = productname;
        this.productprice = productprice;
    }

    public Integer getOrderitemid() {
        return orderitemid;
    }

    public void setOrderitemid(Integer orderitemid) {
        this.orderitemid = orderitemid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public int getItemquantity() {
        return itemquantity;
    }

    public void setItemquantity(int itemquantity) {
        this.itemquantity = itemquantity;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getProductprice() {
        return productprice;
    }

    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderitemid != null ? orderitemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderitem)) {
            return false;
        }
        Orderitem other = (Orderitem) object;
        if ((this.orderitemid == null && other.orderitemid != null) || (this.orderitemid != null && !this.orderitemid.equals(other.orderitemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sample.model.Orderitem[ orderitemid=" + orderitemid + " ]";
    }
    
}
