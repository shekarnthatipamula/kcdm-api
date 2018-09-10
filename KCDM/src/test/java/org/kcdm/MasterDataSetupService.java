package org.kcdm;

import org.kcdm.student.dao.StudentDao;
import org.kcdm.student.model.Address;
import org.kcdm.student.model.Student;
import org.kcdm.users.dao.UserDao;
import org.kcdm.users.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.test.jdbc.JdbcTestUtils;

import javax.inject.Inject;
import javax.inject.Named;

@Service
public class MasterDataSetupService {
    @Inject
    @Named("studentDao")
    private StudentDao studentDao;

    @Inject
    @Named("userDao")
    private UserDao userDao;

    public void cleanHierarchy(final JdbcTemplate jdbcTemplate){

        JdbcTestUtils.deleteFromTables(jdbcTemplate,"kc_student_address");
        JdbcTestUtils.deleteFromTables(jdbcTemplate,"kc_student");
        //JdbcTestUtils.deleteFromTables(jdbcTemplate,"users");
    }

    public MasterData crateHierarchy() throws Exception {
        return  saveHierarchy(buildHierarchy());
    }
    private MasterData buildHierarchy(){
        final MasterData.Builder builder=MasterData.builder();

        Student student=Student.builder()
                .age(24)
                .name("Shekhar").build();
        Address address=Address.builder().hno("2-98 A").street("Newtown").village("motlampally").town("atmakur").mandal("atmakur").district("Wanaparthy").state("Telangana").pincode("509131").build();
        builder.setCityWatchStudent(student);
        builder.setCityWatchAddress(address);

        User user=userDao.getActiveUser("mukesh");
        builder.setCityWatchUser(user);

//        User user=User.builder()
//                .fullName("Shekhar T")
//                .username("shekhar")
//                .country("India")
//                .role("STUDENT")
//                .enabled((short) 1)
//                .password("$2a$10$N0eqNiuikWCy9ETQ1rdau.XEELcyEO7kukkfoiNISk/9F7gw6eB0W")
//                .build();
//
//        builder.setCityWatchUser(user);


        return builder.build();
    }
    private MasterData saveHierarchy(MasterData masterData) throws Exception {
        Student student=masterData.getCityWatchStudent();
        Address address=masterData.getCityWatchAddress();
        student.setAddress(address);
        studentDao.store(student);

        User testUser=masterData.getCityWatchUser();

//        if(user!=null&&"Mukesh Sharma".equals(user.getFullName())){
//            return masterData;
//        }
//        else {
//            throw new Exception("User not found");
//        }
        return masterData;
    }

}
