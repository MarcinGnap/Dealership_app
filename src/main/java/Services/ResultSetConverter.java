package Services;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;

public class ResultSetConverter {
    public static <T> ArrayList<T> resultSetToArrayList (ResultSet result, Class<T> classType) throws Exception {
        Field[] fields = classType.getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
        }
        ArrayList <T> list = new ArrayList<T>();
        while(result.next()){

            T dataTransferObject = classType.getConstructor().newInstance();

            for(Field field : fields){
                String name = field.getName();
                String value = result.getString(name);
                if(value == null){
                    continue;
                }
                field.set(dataTransferObject, field.getType().getConstructor(String.class).newInstance(value));
            }
            list.add(dataTransferObject);
        }
        return list;
    }
}
