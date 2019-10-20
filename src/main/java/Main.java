public class Main {

    public static void main(String[] args) {
        System.out.println(ThreadColours.ANSI_PURPLE + "Hello from MAIN thread.");

        Thread anotherThread = new AnotherThread();
//        anotherThread.start();
        anotherThread.run();// We've got entirely different result, when we use run() instead od start().
        // It's running from the main thread,
        // which the main method is actually running on
        // You don't want to call run method directly
        anotherThread.setName("=== Another Thread ===");
        anotherThread.start();

        new Thread(() -> System.out.println(ThreadColours.ANSI_GREEN + "Hello from the anonymous class thread.")).start();

        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ThreadColours.ANSI_RED + "Hello from the anonymous class's implementation of run().");
                try {
                    anotherThread.join(2000);
                    System.out.println(ThreadColours.ANSI_RED + "AnotherThread terminated, or time out, so I'm running again!");
                } catch (InterruptedException e) {
                    System.out.println(ThreadColours.ANSI_RED + "I couldn't wait after all. I was interrupted. ");
                }
            }
        });
        myRunnableThread.start();
//        anotherThread.interrupt();

        System.out.println(ThreadColours.ANSI_PURPLE + "Hello again from MAIN thread.");
    }
}
