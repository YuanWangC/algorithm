public class HeapSituationTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("step 1: ");
        Thread.sleep(30000);
        byte[] arr = new byte[1024*1024*10];

        System.out.println("step 2: ");
        Thread.sleep(30000);
        arr = null;
        System.gc();

        System.out.println("step 3: ");
        Thread.sleep(100000L);
    }
}
