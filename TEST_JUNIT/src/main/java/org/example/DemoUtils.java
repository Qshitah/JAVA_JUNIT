package org.example;

public class DemoUtils {

    private String academy = "Test";
    private String academyDuplicate = academy;

    public int add(int a , int b){
        return a + b;
    }

    public Object checkNull(Object o){
        if(o == null){
            return null;
        }
        return o;
    }

    public String getAcademy() {
        return academy;
    }

    public String getAcademyDuplicate() {
        return academyDuplicate;
    }
}
