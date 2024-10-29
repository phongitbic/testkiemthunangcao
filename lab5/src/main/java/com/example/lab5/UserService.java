package com.example.lab5;

import java.util.List;
import jakarta.persistence.*;
public class UserService {
    private EntityManager em;

    public List<User> findAll(){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql = "SELECT u FROM User u";
            Query q = em.createQuery(jpql);
            return q.getResultList();
        }finally {
            em.close();
        }
    }
    public void add(User u){
        EntityManager em = HibernateUtil.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }


    public void update(User u){
        EntityManager em = HibernateUtil.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public User findById(String id){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(User.class,id);
        }finally {
            em.close();
        }
    }

    public void deleteById(String id){
        EntityManager em = HibernateUtil.createEntityManager();
        try{
            User u = em.find(User.class, id);
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public static void main(String[] args){
        UserService service = new UserService();
        for(User u : service.findAll()){
            System.out.println(u.getId() + ":" + u.getPassword());
        }
    }
}
