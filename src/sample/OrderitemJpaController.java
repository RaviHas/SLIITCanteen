/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import sample.exceptions.NonexistentEntityException;
import sample.model.Orderitem;

/**
 *
 * @author Ravindu
 */
public class OrderitemJpaController implements Serializable {

    public OrderitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Orderitem orderitem) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(orderitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Orderitem orderitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            orderitem = em.merge(orderitem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = orderitem.getOrderitemid();
                if (findOrderitem(id) == null) {
                    throw new NonexistentEntityException("The orderitem with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Orderitem orderitem;
            try {
                orderitem = em.getReference(Orderitem.class, id);
                orderitem.getOrderitemid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orderitem with id " + id + " no longer exists.", enfe);
            }
            em.remove(orderitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Orderitem> findOrderitemEntities() {
        return findOrderitemEntities(true, -1, -1);
    }

    public List<Orderitem> findOrderitemEntities(int maxResults, int firstResult) {
        return findOrderitemEntities(false, maxResults, firstResult);
    }

    private List<Orderitem> findOrderitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orderitem.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Orderitem findOrderitem(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orderitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrderitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orderitem> rt = cq.from(Orderitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
