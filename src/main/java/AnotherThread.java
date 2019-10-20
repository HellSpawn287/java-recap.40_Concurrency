public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println(ThreadColours.ANSI_BLUE + "Hello from " + currentThread().getName() + ".");
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            System.out.println(ThreadColours.ANSI_BLUE + "Another threat woke me up");
            return;
        }

        System.out.println(ThreadColours.ANSI_BLUE + "Three seconds have passed and I'm awake!");
    }
}
