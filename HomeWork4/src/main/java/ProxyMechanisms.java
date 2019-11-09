import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public class ProxyMechanisms {
    //Реализуем мето cleanup
                public static void  cleanup(Object object, Set<String> fieldsToCleanup, Set<String> fieldsToOutput) throws IllegalAccessException {
                    //Проверяем условие на Map
                    if (object instanceof Map) {
                        Map objectAsMap = (Map)object;
                        //Проверяем на наличие исключения в fieldsToCleanup
                        for(String fild : fieldsToCleanup){
                            if(!objectAsMap.containsKey(fild))
                                //Если есть исключение то пробрасываем исключение IllegalAccessException как указанно в задании
                                throw new IllegalAccessException();
                        }
                        //Проверяем на наличие исключения в fieldsToOutput
                        for(String fild : fieldsToOutput){
                            if(!objectAsMap.containsKey(fild))
                                //Если есть исключение то пробрасываем исключение IllegalAccessException как указанно в задании
                                throw new IllegalAccessException();
                        }
                        for(String fild : fieldsToCleanup){
                            objectAsMap.remove(fild);
                        }
                        for(String fild : fieldsToOutput){
                            System.out.println(objectAsMap.get(fild));
                        }
                    }
                    else {
                       // ClassFields cl = new ClassFields();
                        Class<?> c = object.getClass();
                        Field[] declaredFields = c.getDeclaredFields();


                        for(String fild : fieldsToCleanup){
                            try {
                                c.getDeclaredField(fild);
                            } catch (NoSuchFieldException e) {
                                throw new IllegalAccessException();
                            }
                        }
                        for(String fild : fieldsToOutput){
                            try {
                                c.getDeclaredField(fild);
                            } catch (NoSuchFieldException e) {
                                throw new IllegalAccessException();
                            }
                        }
                        // Проверяем на примитивы и если есть задаем значение по умолчанию
                        for (Field field : declaredFields) {
                            field.setAccessible(true);
                            Class fieldType = field.getType();
                            String typeName = field.getType().getName();
                            if (fieldsToCleanup.contains(field.getName())) {
                                switch (typeName) {
                                    case "byte":
                                        field.setByte(object, (byte) 0);
                                        break;
                                    case "short":
                                        field.setShort(object, (short) 0);
                                        break;
                                    case "char":
                                        field.setChar(object, (char) '\u0000');
                                        break;
                                    case "int":
                                        field.setInt(object, 0);
                                        break;
                                    case "long":
                                        field.setFloat(object, 0);
                                        break;
                                    case "double":
                                        field.setDouble(object, 0);
                                        break;
                                    case "boolean":
                                        field.setBoolean(object, false);
                                        break;
                                    default:
                                        field.set(object, null);
                                        break;

                                }

                            }

                            if (fieldsToOutput.contains(field.getName())) {
                                System.out.println(field.get(object));
                            }

                        }
                    }
               // return

        }

}
