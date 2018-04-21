import java.util.Random;

public class ThreadLocalTest02 {
    public static void main(String[] args) {
        for(int i=0; i<2; i++){
            new Thread(new Runnable() {
                public void run() {
                    int data = new Random().nextInt();
                    MyThreadScpoeData.getThreadInstance().setName("name" + data);
                    MyThreadScpoeData.getThreadInstance().setAge(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A{
        public void get(){
            MyThreadScpoeData myData = MyThreadScpoeData.getThreadInstance();
            System.out.println(Thread.currentThread().getName() + "-----" +  myData.getName() + ":" + myData.getAge());
        }




    }
    static class B{
        public void get(){
            MyThreadScpoeData myData = MyThreadScpoeData.getThreadInstance();
            System.out.println(Thread.currentThread().getName() + "-----" +  myData.getName() + ":" + myData.getAge());
        }
    }

}

class MyThreadScpoeData {
    private MyThreadScpoeData() {
    }
    //饱汉模式
//    public static MyThreadScpoeData getThreadInstance(){
//        return instance;
//    }
//    private static MyThreadScpoeData instance = new MyThreadScpoeData();

    private static MyThreadScpoeData instance = null;
    private static ThreadLocal<MyThreadScpoeData> map = new ThreadLocal<MyThreadScpoeData>();
    public /*synchronized*/ static MyThreadScpoeData getThreadInstance() {
        MyThreadScpoeData instance = map.get();
        if(instance == null) {
            instance = new MyThreadScpoeData();
            map.set(instance);
        }
        return instance;
    }

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
