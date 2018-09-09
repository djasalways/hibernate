package com.company.college.repositories;

import com.company.college.model.College;
import com.company.college.model.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CollegeRepository collegeRepo;

    @Test
    public void createStudent_findAll(){

        College vtu = new College();
        collegeRepo.save(vtu);

        Student shiv = new Student("shiva", "Bangalore", vtu);
        Student result = studentRepository.save(shiv);

        Student shivfasd = new Student("shia", "Bangalore", vtu);
        studentRepository.save(shivfasd);

        System.out.println(collegeRepo.findAll());
    }

    @Test
    public void createStudent_checkIfAdded(){

        College vtu = new College();
        collegeRepo.save(vtu);

        Student shiv = new Student("shiva", "Bangalore", vtu);
        Student result = studentRepository.save(shiv);

        assertEquals(result, shiv);

    }

   @Test
    public void fetchAllStudents(){

       College vtu = new College();
       collegeRepo.save(vtu);

       Student shiv = new Student("shiva", "Bangalore", vtu);
        Student shiva = new Student("neel", "Bangalore" , vtu);
        List<Student> iterable = Arrays.asList(shiv, shiva);
        studentRepository.saveAll(iterable);

        List<Student> s = studentRepository.findAll();

        assertTrue(s.containsAll(iterable));
    }

    @Test(expected = TransactionSystemException.class)
    public void checkConstraints(){

        College vtu = new College();
        collegeRepo.save(vtu);

        Student shiv = new Student("sh", "Bangalore", vtu);
        studentRepository.save(shiv);

    }


}