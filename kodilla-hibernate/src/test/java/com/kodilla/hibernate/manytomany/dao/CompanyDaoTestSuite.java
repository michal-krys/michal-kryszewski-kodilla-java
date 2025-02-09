package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @BeforeEach
    public void cleanDatabase() {
        companyDao.deleteAll();
        employeeDao.deleteAll();
    }

    @Test
    void testSaveManyToMany() {
        //given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //when
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //then
        assertNotEquals(0, softwareMachine);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //cleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }

    }

    @Test
    void testFindEmployeesByLastName() {
        //given
        Employee johnSmith = new Employee("John", "Smith");
        Employee carrieSmith = new Employee("Carrie", "Smith");
        Employee samSmith = new Employee("Sam", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee benClarckson = new Employee("Ben", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee trevorKovalsky = new Employee("Trevor", "Kovalsky");
        Employee georgeKovalsky = new Employee("George", "Kovalsky");
        Employee treyKovalsky = new Employee("Trey", "Kovalsky");

        employeeDao.save(johnSmith);
        employeeDao.save(carrieSmith);
        employeeDao.save(samSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(benClarckson);
        employeeDao.save(trevorKovalsky);
        employeeDao.save(georgeKovalsky);
        employeeDao.save(treyKovalsky);
        employeeDao.save(lindaKovalsky);

        //when
        List<Employee> resultSmith = employeeDao.retrieveEmployeeWithLastname("Smith");
        List<Employee> resultClarckson = employeeDao.retrieveEmployeeWithLastname("Clarckson");
        List<Employee> resultKovalsky = employeeDao.retrieveEmployeeWithLastname("Kovalsky");

        //then
        try{
            assertEquals(3, resultSmith.size());
            assertTrue(resultSmith.contains(johnSmith));
            assertTrue(resultSmith.contains(carrieSmith));
            assertTrue(resultSmith.contains(samSmith));
            assertEquals(2, resultClarckson.size());
            assertTrue(resultClarckson.contains(stephanieClarckson));
            assertTrue(resultClarckson.contains(benClarckson));
            assertEquals(4, resultKovalsky.size());
            assertTrue(resultKovalsky.contains(trevorKovalsky));
            assertTrue(resultKovalsky.contains(georgeKovalsky));
            assertTrue(resultKovalsky.contains(treyKovalsky));
            assertTrue(resultKovalsky.contains(lindaKovalsky));
        } finally {
            employeeDao.deleteAll();
        }
    }

    @Test
    void testFindCompaniesWithFirst3Letters() {
        //given
        Company softwareMachine = new Company("Software Machine");
        Company softTech = new Company("Soft Tech");
        Company softonLogic = new Company("Softon Logic");
        Company sofisticatedWare = new Company("SofisticatedWare");
        Company dataMaesters = new Company("Data Maesters");
        Company dataMiners = new Company("Data Miners");
        Company datonically = new Company("Datonically");
        Company greyMatter = new Company("Grey Matter");
        Company greysonInc = new Company("Greyson Inc.");

        companyDao.save(softwareMachine);
        companyDao.save(softTech);
        companyDao.save(softonLogic);
        companyDao.save(sofisticatedWare);
        companyDao.save(dataMaesters);
        companyDao.save(dataMiners);
        companyDao.save(datonically);
        companyDao.save(greyMatter);
        companyDao.save(greysonInc);

        //when
        List<Company> resultDAT = companyDao.retrieveCompaniesStartingWith("DAT");
        List<Company> resultSOF = companyDao.retrieveCompaniesStartingWith("SOF");
        List<Company> resultGRE = companyDao.retrieveCompaniesStartingWith("GRE");

        //then
        try{
            assertEquals(3, resultDAT.size());
            assertTrue(resultDAT.contains(datonically));
            assertTrue(resultDAT.contains(dataMaesters));
            assertTrue(resultDAT.contains(dataMiners));
            assertEquals(4, resultSOF.size());
            assertTrue(resultSOF.contains(softTech));
            assertTrue(resultSOF.contains(softonLogic));
            assertTrue(resultSOF.contains(sofisticatedWare));
            assertTrue(resultSOF.contains(softwareMachine));
            assertEquals(2, resultGRE.size());
            assertTrue(resultGRE.contains(greyMatter));
            assertTrue(resultGRE.contains(greysonInc));
        } finally {
            companyDao.deleteAll();
        }
    }
}
