package Thread;

/**
 * Created by xwz on 2/15/17.
 */
public class JavaVmStackOOM {
    private void dontStop() {
        while(true) {

        }
    }

    public void stackLeakByThread() {
        while(true) {
            Thread thread = new Thread(new Runnable(){
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVmStackOOM oom = new JavaVmStackOOM();
        oom.stackLeakByThread();
    }
}
