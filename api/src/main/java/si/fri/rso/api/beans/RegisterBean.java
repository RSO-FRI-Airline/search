package si.fri.rso.api.beans;

import si.fri.rso.models.entities.BaseEntity;
import si.fri.rso.models.entities.RegisterEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class RegisterBean<T extends RegisterEntity> {
    private Logger log;

    private final Class<T> _class;

    @PersistenceContext(unitName = "fri_airline")
    protected EntityManager em;

    public RegisterBean(Class<T> _class)
    {
        this._class = _class;
        log = Logger.getLogger(_class.getName());
    }

    @Transactional
    public List<T> get() {
        Query q = em.createQuery("SELECT o FROM "+_class.getSimpleName()+" o");
        return (List<T>)q.getResultList();
    }

    @Transactional
    public T get(String id){
        T obj = em.find(_class, id);
        if(_class == null) {
            throw new NotFoundException(_class.getName()+" " + id + " not found.");
        }
        em.refresh(obj);
        return obj;
    }

    @Transactional
    public T add(T obj) {
        if(obj == null){
            return null;
        }
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        obj.setCreatedAt(new Date());
        em.persist(obj);
        em.flush();
        tx.commit();
        return obj;
    }

    @Transactional
    public void remove(String id) {
        T obj = em.find(_class, id);
        if(obj == null) {
            throw new NotFoundException(_class.getName()+" " + id + " not found.");
        }
        em.remove(obj);
    }

    @Transactional
    public T update(String id, T s) {
        T obj = em.find(_class, id);
        if(obj == null) {
            throw new NotFoundException(_class.getName()+" " + id + " not found.");
        }
        obj.setUpdatedAt(new Date());
        s.setId(id);
        return em.merge(s);
    }
}