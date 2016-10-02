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
import sample.exceptions.PreexistingEntityException;
import sample.model.Suplier;

/**
 *
 * @author Ravindu
 */
public class SuplierJpaController implements Serializable {

    public SuplierJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Suplier suplier) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(suplier);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSuplier(suplier.getSupplierid()) != null) {
                throw new PreexistingEntityException("Suplier " + suplier + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Suplier suplier) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            suplier = em.merge(suplier);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = suplier.getSupplierid();
                if (findSuplier(id) == null) {
                    throw new NonexistentEntityException("The suplier with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Suplier suplier;
            try {
                suplier = em.getReference(Suplier.class, id);
                suplier.getSupplierid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The suplier with id " + id + " no longer exists.", enfe);
            }
            em.remove(suplier);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Suplier> findSuplierEntities() {
        return findSuplierEntities(true, -1, -1);
    }

    public List<Suplier> findSuplierEntities(int maxResults, int firstResult) {
        return findSuplierEntities(false, maxResults, firstResult);
    }

    private List<Suplier> findSuplierEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Suplier.class));
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

    public Suplier findSuplier(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Suplier.class, id);
        } finally {
            em.close();
        }
    }

    public int getSuplierCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Suplier> rt = cq.from(Suplier.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
