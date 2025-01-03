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

    public String throwException(int a) throws Exception{
        if(a < 0){
            throw new Exception("Value should be greater than zero");
        }

        return String.valueOf(a);
    }

    public void checkTimeout() throws InterruptedException{
        System.out.println("I'm going to sleep");
        Thread.sleep(2000);
        System.out.println("Sleeping over");
    }
}
