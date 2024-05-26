package hu.dev.hrm;

import hu.dev.hrm.model.User;
import hu.dev.hrm.repository.UserRepository;
import hu.dev.hrm.type.Child;
import hu.dev.hrm.type.Children;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
public class UserRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenSave_thenReturnUser() {
        User us = new User("test", "test@test.hu", "test123", new Children(List.of(new Child("apple", 14))));
        entityManager.persist(us);
        entityManager.flush();

        User res = userRepository.findById(us.getId()).orElseThrow();

        assertThat(us.getUsername()).isEqualTo(res.getUsername());
    }
}
