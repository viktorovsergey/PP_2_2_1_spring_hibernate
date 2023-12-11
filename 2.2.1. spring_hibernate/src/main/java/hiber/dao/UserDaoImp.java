package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
   public UserDaoImp() {
   }

   @Autowired
   private  SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {

      return  sessionFactory.getCurrentSession().createQuery(
              "from User", User.class).getResultList();
   }
   @Override
   public User getUserWithCar(int series) {
      return sessionFactory.getCurrentSession()
              .createQuery("FROM User where Car.series = : series", User.class)
              .setParameter("series", series).getSingleResult();
   }
}
