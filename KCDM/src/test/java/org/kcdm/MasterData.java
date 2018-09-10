package org.kcdm;

import com.google.auto.value.AutoValue;
import org.kcdm.student.model.Address;
import org.kcdm.student.model.Student;
import org.kcdm.users.model.User;

@AutoValue
public abstract class MasterData {
    public abstract Student getCityWatchStudent();
    public abstract Address getCityWatchAddress();
    public abstract User getCityWatchUser();

    public static Builder builder(){
        return new AutoValue_MasterData.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder{
        public abstract MasterData build();

        public abstract Builder setCityWatchStudent(Student student);
        public abstract Builder setCityWatchAddress(Address address);
        public abstract Builder setCityWatchUser(User user);

    }




}
