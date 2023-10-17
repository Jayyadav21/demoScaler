package com.example.demoscaler;

import com.example.demoscaler.inheritanceexamples.joinedTable.JTMentorRepository;
import com.example.demoscaler.inheritanceexamples.joinedTable.JTUserRepository;
import com.example.demoscaler.inheritanceexamples.joinedTable.Mentor;
import com.example.demoscaler.inheritanceexamples.joinedTable.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoScalerApplicationTests {
    @Autowired
    private JTUserRepository userRepository;
    @Autowired
    private JTMentorRepository mentorRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testDifferentInheritances(){
        User user=new User();
        user.setEmail("jay@scaler.com");
        user.setPassword("password");
        userRepository.save(user);

        Mentor mentor=new Mentor();
        mentor.setEmail("jay@naman.com");
        mentor.setPassword("pss");
        mentor.setNumberOfMentees(4);
        mentor.setNumberOfSession(50);
        mentorRepository.save(mentor);
    }
}
