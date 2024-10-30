package ThiThu1.service;

import ThiThu1.entity.NhaXuatBan;
import ThiThu1.entity.Sach;
import ThiThu1.util.HibernateConf;
import org.hibernate.Session;

import java.util.List;

public class ServiceSach {

    private Session session;

    public ServiceSach(){
        session = HibernateConf.getFACTORY().openSession();
    }


    public List<Sach> getListSach(){
        return session.createQuery("FROM Sach ").list();
    }


    public List<NhaXuatBan> getListNhaXuatBan(){
        return session.createQuery("FROM NhaXuatBan ").list();
    }


    public NhaXuatBan getByIDNxb(Integer id){
        return session.find(NhaXuatBan.class,id);
    }


    public Sach getByIdSach(Integer idXoa){
        return session.find(Sach.class,idXoa);
    }

    public void Xoa(Sach sach){
        try{
            session.getTransaction().begin();
            session.delete(sach);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    public void Them(Sach sach){
        try{
            session.getTransaction().begin();
            session.persist(sach);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

}
