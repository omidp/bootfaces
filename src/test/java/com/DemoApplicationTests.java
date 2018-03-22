package com;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.sql.JoinType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.webportal.app.ContainerConfig;
import com.webportal.app.JpaDataConfig;
import com.webportal.app.domain.Task;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = { JpaDataConfig.class, ContainerConfig.class })
@DataJpaTest
@Transactional()
@AutoConfigureTestDatabase(replace = Replace.NONE)
@PropertySource({"classpath:database.properties"})
public class DemoApplicationTests
{

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    @Commit
//    @Ignore
    public void populateDatasource()
    {
        for (int i = 0; i < 100; i++)
        {
//            Session sess = (Session) em.getDelegate();
//            Criteria criteria = sess.createCriteria(Task.class);
            //here is the difference
//            criteria.createCriteria("project", "p", JoinType.LEFT_OUTER_JOIN);
//            criteria.setProjection(Projections.rowCount());
//            criteria.uniqueResult();
            
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);
            Root<Task> from = cq.from(Task.class);
            cq.select(cb.count(from));
            from.fetch("project");
            Long singleResult = em.createQuery(cq).getSingleResult();
//            List<Task> resultList = em.createQuery(cq).getSingleResult();
//            resultList.forEach(item->{
//                System.out.println(item.getProject().getName());
//            });

        }
        em.flush();
    }

    @TestConfiguration
    static class Config
    {

        @Bean
        public DataSource datasource()
        {
            DriverManagerDataSource ds = new DriverManagerDataSource("jdbc:postgresql://127.0.0.1:5432/webportaldb", "webportal", "webportal");
            return ds;
        }

    }

}
