public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ThreadColours.ANSI_RED +"Hello from MYRunnable's implementationof run().");
    }
}
